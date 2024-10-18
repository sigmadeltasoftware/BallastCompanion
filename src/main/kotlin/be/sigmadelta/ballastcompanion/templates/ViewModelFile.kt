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


class ${prefix}ScreenViewModel(
    viewModelCoroutineScope: CoroutineScope,
) : BasicViewModel<
        ${prefix}ScreenContract.Inputs,
        ${prefix}ScreenContract.Events,
        ${prefix}ScreenContract.State
        >(
    config = BallastViewModelConfiguration.Builder()
        .withViewModel(
            initialState = ${prefix}ScreenContract.State(),
            inputHandler = ${prefix}ScreenInputHandler(),
        )
        .dispatchers(
            inputsDispatcher = Dispatchers.Main.immediate,
            eventsDispatcher = Dispatchers.Main.immediate,
            sideJobsDispatcher = Dispatchers.Default,
            interceptorDispatcher = Dispatchers.Default
        )
        .build(),
    eventHandler = ${prefix}ScreenEventHandler(),
    coroutineScope = viewModelCoroutineScope,
)
"""