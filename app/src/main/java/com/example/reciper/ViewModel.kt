package com.example.reciper
import android.media.Image
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    private val images = listOf<com.example.reciper.Image>(
        Image("Sign up image", R.drawable._303623835_h_1024x700))

    val currentImages: List<com.example.reciper.Image>
    get() = images
}