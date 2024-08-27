package com.cis2818.tipcalculator_constraintviewbinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cis2818.tipcalculator_constraintviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)



        enableEdgeToEdge()

        setContentView(binding.root)

        //Making sure main making appropriate room
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonCalculate.setOnClickListener{

            val billAmount = binding.editTextBillAmount.text.toString().toDoubleOrNull()
            val tipPercentage = binding.editTextTipPercentage.text.toString().toDoubleOrNull()

            //Check if inputs are valid
            if(billAmount != null && tipPercentage !=null)
            {
                val tipAmount = billAmount * (tipPercentage/100)
                val totalAmount = billAmount + tipAmount

                binding.textViewTipAmount.text = String.format("Tip Amount: $%.2f", tipAmount)
                binding.textViewTotalAmount.text = String.format("Total Amount: $%.2f", totalAmount)
            }
            else{

                binding.textViewTipAmount.text = "Please enter valid numbers "
                binding.textViewTipAmount.text = " "

            }


        }







    }



}