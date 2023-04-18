package com.example.upstoxassignment1.data.domain.holdings.model

data class ModelHoldings(val AllHoldings: List<ModelHolding>?=null){
    var currentVal=0.0;
    var totalInvestment=0.0;
    var todaysPNL=0.0;
    var totalPNL=0.0;

    init {
        //pre calculate required vals to be shown ...>>>
        calculateReqVals()
    }

    private fun calculateReqVals() {
        if(AllHoldings==null){
            return
        }
        for (holding in AllHoldings!!){
            currentVal += holding.currentVal;
            totalInvestment += holding.investmentVal
            todaysPNL += holding.todaysPNL
        }
        totalPNL = currentVal - totalInvestment
    }
}
