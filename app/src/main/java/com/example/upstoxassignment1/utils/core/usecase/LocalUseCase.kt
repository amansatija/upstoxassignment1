/*
 * Copyright (C) 2022, amansatija
 * All rights reserved.
 */
package com.example.upstoxassignment1.utils.core.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class LocalUseCase<in Params, ReturnType> where ReturnType : Any {

    protected abstract suspend fun FlowCollector<ReturnType>.execute(params: Params)

    suspend operator fun invoke(params: Params) = flow {
        execute(params)
    }.flowOn(Dispatchers.IO)
}
