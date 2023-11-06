package com.example.androidintermediate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidintermediate.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //cara pemanggilan fragment di dalam activity, code 001
        val supportFragmentManager = supportFragmentManager
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayoutFragmentActivity, HomeFragment(), HomeFragment::class.java.simpleName)
            .commit()
        //code 001
    }
}