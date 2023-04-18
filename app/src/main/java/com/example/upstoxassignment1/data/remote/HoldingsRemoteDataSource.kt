package com.example.upstoxassignment1.data.remote
import com.example.upstoxassignment1.data.domain.holdings.model.ModelHoldings
import com.example.upstoxassignment1.data.domain.holdings.model.toDomainModel
import com.example.upstoxassignment1.utils.api.ApiService
import com.example.upstoxassignment1.utils.core.Resource
import javax.inject.Inject

class HoldingsRemoteDataSource @Inject constructor(
    private val apiService: ApiService
): BaseDataSource() {

    var mHmCacheOfResponses = HashMap<String, Resource<ModelHoldings>>()
    var boolIsCacheDirty = false;

    suspend fun fetchHoldings(clientId: String) : Resource<ModelHoldings> {
        if(boolIsCacheDirty ||
            !mHmCacheOfResponses.containsKey(clientId)){
            val result = executeRemoteReq { apiService.fetchHoldings() }
            val resultToDomainModel = result.toDomainModel()
            if(resultToDomainModel!=null){
                mHmCacheOfResponses[clientId] = resultToDomainModel
            }
            return  resultToDomainModel;
        }else{
            return mHmCacheOfResponses[clientId]!!
        }

    }
}