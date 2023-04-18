/*
 * Copyright (C) 2022, amansatija
 * All rights reserved.
 */
package com.example.upstoxassignment1.utils.core.base.mvi

import com.example.upstoxassignment1.utils.core.base.mvvm.MvvmViewModel

import com.example.upstoxassignment1.utils.core.flow.MutableEventFlow
import com.example.upstoxassignment1.utils.core.flow.asEventFlow

abstract class MviViewModel<STATE, EVENT> : MvvmViewModel() {

    private val _stateFlow = MutableEventFlow<STATE>()
    val stateFlow = _stateFlow.asEventFlow()

    abstract fun onTriggerEvent(eventType: EVENT)

    protected fun setState(state: STATE) = safeLaunch {
        _stateFlow.emit(state)
    }
}
