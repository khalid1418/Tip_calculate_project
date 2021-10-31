package com.example.tipcalculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculate.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    fun calculateTip(){
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val selectID = binding.tipOptions.checkedRadioButtonId
        val tipPercent: Double = when(selectID){
            R.id.option_twenty_percent -> 0.2
            R.id.option_eighteen_percent ->0.18
            R.id.option_fifteen_percent ->0.15
            else -> 0.0
        }
        var tip = tipPercent * cost +cost
        val roundUp =binding.roundUpSwitch.isChecked
        if (roundUp){
            tip == kotlin.math.ceil(tip)
        }
        val format = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text= getString(R.string.tip_amount, format)
    }
}