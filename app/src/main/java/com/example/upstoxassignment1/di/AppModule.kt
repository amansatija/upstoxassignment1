package com.example.upstoxassignment1.di

import android.content.Context
import com.example.upstoxassignment1.di.providers.NavigationProvider
import com.example.upstoxassignment1.base.app.AppConfig
import com.example.upstoxassignment1.base.app.AppID
import com.example.upstoxassignment1.data.domain.holdings.FetchHoldingsUseCase
import com.example.upstoxassignment1.data.domain.holdings.RepoHoldings
import com.example.upstoxassignment1.data.remote.HoldingsRemoteDataSource
import com.example.upstoxassignment1.di.providers.NavigationProviderImpl
import com.example.upstoxassignment1.di.providers.ResourceProvider
import com.example.upstoxassignment1.di.providers.ResourceProviderImpl
import com.example.upstoxassignment1.utils.api.ApiClientProvider
import com.example.upstoxassignment1.utils.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNavigationProviderImpl(@ApplicationContext context: Context): NavigationProvider {
        return NavigationProviderImpl(context)
    }

    @Provides
    @Singleton
    fun provideResourceProviderImpl(@ApplicationContext context: Context): ResourceProvider {
        return ResourceProviderImpl(context)
    }

    @Provides
    @Singleton
    fun provideApplication(): AppID {
        return AppID.instance
    }

    @Provides
    @Singleton
    fun provideAppConfig(app: AppID): AppConfig {
        return app.appConfig()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = ApiClientProvider.getInstance().retrofit

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

//    @Provides
//    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = ApiClientProvider.getApiClient()

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(apiService: ApiService) = HoldingsRemoteDataSource(apiService)

//    @Singleton
//    @Provides
//    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)
//
//    @Singleton
//    @Provides
//    fun provideCharacterDao(db: AppDatabase) = db.characterDao()

    @Singleton
    @Provides
    fun provideHoldingsRepository(remoteDataSource: HoldingsRemoteDataSource,
//                          localDataSource: CharacterDao
    ) =
        RepoHoldings(remoteDataSource,
//            localDataSource
            )

    @Singleton
    @Provides
    fun provideFetchHoldingsUseCase(repository: RepoHoldings) = FetchHoldingsUseCase(repository)
}