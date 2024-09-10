package be.sigmadelta.ballastcompanion.templates

fun getViewModelFile(prefix: String) =
"""package be.sigmadelta.ballastcompanion

import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.build
import com.copperleaf.ballast.core.BasicViewModel
import com.copperleaf.ballast.dispatchers
import com.copperleaf.ballast.withViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


class ${prefix}ViewModel(
    viewModelCoroutineScope: CoroutineScope,
) : BasicViewModel<
        ${prefix}Contract.Inputs,
        ${prefix}Contract.Events,
        ${prefix}Contract.State
        >(
    config = BallastViewModelConfiguration.Builder()
        .withViewModel(
            initialState = ${prefix}Contract.State(),
            inputHandler = ${prefix}InputHandler(),
        )
        .dispatchers(
            inputsDispatcher = Dispatchers.Main.immediate,
            eventsDispatcher = Dispatchers.Main.immediate,
            sideJobsDispatcher = Dispatchers.Default,
            interceptorDispatcher = Dispatchers.Default
        )
        .build(),
    eventHandler = ${prefix}EventHandler(),
    coroutineScope = viewModelCoroutineScope,
)
"""