package com.csci448.jiancongliang.geologyproject

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.data_collection.*
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.OutputStreamWriter

class DataCollection : AppCompatActivity() {
    private var file_name = ""
    private var section_name = ""
    private var type = ""
    private var bed_id = ""
    private var type_num = 0
    private var note = ""
    private var thickness = 0.0
    private val CSV_HEADER = "id,name,address,age"

    companion object {
        private const val LOG_TAG = "Geo.DataCollection"
        private var layer_count = 0
        fun createIntent(ctx: Context?) = Intent(ctx, DataCollection::class.java)
        //vector
        var mutableListRun  = arrayListOf<Run>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.data_collection)
        file_name = intent.getStringExtra(MainActivity.FILE_NAME_EXTRA)
        id_file_display.text = file_name
        val idx = mutableListRun.size + 1
        id_layer_count.text = idx.toString()

        //sand button
        btn_sand.setOnClickListener {
            btn_mud.setBackgroundColor(Color.WHITE)
            btn_sand.setBackgroundColor(Color.RED)
            type = "sand"
            type_num = 1
        }
        //mud button
        btn_mud.setOnClickListener {
            btn_sand.setBackgroundColor(Color.WHITE)
            btn_mud.setBackgroundColor(Color.RED)
            type = "mud"
            type_num = 0


        }

        //save button
        btn_save.setOnClickListener {
            thickness = id_thickness.getText().toString().toDouble()
            val index =  mutableListRun.size
            bed_id = id_bed.getText().toString()
            note = id_note.getText().toString()

            val run_object = Run(file_name, index+1, type, type_num.toString(), thickness, bed_id, note)
            mutableListRun.add(run_object)
            Toast.makeText(this, mutableListRun.get(0).thickness.toString(), Toast.LENGTH_SHORT).show()
            btn_sand.setBackgroundColor(Color.WHITE)
            btn_mud.setBackgroundColor(Color.WHITE)
            id_note.setText("")
            id_bed.setText("")
            id_thickness.setText("")
            val idx = mutableListRun.size + 1
            id_layer_count.text = idx.toString()

        }

        //end of run button
        btn_end.setOnClickListener {
            Toast.makeText(this, "End of run.", Toast.LENGTH_SHORT).show()
            id_input_text.setText("")
            this.finish()
        }

    }



}