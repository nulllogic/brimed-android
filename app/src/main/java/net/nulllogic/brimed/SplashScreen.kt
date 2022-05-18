package net.nulllogic.brimed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        // Create an executor that executes tasks in a background thread.
        val backgroundExecutor: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
        // Execute a task in the background thread after 3 seconds.
        backgroundExecutor.schedule({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 3, TimeUnit.SECONDS)


    }
}