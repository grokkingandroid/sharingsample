package com.grokkingandroid.sharingshortcuts

class SharingInteractor(
    private val shortcutCreator: ShortcutCreator
) {
    fun addShareTargets() {
        shortcutCreator.createShortcuts(getPersons())
    }

    /**
     * This of course could be a db or whatever clever mechanism;
     * most likely you cannot do this synchronously, even though
     * I do in this sample.
     */
    fun getPersons() = mutableListOf(
        // scorers are usually mentioned the most
        Person("Jill Roord"),
        Person("Dominique Bloodworth"),
        Person("Vivianne Miedema"),
        Person("Lineth Beerensteyn")
    )
}
