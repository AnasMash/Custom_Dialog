package com.dialog


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val myArray = arrayOf("aziz","galy","mohd",";adskf;","qwesad")
//        val adpter = ArrayAdapter(this,android.R.layout.simple_spinner_item,myArray)
//        mySpinnerList.adapter = adpter
        val inflation = LayoutInflater.from(this)
        val view = inflation.inflate(R.layout.custom_dialog,null)
        val bulider = AlertDialog.Builder(this)
        bulider.setView(view)
        val dialog1 = bulider.create()
        val arrayList = ArrayList<String>()
        btn_dialog.setOnClickListener {
            dialog1.show()

            view.btn_add.setOnClickListener {
                val textData = view.et_data.text.toString()
                arrayList.add(textData)
                dialog1.cancel()
                view.et_data.text.clear()
            }
            val myAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList)
            mySpinnerList.adapter = myAdapter
            view.tv_position.text = "عدد العناصر = ${mySpinnerList.adapter.count.toString()}"
            mySpinnerList.setOnItemClickListener { adapterView, view, i, l ->
                Toast.makeText(this, arrayList[i], Toast.LENGTH_SHORT).show()
            }

            view.btn_cancel.setOnClickListener {
                dialog1.cancel()
            }
        }

       //


    }
}
/*
        mySpinnerList.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,arrayList[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
 */


/*
            dIG.setTitle("مرحبا بك")
            dIG.setMessage("هل تريد الذهاب لتلك الصفحة؟")
            dIG.setPositiveButton("نعم"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "okay", Toast.LENGTH_SHORT).show()
            }
            dIG.setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "طب يلا روح انقلع", Toast.LENGTH_SHORT).show()
            }
            dIG.setNeutralButton("cancle"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "باي", Toast.LENGTH_SHORT).show()
                finish()
            }
*/