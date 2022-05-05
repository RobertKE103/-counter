package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    companion object {
        const val COUNT_KEY = "COUNT_KEY"
    }
    private var cnt = 0
        set(number) {
            field = number
            binding.Number.text = number.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun addNumber(view: View) {
        cnt++
    }
    
    override fun onSaveInstanceState(outState: Bundle) { // сохраняю
        super.onSaveInstanceState(outState)
        Log.i("My Log", "сохранил")

        outState.putInt(COUNT_KEY, cnt)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // восстонавиливаю
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("My Log", "восстановил")

        cnt = savedInstanceState.getInt(COUNT_KEY)
    }
}