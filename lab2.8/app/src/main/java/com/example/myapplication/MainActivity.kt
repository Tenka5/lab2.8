package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sideA = findViewById<EditText>(R.id.sideA)
        val sideB = findViewById<EditText>(R.id.sideB)
        val sideC = findViewById<EditText>(R.id.sideC)
        val button = findViewById<Button>(R.id.getSolution)
        val textView = findViewById<TextView>(R.id.solution)
        val lan = resources.getStringArray(R.array.lang)
        val spinner = findViewById<Spinner>(R.id.spiner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, lan)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    if(lan[position]=="Сумма длин рёбер"){
                        button.setOnClickListener({
                            var a: Int? = sideA.text.toString().toIntOrNull()
                            var b: Int? = sideB.text.toString().toIntOrNull()
                            var c: Int? = sideC.text.toString().toIntOrNull()
                            if(a!=null&&b!=null&&c!=null) {
                                textView.setText("Ответ:"+4*(a!!.toInt()+b!!.toInt()+c!!.toInt()))
                            }else
                                textView.setText("Ошибка ввода")
                        })
                    }
                    if(lan[position]=="Площадъ поверхности"){
                        button.setOnClickListener({
                            var a: Int? = sideA.text.toString().toIntOrNull()
                            var b: Int? = sideB.text.toString().toIntOrNull()
                            var c: Int? = sideC.text.toString().toIntOrNull()
                            if(a!=null&&b!=null&&c!=null) {
                                textView.setText("Ответ:"+(2*((a!!.toInt()*b!!.toInt())+(b!!.toInt()*c!!.toInt())+(a!!.toInt()*c!!.toInt()))))
                            }else
                                textView.setText("Ошибка ввода")
                        })
                    }
                    if(lan[position]=="Объем"){
                        button.setOnClickListener({
                            var a: Int? = sideA.text.toString().toIntOrNull()
                            var b: Int? = sideB.text.toString().toIntOrNull()
                            var c: Int? = sideC.text.toString().toIntOrNull()
                            if(a!=null&&b!=null&&c!=null) {
                                textView.setText("Ответ:" + a!!.toInt()*b!!.toInt()*c!!.toInt())
                            }else
                                textView.setText("Ошибка ввода")
                        })
                    }
                }
            }
        }
    }
}