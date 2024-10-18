package be.sigmadelta.ballastcompanion

import be.sigmadelta.ballastcompanion.templates.*
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.ui.Messages
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiManager
import com.intellij.util.IncorrectOperationException

class PrefixActionProvider: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val selectedDir = e.getData(CommonDataKeys.VIRTUAL_FILE)

        if (selectedDir == null || !selectedDir.isDirectory) {
            Messages.showErrorDialog("Please select a directory", "Error")
            return
        }

        val prefix = Messages.showInputDialog(
            """Enter the desired prefix.
                f.e.: With prefix 'Example', you will generate:
                - [Example]Screen
                - [Example]ScreenViewModel
                - [Example]...
            """.trimIndent(),
            "Ballast Template Generator",
            Messages.getQuestionIcon(),
        )

        if (prefix.isNullOrEmpty()) {
            // User cancelled operation
            return
        }
        val project = e.project ?: return

        val directory = PsiManager.getInstance(project).findDirectory(selectedDir)
        directory ?: return

        val fileMap = mapOf(
            Pair("${prefix}Screen.kt", getScreenFile(prefix)),
            Pair("${prefix}ScreenContract.kt", getContractFile(prefix)),
            Pair("${prefix}ScreenInputHandler.kt", getInputHandlerFile(prefix)),
            Pair("${prefix}ScreenEventHandler.kt", getEventHandlerFile(prefix)),
            Pair("${prefix}ScreenViewModel.kt", getViewModelFile(prefix))
        )

        WriteCommandAction.runWriteCommandAction(project) {
            try {
                fileMap.forEach {
                    val (fileName, fileContent) = it
                    val newFile = PsiFileFactory.getInstance(project).createFileFromText(
                        fileName,
                        fileContent
                    )
                    directory.add(newFile)
                }

                Messages.showInfoMessage("Files created successfully!", "Success")
            } catch (e: IncorrectOperationException) {
                // Directory cannot add --> Filename present?
                Messages.showErrorDialog("Error occurred during file creation: " + e.message, "Error")
            } catch (e: Exception) {
                Messages.showErrorDialog("Error occurred during file creation: " + e.message, "Error")
            }
        }
    }

    override fun update(e: AnActionEvent) {
        val selectedDir = e.getData(CommonDataKeys.VIRTUAL_FILE)
        e.presentation.isEnabledAndVisible = selectedDir != null && selectedDir.isDirectory
    }
}