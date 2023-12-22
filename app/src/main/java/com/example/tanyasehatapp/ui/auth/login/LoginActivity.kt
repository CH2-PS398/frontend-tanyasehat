package com.example.tanyasehatapp.ui.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.diarystoryapp.customview.button.MyButton
import com.example.diarystoryapp.customview.text.EditEmail
import com.example.diarystoryapp.customview.text.EditPassword
import com.example.diarystoryapp.ui.UserViewModelFactory
import com.example.tanyasehatapp.ui.main.MainActivity
import com.example.tanyasehatapp.R
import com.example.tanyasehatapp.databinding.ActivityLoginBinding
import com.example.tanyasehatapp.ui.auth.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel>() {
        UserViewModelFactory.getInstance(this)
    }


    private lateinit var myButton: MyButton
    private lateinit var myEditEmail: EditEmail
    private lateinit var myEditText: EditPassword

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myButton = findViewById(R.id.btn_login)
        myEditEmail = findViewById(R.id.emailEditText)
        myEditText = findViewById(R.id.passwordEditText)

        viewModel.loginStatus.observe(this, Observer { isLoggedIn ->
            if (isLoggedIn) {
                binding.progressBar.visibility = View.INVISIBLE
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        })

        myButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            binding.progressBar.visibility = View.VISIBLE

            viewModel.login(email, password)
        }

        setMyButtonEnable()

        myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {
            }
        })
    }
    private fun setMyButtonEnable() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        myButton.isEnabled = email.isNotEmpty() && password.isNotEmpty()
    }

    fun onRegisterTextClick(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}