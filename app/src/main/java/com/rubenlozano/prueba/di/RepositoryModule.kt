package com.rubenlozano.prueba.diimport dagger.Bindsimport dagger.Moduleimport dagger.hilt.InstallInimport dagger.hilt.components.SingletonComponentimport com.rubenlozano.prueba.domain.repository.UsersRepositoryimport com.rubenlozano.prueba.data.repository.UsersRepositoryImplimport javax.inject.Singleton@Module@InstallIn(SingletonComponent::class)interface RepositoryModule {    @Binds    fun usersRepository(impl: UsersRepositoryImpl): UsersRepository}