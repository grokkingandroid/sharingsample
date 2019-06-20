package com.grokkingandroid.sharingshortcuts

class MainPresenter(private val interactor: SharingInteractor) {
    fun start() {
        interactor.addShareTargets()
    }
}