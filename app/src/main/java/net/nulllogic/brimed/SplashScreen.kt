package net.nulllogic.brimed

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splashscreen)

        // Hide status bar
        val g: Window = window
        g.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        // Create an executor that executes tasks in a background thread.
        val backgroundExecutor: ScheduledExecutorService =
            Executors.newSingleThreadScheduledExecutor()
        // Execute a task in the background thread after 3 seconds.
        backgroundExecutor.schedule({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

//          @TODO add recursive builder
            try {
                val data = assets.list("data")
                println(data)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }, 3, TimeUnit.SECONDS)


    }
}