package com.rubenlozano.prueba.data.repository

import com.rubenlozano.prueba.data.datasource.local.room.dao.UsersDao
import com.rubenlozano.prueba.data.datasource.remote.api.Api
import com.rubenlozano.prueba.data.model.User
import com.rubenlozano.prueba.data.toEntity
import com.rubenlozano.prueba.data.toModel
import com.rubenlozano.prueba.domain.repository.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val api: Api,
    private val dao: UsersDao,
) : UsersRepository {

    override fun getAllUser(): Flow<List<User>> = flow {
        val response = api.getAllUsers()
        if (response.isSuccessful && response.body() != null) {
            response.body()?.let {
                dao.insertUsers(response.body()!!.results.map { it.toEntity() })

                emit(response.body()!!.results.map {
                    it.toModel()
                })
            }
        }
    }.catch {
        dao.getAllUsers()
            .onEach { emit(it.map { it.toModel() }) }.collect()
    }
        .flowOn(Dispatchers.IO)
}