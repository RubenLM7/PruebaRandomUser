package com.rubenlozano.prueba.data

import com.rubenlozano.prueba.data.datasource.local.room.entity.UsersEntity
import com.rubenlozano.prueba.data.datasource.remote.response.UserResult
import com.rubenlozano.prueba.data.model.User

fun UserResult.toModel(): User = User(
    dniNumber = this.id.value,
    gender = this.gender,
    nameSurname = "${this.name.title} " + "${this.name.first} " + this.name.last,
    location = "${this.location.city}, " + "${this.location.country}, " + "${this.location.postcode}",
    email = this.email,
    age = this.dob.age,
    phoneNumber = this.cell,
    picture = this.picture.medium,
    nationality = this.nat
    )

fun UserResult.toEntity(): UsersEntity = UsersEntity(
    dniNumber = this.id.value,
    gender = this.gender,
    nameSurname = this.name.title + this.name.first + this.name.last,
    location = this.location.city + this.location.country + this.location.postcode,
    email = this.email,
    age = this.dob.age,
    phoneNumber = this.cell,
    picture = this.picture.medium,
    nationality = this.nat
    )

fun UsersEntity.toModel(): User = User(
    dniNumber = this.dniNumber,
    gender = this.gender,
    nameSurname = this.nameSurname,
    location = this.location,
    email = this.email,
    age = this.age,
    phoneNumber = this.phoneNumber,
    picture = this.picture,
    nationality = this.nationality
    )