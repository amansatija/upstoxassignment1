package com.example.upstoxassignment1.data.domain.holdings.model


import com.example.upstoxassignment1.data.remote.holdings.ModelResHoldings
import com.example.upstoxassignment1.data.remote.holdings.ModelResHoldingsDetails
import com.example.upstoxassignment1.utils.core.Resource

fun ModelResHoldingsDetails.toDomainModel()= ModelHolding(
    avg_price,
    cnc_used_quantity,
    collateral_qty,
    collateral_type,
    collateral_update_qty,
    company_name,
    haircut,
    holdings_update_qty,
    isin,
    product,
    quantity,
    symbol,
    t1_holding_qty,
    token_bse,
    token_nse,
    withheld_collateral_qty,
    withheld_holding_qty,
    ltp,
    close
)

fun Resource<ModelResHoldings>.toDomainModel()=Resource<ModelHoldings>(
    status,
    ModelHoldings(data?.data?.map{it.toDomainModel()}),
    message
)


//fun ModelHoldings.getNoOfDaysSincePriemere() = run {
//    (((((Date().time-premiered.time)/1000)/60)/60)/24)
//}