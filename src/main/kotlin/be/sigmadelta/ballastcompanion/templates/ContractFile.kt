package be.sigmadelta.ballastcompanion.templates

fun getContractFile(prefix: String) =
"""package be.sigmadelta.ballastcompanion

import androidx.compose.runtime.Immutable


object ${prefix}ScreenContract {

    @Immutable
    data class State()

    sealed interface Inputs {}

    sealed interface Events {}
}    
"""