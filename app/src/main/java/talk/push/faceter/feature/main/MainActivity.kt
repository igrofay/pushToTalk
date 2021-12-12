package talk.push.faceter.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import talk.push.faceter.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMicrophonePermission()

    }
}