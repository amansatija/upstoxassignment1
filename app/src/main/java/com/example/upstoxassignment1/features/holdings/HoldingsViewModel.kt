package com.example.upstoxassignment1.features.holdings


import com.example.upstoxassignment1.data.domain.holdings.FetchHoldingsUseCase
import com.example.upstoxassignment1.data.domain.holdings.model.ModelHoldings
import com.example.upstoxassignment1.di.providers.ResourceProvider
import com.example.upstoxassignment1.utils.core.base.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HoldingsViewModel @Inject constructor(
    private val fetchHoldingsUseCase: FetchHoldingsUseCase,
    private val resourceProvider: ResourceProvider
) : MviViewModel<HoldingsPageContract.State, HoldingsPageContract.Event>() {

    private var holdings: ModelHoldings? = null

    init {

    }
    override fun onTriggerEvent(eventType: HoldingsPageContract.Event) {
        when (eventType) {
            is HoldingsPageContract.Event.FetchHoldings -> fetchHoldings(eventType.clienId)
        }
    }

    private fun fetchHoldings(clientId: String) = safeLaunch{
        val params = FetchHoldingsUseCase.Params(clientId = clientId)

        executeWithProgress(fetchHoldingsUseCase(params)) { argHoldings ->
            this@HoldingsViewModel.holdings = argHoldings
            setState(HoldingsPageContract.State.HoldingsPageData(argHoldings))
        }
    }
}