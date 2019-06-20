package com.grokkingandroid.sharingshortcuts

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat

class AndroidShortcutCreator(private val context: Context) : ShortcutCreator {
    override fun createShortcuts(persons: List<Person>) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            noOp()
            return
        }
        addShareTargets(persons)
    }

    /**
     * No share targets for older version; so we simply do nothing.
     */
    fun noOp() {}

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun addShareTargets(persons: List<Person>) {
        println(ShortcutManagerCompat.getMaxShortcutCountPerActivity(context))
        val shortcutInfos = mutableListOf<ShortcutInfoCompat>()
        val launcherIntent = Intent(context, ShareTargetActivity::class.java)
        launcherIntent.putExtra("SOME_KEY", "someValue")
        launcherIntent.action = Intent.ACTION_SEND

        persons.forEachIndexed { index, person ->
            println("adding shortcut for: $person")
            // personalize this:
            val personIcon = IconCompat.createWithResource(context, R.drawable.ic_android_black_24dp)
            val somePerson = androidx.core.app.Person.Builder()
                .setName(person.name)
                .build()
            val categories = mutableSetOf(
                "com.grokkingandroid.sharingshortcuts.TEXT_SHARE_TARGET",
                "com.grokkingandroid.sharingshortcuts.IMAGE_SHARE_TARGET"
            )
            val info = ShortcutInfoCompat.Builder(context, "com.grokkingandroid.target.$index")
                .setIcon(personIcon)
                .setLongLived()
                .setShortLabel(person.name)
                .setPerson(somePerson)
                .setIntent(launcherIntent)
                .setCategories(categories)
                .build()
            shortcutInfos.add(info)
        }
        val result = ShortcutManagerCompat.addDynamicShortcuts(context, shortcutInfos)
        println("result of adding shortcuts: $result")
    }

}