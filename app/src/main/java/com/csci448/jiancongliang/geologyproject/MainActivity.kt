package com.csci448.jiancongliang.geologyproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var fileName = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onCreated() called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_submit.setOnClickListener {

            fileName = id_input_text.getText().toString()
            if(TextUtils.isEmpty(fileName)){
                id_input_text.error = "Enter file name"
                return@setOnClickListener
            }
            val i = DataCollection.createIntent(this)
            i.putExtra(FILE_NAME_EXTRA, fileName)
            startActivity(i)
        }
    }

    companion object{
        private const val LOG_TAG = "Geo.MainActivity"
        public val FILE_NAME_EXTRA = "FILE_NAME_EXTRA"
    }

}
