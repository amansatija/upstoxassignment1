package com.example.upstoxassignment1.base.app

import com.example.upstoxassignment1.BuildConfig
import com.example.upstoxassignment1.features.MainActivity
import com.example.upstoxassignment1.utils.core.config.CoreConfig


class AppConfig : CoreConfig() {
    override fun appName(): String {
        return "Upstox It Assesment 1"
    }

//    override fun environment(): CoreEnvironment {
//        return if (isDev()) {
//            CoreEnvironment.DEV
//        } else {
//            CoreEnvironment.PROD
//        }
//    }
//
//    override fun baseUrl(): String {
//        return when (environment()) {
//            CoreEnvironment.DEV, CoreEnvironment.TEST, CoreEnvironment.UAT -> {
//                BuildConfig.BASE_URL
//            }
//            CoreEnvironment.PILOT, CoreEnvironment.PREP, CoreEnvironment.PROD -> {
//                BuildConfig.BASE_URL
//            }
//        }
//    }

    override fun timeOut(): Long {
        return 30L
    }

    override fun isDev(): Boolean {
        return BuildConfig.DEBUG
    }

    override fun isSessionLoggerEnable(): Boolean {
        return isDev()
    }

    override fun isNetworkLoggerEnabled(): Boolean {
        return isDev()
    }

    override fun isSslPinningEnabled(): Boolean {
        return super.isSslPinningEnabled()
    }

    override fun uncaughtExceptionPage(): Class<*> {
        return MainActivity::class.java
    }

    override fun uncaughtExceptionMessage(): String {
        return "Unknown Error"
    }
}