package com.itram.observeconnectionstatus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var connectivityObserver: ConnectivityObserver
    private lateinit var message: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message = findViewById(R.id.message)

        connectivityObserver = NetworkConnectivityObserver(applicationContext)

        lifecycleScope.launch {
            connectivityObserver.observe().collect {
                message.text = it.name
            }
        }
    }
}