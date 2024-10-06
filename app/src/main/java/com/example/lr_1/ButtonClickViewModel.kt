package com.example.lr_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ButtonClickViewModel : ViewModel() {

    private val _buttonText = MutableLiveData<String>()
    val buttonText: LiveData<String> get() = _buttonText

    fun updateTextFromXml(newText: String) {
        _buttonText.value = newText
    }
    fun updateText(newText: String) {
        _buttonText.value = newText
    }
}