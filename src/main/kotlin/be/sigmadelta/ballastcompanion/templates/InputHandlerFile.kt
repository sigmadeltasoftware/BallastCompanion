package be.sigmadelta.ballastcompanion.templates

fun getInputHandlerFile(prefix: String) =
"""package be.sigmadelta.ballastcompanion

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import com.copperleaf.ballast.inputHandler

typealias ${prefix}ContractInputHandler = InputHandler<${prefix}Contract.Inputs, ${prefix}Contract.Events, ${prefix}Contract.State>
typealias ${prefix}ContractInputHandlerScope = InputHandlerScope<${prefix}Contract.Inputs, ${prefix}Contract.Events, ${prefix}Contract.State>

class ${prefix}InputHandler : ${prefix}ContractInputHandler {
    override suspend fun ${prefix}ContractInputHandlerScope.handleInput(input: ${prefix}Contract.Inputs) {
        when (input) {
            
        }
    }
}    
"""