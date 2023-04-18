/*
 * Copyright (C) 2022, amansatija
 * All rights reserved.
 */
package com.example.upstoxassignment1.di.providers

import android.content.Context

interface ThemeProvider {
    /**
     * Whether the current configuration is a dark theme i.e. in Night configuration.
     */
    fun isDarkTheme(context: Context): Boolean

    /**
     * Whether the current configuration is a light theme i.e. in Day configuration.
     */
    fun isLightTheme(context: Context): Boolean

    /**
     * Force [AppCompatDelegate] Mode to night/notnight.
     *
     * @param forceNight Boolean that force night mode otherwise notnight is configured.
     */
    fun setNightMode(forceNight: Boolean)
}