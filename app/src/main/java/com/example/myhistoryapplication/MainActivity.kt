package com.example.myhistoryapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val inputField=findViewById<EditText>(R.id.editTextText2)
        val clearBtn=findViewById<Button>(R.id.button)
        var searchBtn=findViewById<Button>(R.id.button2)
        val resultTv=findViewById<TextView>(R.id.textView)
        val peopleArray= arrayListOf<History>(

            History("Winnie Mandela",81),
            History("Antjie Krog",72),
            History("Desmond Doss",87),
            History("John Glenn",95),
            History("Daniel Francois",84),
            History("Mother Teresa",87),
            History("P.W.Botha",90),
            History("Stephan Hawking",76),
            History("Coco Chanel",87),
            History("Abraham Lincoln",56),
            History("Desmond Tutu",90),




        )

        searchBtn.setOnClickListener {

            var inputFielText=inputField.text.toString().toInt()
            if (inputField.text.toString().isBlank()){
                resultTv.text="Field cannot be Empty"

            }
            else if (inputField.text.toString().toInt()<20 ||inputField.text.toString().toInt()>100 ){
                resultTv.text="Age cannot be less than 20 and greater than 100"
            }
            else{
                for(people in peopleArray){
                    if (inputFielText==people.age){
                        resultTv.text=people.name
                    break
                    }
                    else{
                        resultTv.text="Person matching that age is not available "
                    }
                }
            }
        }

        clearBtn.setOnClickListener {
            inputField.text.clear()
            resultTv.text=""

        }
    }


}
data class History(val name:String , val age:Int){

}