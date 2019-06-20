package com.grokkingandroid.sharingshortcuts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ShareTargetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.target_screen)
        debugIntent(intent, findViewById(R.id.container))
    }
}