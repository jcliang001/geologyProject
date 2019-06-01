package com.csci448.jiancongliang.geologyproject

class Run (file_name : String, layer : Int, type : String, type_num : String, thickness : Double, bed_id : String, note : String){
    var file_name : String = ""
    var layer : Int = 1
    var type : String = ""
    var type_num : String = ""
    var thickness : Double = 0.0
    var bed_id : String = ""
    var note : String = ""

    init {
        this.file_name = file_name
        this.layer = layer
        this.type = type
        this.type_num = type_num
        this.thickness = thickness
        this.bed_id = bed_id
        this.note = note
    }
}