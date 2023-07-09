package com.tah.housewarming.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tah.housewarming.data.PinterestService
import kotlinx.coroutines.launch

class DashboardViewModel(private val service: PinterestService) : ViewModel() {

    fun setup() {

        viewModelScope.launch {
            val userPins = service.getPins("833869687245603658")

            val code = userPins.code()

            when(code) {
                400 -> {}
                500 -> {}
                else -> {}
            }
        }

    }

}