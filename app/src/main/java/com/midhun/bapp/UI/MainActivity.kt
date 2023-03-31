package com.midhun.bapp.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.midhun.bapp.R
import com.midhun.bapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        binding.next.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, PlaceFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }
        //add fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().setReorderingAllowed(true)
                .add(R.id.fragment_container, HomeFragment::class.java, null).commit()
        }

    }


}