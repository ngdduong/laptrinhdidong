package com.example.giuaki

class User {
    var id : Int = 0
    var name : String = ""
    var email : String =""
    var phonenumber : String = ""
    var address : String =""


    constructor(id:Int, name:String,email:String,phonenumber:String,address:String){
        this.id=id
        this.name=name
        this.email=email
        this.phonenumber=phonenumber
        this.address = address
    }

    constructor( name:String,email:String,phonenumber:String,address:String){
        this.name=name
        this.email=email
        this.phonenumber=phonenumber
        this.address = address
    }
}