package com.example.fragmentloginui.authentication.view

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.fragmentloginui.R
import com.example.fragmentloginui.authentication.AuthViewModel
import com.example.fragmentloginui.authentication.model.LoginRequest
import com.example.fragmentloginui.authentication.services.AuthApiState
import com.example.fragmentloginui.databinding.LoginFragmentBinding
import com.example.fragmentloginui.home.noteList.AllNotesFragment

class LoginFragment : Fragment(R.layout.login_fragment),View.OnClickListener {
    private lateinit var binding: LoginFragmentBinding
    private val viewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observerData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = LoginFragmentBinding.bind(view)

        binding.navigateRegister.setOnClickListener {
            val registerFragment = RegisterFragment()
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.login_fragment, registerFragment)
                addToBackStack(null) // Optional: Add the transaction to the back stack
            }
        }

        binding.login.setOnClickListener{
            viewModel.login(LoginRequest(
                email = binding.editTextTextEmailAddress.text.toString(),
                password =  binding.editTextTextPassword.text.toString()
            ))
        }
    }
    private fun validateEmail():Boolean{
        var error:String? = null
        val value:String = binding.editTextTextEmailAddress.text.toString()
        if(value.isEmpty()){
            error = "Email is required"
        }else if(!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            error = "Email address is invalid"
        }
        return error == null
    }
    private fun validatePassword():Boolean{
        val passwordRegex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+\$).{8,25}\$")
        var error:String? = null
        val value:String = binding.editTextTextPassword.text.toString()
        if(value.isEmpty()){
            error = "Password is required"
        }else if(value.matches(passwordRegex)){
            error = "Password address is invalid"
        }
        return error == null
    }
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")

    }
    private fun observerData(){
        viewModel.authLiveData.observe(this){
            when(it){
                is AuthApiState.Success ->{
                    val noteFragment = AllNotesFragment()
                    parentFragmentManager.commit {
                        replace(R.id.login_fragment, noteFragment)
                        addToBackStack(null) // Optional: Add the transaction to the back stack

                    }
                }
                is AuthApiState.Error ->{
                    binding.login.text = it.message
                }
                is AuthApiState.loading ->{

                }

            }
        }
    }
}
