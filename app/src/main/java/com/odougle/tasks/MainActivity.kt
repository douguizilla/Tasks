package com.odougle.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.tasks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val handler: MyHandler by lazy {MyHandler(this)}
    private var thread: MyThread? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            thread = MyThread(handler)
            thread?.start()
            binding.btnStart.isEnabled = false
        }
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacksAndMessages(null)
        thread?.interrupt()
    }

}