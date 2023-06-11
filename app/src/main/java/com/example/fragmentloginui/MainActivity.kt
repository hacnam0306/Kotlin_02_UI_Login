package com.example.fragmentloginui

import com.example.fragmentloginui.authentication.view.LoginFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.fragmentloginui.authentication.utils.TokenManager
import com.example.fragmentloginui.databinding.ActivityMainBinding
import com.example.fragmentloginui.databinding.AllNotesFragmentBinding
import com.example.fragmentloginui.home.noteList.AllNotesFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tokenManager: TokenManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        tokenManager = TokenManager(this)

        if (tokenManager.getToken() != null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<AllNotesFragment>(R.id.allNote_fragment)
            }
        } else {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<LoginFragment>(R.id.login_fragment)
            }
        }
    }
}
