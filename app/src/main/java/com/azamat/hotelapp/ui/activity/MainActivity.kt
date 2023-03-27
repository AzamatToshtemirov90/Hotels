package com.azamat.hotelapp.ui.activity

import android.os.Bundle
import com.azamat.hotelapp.R
import com.azamat.hotelapp.base.BaseActivity
import com.azamat.hotelapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeNavController(R.id.nav_host_fragment)
    }
}