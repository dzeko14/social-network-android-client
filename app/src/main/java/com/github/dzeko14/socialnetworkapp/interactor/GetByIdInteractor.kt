package com.github.dzeko14.socialnetworkapp.interactor

interface GetByIdInteractor<T, ID> {
    fun getById(id: ID): T
}