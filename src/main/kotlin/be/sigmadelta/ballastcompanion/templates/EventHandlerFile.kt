package be.sigmadelta.ballastcompanion.templates

fun getEventHandlerFile(prefix: String) =
"""package be.sigmadelta.ballastcompanion

import com.copperleaf.ballast.EventHandler
import com.copperleaf.ballast.EventHandlerScope

typealias ${prefix}ContractEventHandler = EventHandler<${prefix}Contract.Inputs, ${prefix}Contract.Events, ${prefix}Contract.State>
typealias ${prefix}ContractEventHandlerScope = EventHandlerScope<${prefix}Contract.Inputs, ${prefix}Contract.Events, ${prefix}Contract.State>

class ${prefix}EventHandler : ${prefix}ContractEventHandler {
    override suspend fun ${prefix}ContractEventHandlerScope.handleEvent(event: ${prefix}Contract.Events) {
        when (event) {
            
        }
    }
}    
"""