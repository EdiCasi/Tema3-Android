package com.example.tema31

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tema31.interfaces.ActivityFragmentCommunication

class MainActivity : AppCompatActivity() , ActivityFragmentCommunication {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onReplaceFragment(FirstFragment::class.java.name)
    }

    override fun onReplaceFragment(TAG: String) {
        val fragmentManager = supportFragmentManager

        val transaction = fragmentManager.beginTransaction()


        val fragment = when (TAG) {
            FirstFragment::class.java.name ->
                FirstFragment.newInstance()

            //TO DO:: De completat cu ce o sa fac in al doilea fragment

            else->FirstFragment.newInstance()
        }

        val replaceTransaction = transaction.replace(
            R.id.fl_container,
            fragment,
            TAG
        )

        replaceTransaction.commit()
    }
}