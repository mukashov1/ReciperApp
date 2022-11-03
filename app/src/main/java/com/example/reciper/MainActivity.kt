package com.example.reciper

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.doszhan_second_page)
        val check:Button = findViewById(R.id.button)
        check.setOnClickListener() {
            val toast = Toast.makeText(this ,"Something",Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    // Baha durys bop tur ma?
    // durystap isteik dalwe
}