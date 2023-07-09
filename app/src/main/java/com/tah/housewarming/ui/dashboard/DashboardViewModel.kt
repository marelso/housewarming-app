package com.tah.housewarming.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tah.housewarming.data.PinterestRepository
import com.tah.housewarming.data.PinterestService
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: PinterestRepository) : ViewModel() {

    fun setup() {

        viewModelScope.launch {
            val pin = repository.getPin("833869687245603658")

            pin?.let {
                println(pin.images)
            }
        }

    }

}