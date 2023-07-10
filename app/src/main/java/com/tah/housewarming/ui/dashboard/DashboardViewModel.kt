package com.tah.housewarming.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tah.housewarming.data.Status
import com.tah.housewarming.data.pinterest.Pin
import com.tah.housewarming.data.pinterest.PinterestRepository
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: PinterestRepository) : ViewModel() {

    private val _userPinsUIState = MutableLiveData<UserPinsUIState>()
    val userPinsUIState: LiveData<UserPinsUIState> = _userPinsUIState

    init {
        setup()
    }

    private fun setup() {
        viewModelScope.launch {
            _userPinsUIState.value = UserPinsUIState(status = Status.RUNNING)

            try {
                val pin = repository.getPin("833869687245603658")

                val userPins = repository.getUserPins("barbieritata")

                _userPinsUIState.value = UserPinsUIState(status = Status.SUCCESS, userPins)
            } catch (e: Exception) {
                e.message
            }

        }
    }

}

data class UserPinsUIState(
    val status: Status,
    val pins: List<Pin>? = null
)