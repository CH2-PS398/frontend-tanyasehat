package com.example.tanyasehatapp.ui.auth.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.diarystoryapp.data.Response.Result
import com.example.diarystoryapp.ui.UserViewModelFactory
import com.example.tanyasehatapp.R
import com.example.tanyasehatapp.databinding.ActivityRegisterBinding
import com.example.tanyasehatapp.ui.auth.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>() {
        UserViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.btnSignUp.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.passwordconfirmEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    viewModel.register(name, email, password)

                    viewModel.signupresult.observe(this) { result ->
                        when (result) {

                            Result.Empty -> {
                                "diisi dulu"
                            }

                            is Result.Error -> {
                                binding.progressBar.visibility = View.INVISIBLE
                                val error = result.error
                                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                            }

                            Result.Loading -> binding.progressBar.visibility = View.VISIBLE
                            is Result.Success -> {
                                binding.progressBar.visibility = View.INVISIBLE
                                Toast.makeText(
                                    this,
                                    getString(R.string.register_successfull),
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                            }
                        }
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Password and Confirm Password do not match",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        fun onLoginTextClick(view: View) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
