package be.sigmadelta.ballastcompanion.templates

fun getEventHandlerFile(prefix: String) =
"""package be.sigmadelta.ballastcompanion

import com.copperleaf.ballast.EventHandler
import com.copperleaf.ballast.EventHandlerScope

typealias ${prefix}ScreenContractEventHandler = EventHandler<${prefix}ScreenContract.Inputs, ${prefix}ScreenContract.Events, ${prefix}ScreenContract.State>
typealias ${prefix}ScreenContractEventHandlerScope = EventHandlerScope<${prefix}ScreenContract.Inputs, ${prefix}ScreenContract.Events, ${prefix}ScreenContract.State>

class ${prefix}ScreenEventHandler : ${prefix}ScreenContractEventHandler {
    override suspend fun ${prefix}ScreenContractEventHandlerScope.handleEvent(event: ${prefix}ScreenContract.Events) = try {
        when (event) {
            
        }
        Unit
    } catch(e: Exception) {
        e.printStackTrace()
    }
}    
"""