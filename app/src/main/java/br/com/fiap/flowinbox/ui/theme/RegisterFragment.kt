package br.com.fiap.flowinbox.ui.theme

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.flowinbox.R

class RegisterFragment : Fragment(R.layout.register_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.registerButton).setOnClickListener {
            // Lógica para registrar o usuário (validação e chamada para backend, etc.)

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        view.findViewById<TextView>(R.id.loginLink).setOnClickListener {
            findNavController().navigate(R.id.action_resgisteFragment_to_loginFragment)
        }
    }
}
