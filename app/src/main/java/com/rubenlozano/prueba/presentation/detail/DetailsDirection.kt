package com.rubenlozano.prueba.presentation.detail

import com.rubenlozano.prueba.utils.navigation.AppNavigator
import javax.inject.Inject

interface DetailsDirection {
    suspend fun navigateBack()
}

class DetailsDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
): DetailsDirection {
    override suspend fun navigateBack() {
        appNavigator.back()
    }

}