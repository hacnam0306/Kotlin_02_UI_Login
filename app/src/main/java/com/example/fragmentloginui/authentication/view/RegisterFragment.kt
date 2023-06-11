package com.example.fragmentloginui.authentication.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragmentloginui.R
import com.example.fragmentloginui.databinding.RegisterFragmentBinding

class RegisterFragment : Fragment(R.layout.register_fragment),View.OnClickListener {
    private lateinit var binding: RegisterFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = RegisterFragmentBinding.bind(view)

        binding.navigateLogin.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}
