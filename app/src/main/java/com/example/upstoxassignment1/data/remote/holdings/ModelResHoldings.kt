package com.example.upstoxassignment1.data.remote.holdings

data class ModelResHoldings(val client_id: String,
                            val data: List<ModelResHoldingsDetails>,
                            val error: Any?,
                            val response_type: String,
                            val timestamp: Long)
