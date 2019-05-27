package com.github.dzeko14.socialnetworkapp.interactor

interface GetListInteractor<T> {
    fun getList(): List<T>
}