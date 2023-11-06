package com.example.androidintermediate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidintermediate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //contoh properties binding, code 001
    private lateinit var binding: ActivityMainBinding
    //001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //ubah nilai setContentView() method, code 002
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //002


        binding.textViewMainActivity.text = "Hello Abdul Goffar..! How Are You Today"



        binding.buttonMainActivityGoToFragmentActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, FragmentActivity::class.java)
            startActivity(intent)
        }



    }
}