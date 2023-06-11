package com.example.fragmentloginui

import com.example.fragmentloginui.authentication.view.LoginFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.fragmentloginui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<LoginFragment>(R.id.login_fragment)

        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
//     private fun onClick(v : View){
//        supportFragmentManager.commit{
//            val fragment = supportFragmentManager.findFragmentById(v.id)
//            fragment.let {
//                if (it != null) {
//                    hide(it)
//                }
//            }
//        }
//    }

}
