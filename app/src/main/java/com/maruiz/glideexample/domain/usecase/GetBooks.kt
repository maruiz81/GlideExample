package com.maruiz.glideexample.domain.usecase

import arrow.core.Either
import arrow.core.None
import com.maruiz.glideexample.data.api.BookApi
import com.maruiz.glideexample.data.error.Failure
import com.maruiz.glideexample.data.extensions.makeRequest
import com.maruiz.glideexample.data.model.BookModel

class GetBooks(private val bookApi: BookApi) : UseCase<List<BookModel>, None>() {
    override suspend fun run(params: None): Either<Failure, List<BookModel>> =
        bookApi.getBooks().makeRequest().map { it ?: emptyList() }
}
