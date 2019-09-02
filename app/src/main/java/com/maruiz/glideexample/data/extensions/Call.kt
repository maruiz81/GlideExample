package com.maruiz.glideexample.data.extensions

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import arrow.core.Try
import com.maruiz.glideexample.data.error.Failure
import retrofit2.Call

fun <T> Call<T>.makeRequest(): Either<Failure, T?> =
    Try {
        this.execute().let {
            if (it.isSuccessful) Right(it.body())
            else Left(Failure.ServerError)
        }
    }.fold({ Left(Failure.ServerError) }, { it })
