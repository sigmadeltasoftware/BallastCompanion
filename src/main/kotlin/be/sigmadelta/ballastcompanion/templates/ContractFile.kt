package be.sigmadelta.ballastcompanion.templates

fun getContractFile(prefix: String) =
"""package be.sigmadelta.ballastcompanion

import androidx.compose.runtime.Immutable


object ${prefix}Contract {

    @Immutable
    data class State()

    sealed interface Inputs {}

    sealed interface Events {}
}    
"""