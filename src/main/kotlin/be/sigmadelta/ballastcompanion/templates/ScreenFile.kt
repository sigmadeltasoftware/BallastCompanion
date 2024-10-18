package be.sigmadelta.ballastcompanion.templates

fun getScreenFile(prefix: String) =
"""package be.sigmadelta.ballastcompanion

import androidx.compose.runtime.Composable
import be.sigmadelta.ballastcompanion.${prefix}ScreenContract

@Composable
fun ${prefix}Screen(
    state: ${prefix}ScreenContract.State,
    postInput: (${prefix}ScreenContract.Inputs) -> Unit
) {

}
"""