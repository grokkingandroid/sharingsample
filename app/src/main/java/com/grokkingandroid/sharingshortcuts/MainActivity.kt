package com.grokkingandroid.sharingshortcuts

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)
        setupPresenter()
    }

    override fun onStart() {
        super.onStart()
        createFakeShares()
    }

    private fun setupPresenter() {
        val interactor = SharingInteractor(AndroidShortcutCreator(this.applicationContext))
        presenter = MainPresenter(interactor)
        presenter.start()
    }

    private fun createFakeShares() {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "image/png"
        startActivity(Intent.createChooser(sharingIntent, "Share now"))
    }
}

