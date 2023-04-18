package com.example.upstoxassignment1.base

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.upstoxassignment1.R
import com.example.upstoxassignment1.base.ActivityBase


open class ActivityToolbar: ActivityBase() {

    var mToolbar:Toolbar? = null;
    override fun findViewByIds(savedInstanceState: Bundle?) {
        super.findViewByIds(savedInstanceState)
        mToolbar = findViewById<Toolbar>(R.id.toolbar);
    }

    override fun setUpActionBar(savedInstanceState: Bundle?) {
        super.setUpActionBar(savedInstanceState)
        setSupportActionBar(mToolbar);

    }
}