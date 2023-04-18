package com.example.upstoxassignment1.data.domain.holdings

import com.example.upstoxassignment1.data.domain.holdings.model.ModelHoldings
import com.example.upstoxassignment1.data.remote.HoldingsRemoteDataSource
import com.example.upstoxassignment1.utils.core.Resource
import javax.inject.Inject

class RepoHoldings @Inject constructor(
    private val remoteDataSource: HoldingsRemoteDataSource
//    ,
//    private val localDataSource: HoldingsLocalDataSource
) {

    suspend fun fetchHoldings(clientId: String): Resource<ModelHoldings> {
        return remoteDataSource.fetchHoldings(clientId);
    }
}