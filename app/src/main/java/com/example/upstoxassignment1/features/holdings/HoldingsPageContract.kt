package com.example.upstoxassignment1.features.holdings

import com.example.upstoxassignment1.data.domain.holdings.model.ModelHoldings

class HoldingsPageContract {
    sealed class Event {
        data class FetchHoldings(val clienId: String = "183247") : Event()
    }

    sealed class State {
        data class HoldingsPageData(val detail: ModelHoldings) : State()
    }
}