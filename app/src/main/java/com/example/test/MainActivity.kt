package com.example.test

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.test.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


       binding.myName = myName

        val doneBtn: Button = findViewById(R.id.done_button)

        binding.doneButton.setOnClickListener{ buttonCalled(it)}

    }

    private fun buttonCalled(view: View)
    {
        val editText = binding.nicknameEdit//findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = binding.nicknameText//findViewById<TextView>(R.id.nickname_text)

        binding.apply {

            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            doneButton.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

        }




        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
