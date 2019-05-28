package com.github.dzeko14.socialnetworkapp.interactor

interface CrudInteractor<T> {
    fun create(obj: T): T
}