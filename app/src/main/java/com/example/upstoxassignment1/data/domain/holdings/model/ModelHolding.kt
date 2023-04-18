package com.example.upstoxassignment1.data.domain.holdings.model

data class ModelHolding(val avg_price: String,
                        val cnc_used_quantity: Int,
                        val collateral_qty: Int,
                        val collateral_type: String,
                        val collateral_update_qty: Int,
                        val company_name: String,
                        val haircut: Double,
                        val holdings_update_qty: Int,
                        val isin: String,
                        val product: String,
                        val quantity: Int,
                        val symbol: String,
                        val t1_holding_qty: Int,
                        val token_bse: String,
                        val token_nse: String,
                        val withheld_collateral_qty: Int,
                        val withheld_holding_qty: Int,
                        val ltp: Double,
                        val close: Double){
    var  currentVal = 0.0;
    var investmentVal = 0.0
    var todaysPNL = 0.0;
    var pnl = 0.0
    init {
        currentVal = (ltp * quantity);
        investmentVal = (avg_price.toDouble() - quantity)
        todaysPNL = (close-ltp)*quantity
        pnl = currentVal - investmentVal
    }
}
