package com.tah.housewarming.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tah.housewarming.data.pinterest.PinterestRepository
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: PinterestRepository) : ViewModel() {

    init {
        setup()
    }

    private fun setup() {
        viewModelScope.launch {
            val pin = repository.getPin("833869687245603658")

            pin?.let {
                println(pin.images)
            }
        }
    }

}