package com.grokkingandroid.sharingshortcuts

import android.content.Intent
import android.view.ViewGroup
import android.widget.TextView

fun debugIntent(intent: Intent, container: ViewGroup) {
    val txtAction = container.findViewById<TextView>(R.id.txtAction)
    val txtCategories = container.findViewById<TextView>(R.id.txtCategories)
    val txtExtras = container.findViewById<TextView>(R.id.txtExtras)
    txtAction.text = intent.action
    txtCategories.text = intent.categories?.toString() ?: ""
    txtExtras.text = intent.hasExtra("SOME_KEY").toString()

}
