package com.example.upstoxassignment1.utils.api;


import com.example.upstoxassignment1.data.remote.holdings.ModelResHoldings
import com.example.upstoxassignment1.data.remote.tvshow.ModelResTvShows
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query

/**
 * Created by amansatija on 5/4/16.
 */
interface  ApiService {

    @GET("6d0ad460-f600-47a7-b973-4a779ebbaeaf")
    suspend fun fetchHoldings(): Response<ModelResHoldings>
}