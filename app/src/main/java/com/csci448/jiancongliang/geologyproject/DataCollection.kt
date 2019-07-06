package com.csci448.jiancongliang.geologyproject

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
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
    private val REQUEST_CODE_PERMISSION = 1
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

//        verifyPermissions()

        file_name = intent.getStringExtra(MainActivity.FILE_NAME_EXTRA)
        id_file_display.text = file_name
        val idx = mutableListRun.size + 1
        id_layer_count.text = idx.toString()

        //sand button
        btn_sand.setOnClickListener {
            btn_mud.setBackgroundColor(Color.WHITE)
            btn_sand.setBackgroundColor(Color.YELLOW)
            btn_other.setBackgroundColor(Color.WHITE)
            type = "sand"
            type_num = 1
            setC()
        }
        //mud button
        btn_mud.setOnClickListener {
            btn_sand.setBackgroundColor(Color.WHITE)
            btn_mud.setBackgroundColor(Color.BLUE)
            btn_other.setBackgroundColor(Color.WHITE)
            type = "mud"
            type_num = 0
            setC()
        }
        //other button
        btn_other.setOnClickListener {
            btn_sand.setBackgroundColor(Color.WHITE)
            btn_mud.setBackgroundColor(Color.WHITE)
            btn_other.setBackgroundColor(Color.RED)
            type = "other"
            type_num = 2
            setC()
        }

        btn_camera.setOnClickListener {
//            dispatchCameraTaker()
        }

        //save button
        btn_save.setOnClickListener {

            if(type==""){
                btn_sand.setTextColor(Color.RED)
                btn_other.setTextColor(Color.RED)
                btn_mud.setTextColor(Color.RED)

            }else if(TextUtils.isEmpty(id_thickness.getText().toString())){
                id_thickness.error="Enter thicknexx"
            }
            else{
                thickness = id_thickness.getText().toString().toDouble()
                val index =  mutableListRun.size
                bed_id = id_bed.getText().toString()
                note = id_note.getText().toString()

                val run_object = Run(file_name, index+1, type, type_num.toString(), thickness, bed_id, note)
                mutableListRun.add(run_object)
                Toast.makeText(this, mutableListRun.get(0).thickness.toString(), Toast.LENGTH_SHORT).show()
                btn_sand.setBackgroundColor(Color.WHITE)
                btn_mud.setBackgroundColor(Color.WHITE)
                btn_other.setBackgroundColor(Color.WHITE)
                type=""
                id_note.setText("")
                id_bed.setText("")
                id_thickness.setText("")
                val idx = mutableListRun.size + 1
                id_layer_count.text = idx.toString()

            }



        }

        //end of run button
        btn_end.setOnClickListener {
         if(TextUtils.isEmpty(id_thickness.getText().toString())){
            Toast.makeText(this, "End of run.", Toast.LENGTH_SHORT).show()
            id_input_text.setText("")
            this.finish()
        }
           else{
             btn_end.error="You need to save first"
         }
        }

    }
    private fun setC(){
        btn_sand.setTextColor(Color.BLACK)
        btn_other.setTextColor(Color.BLACK)
        btn_mud.setTextColor(Color.BLACK)
    }
//
//    private fun verifyPermissions(){
//        Log.d(LOG_TAG, "Verify permissiongs")
//
//        val read_external_permission = ContextCompat.checkSelfPermission(this.getApplicationContext(),
//            Manifest.permission.READ_EXTERNAL_STORAGE)
//        val write_external_permission = ContextCompat.checkSelfPermission(this.getApplicationContext(),
//            Manifest.permission.WRITE_EXTERNAL_STORAGE)
//        val camera_permission = ContextCompat.checkSelfPermission(this.getApplicationContext(),
//            Manifest.permission.CAMERA)
//
//        if (read_external_permission == PackageManager.PERMISSION_GRANTED
//                && write_external_permission == PackageManager.PERMISSION_GRANTED
//                && camera_permission == PackageManager.PERMISSION_GRANTED) {
//            Log.i(LOG_TAG, "Permission to record denied")
//        }
//        else{
////            ActivityCompat.requestPermissions(this,
////                permissions,
////                REQUEST_CODE_PERMISSION)
//        }
//
//    }

//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        verifyPermissions()
//    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(resultCode == RESULT_OK){
//            if(requestCode == 1){
//                val bitmap = BitmapFactory.decodeFile()
//            }
//        }
//    }
//    fun dispatchCameraTaker(){
//        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        startActivityForResult(intent, 1)
//    }
//    fun createPhotoFile(){
//        val name = Simpl
//    }
}