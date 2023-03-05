package com.example.kotlinsqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Try ve catch hata alma yöntemi
        try {
            val myDatabase= this.openOrCreateDatabase("Musicians", MODE_PRIVATE,null)
           // myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY, name VARCHAR, age INT)")
            //myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('Kirk',55)")
            myDatabase.execSQL("DELETE from musicians WHERE name='James'")
            //myDatabase.execSQL("UPDATE musicians set name='Kirk Hamet' WHERE name='Kirk'")
            //val cursor=myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE '%e%'",null)
            val cursor=myDatabase.rawQuery("SELECT * FROM musicians",null)
            val nameIndex= cursor.getColumnIndex("name")
            val ageIndex= cursor.getColumnIndex("age")
            val idIndex= cursor.getColumnIndex("id")

            while (cursor.moveToNext())
            {
                println("Name: " + cursor.getString(nameIndex))
                println("Age: " + cursor.getInt(ageIndex))
                println("ID: " + cursor.getInt(idIndex))
            }
            cursor.close()

        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}