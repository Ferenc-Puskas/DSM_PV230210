package com.example.login_authentication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sign_out -> {
                FirebaseAuth.getInstance()
                    .signOut()
                    .also {
                        Toast.makeText(
                            this,
                            "Sesión cerrada",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this, Registro::class.java)
                        startActivity(intent)
                        finish()
                    }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}