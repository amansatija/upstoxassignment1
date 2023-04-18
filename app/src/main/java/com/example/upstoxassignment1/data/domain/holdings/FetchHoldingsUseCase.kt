package com.example.upstoxassignment1.data.domain.holdings

import com.example.upstoxassignment1.data.domain.holdings.model.ModelHoldings
import com.example.upstoxassignment1.utils.core.Resource
import com.example.upstoxassignment1.utils.core.usecase.ResourceUseCase
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class FetchHoldingsUseCase @Inject constructor(internal val repository: RepoHoldings) :
    ResourceUseCase<FetchHoldingsUseCase.Params, ModelHoldings>()  {

    data class Params(val clientId: String)

    override suspend fun FlowCollector<Resource<ModelHoldings>>.execute(params: Params) {
        val result = repository.fetchHoldings(params.clientId)
        emit(result)
    }
}