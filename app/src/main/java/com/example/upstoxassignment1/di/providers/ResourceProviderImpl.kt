/*
 * Copyright (C) 2022, amansatija
 * All rights reserved.
 */
package com.example.upstoxassignment1.di.providers

import android.content.Context
import com.example.upstoxassignment1.di.providers.ResourceProvider

class ResourceProviderImpl(private val context: Context) : ResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}