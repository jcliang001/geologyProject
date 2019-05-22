package com.csci448.jiancongliang.geologyproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class DataCollection : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = ""

        fun createIntent(ctx: Context?) = Intent(ctx, DataCollection::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_collection)

    }
}