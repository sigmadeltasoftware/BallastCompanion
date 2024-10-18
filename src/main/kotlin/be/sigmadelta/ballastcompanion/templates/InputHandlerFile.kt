package be.sigmadelta.ballastcompanion.templates

fun getInputHandlerFile(prefix: String) =
"""package be.sigmadelta.ballastcompanion

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope

typealias ${prefix}ScreenContractInputHandler = InputHandler<${prefix}ScreenContract.Inputs, ${prefix}ScreenContract.Events, ${prefix}ScreenContract.State>
typealias ${prefix}ScreenContractInputHandlerScope = InputHandlerScope<${prefix}ScreenContract.Inputs, ${prefix}ScreenContract.Events, ${prefix}ScreenContract.State>

class ${prefix}ScreenInputHandler : ${prefix}ScreenContractInputHandler {
    override suspend fun ${prefix}ScreenContractInputHandlerScope.handleInput(input: ${prefix}ScreenContract.Inputs) = try {
        when (input) {
            
        }
        Unit
    } catch(e: Exception) {
        e.printStackTrace()
    }
}    
"""