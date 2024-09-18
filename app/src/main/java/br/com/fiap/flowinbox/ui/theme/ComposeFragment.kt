package br.com.fiap.flowinbox.ui.theme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.fiap.flowinbox.R

class ComposeFragment : Fragment(R.layout.compose_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipientEditText = view.findViewById<EditText>(R.id.recipientEditText)
        val subjectEditText = view.findViewById<EditText>(R.id.subjectEditText)
        val messageEditText = view.findViewById<EditText>(R.id.messageEditText)

        view.findViewById<Button>(R.id.sendButton).setOnClickListener {
            val recipient = recipientEditText.text.toString()
            val subject = subjectEditText.text.toString()
            val message = messageEditText.text.toString()

            if (recipient.isNotEmpty() && subject.isNotEmpty() && message.isNotEmpty()) {
                sendEmail(recipient, subject, message)
            } else {

                Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822" // Especifica que o intent é para e-mails
            putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient)) // Destinatário
            putExtra(Intent.EXTRA_SUBJECT, subject) // Assunto
            putExtra(Intent.EXTRA_TEXT, message) // Mensagem
        }

        // Verifica se há algum app de e-mail para tratar o intent
        try {
            startActivity(Intent.createChooser(intent, "Escolha o app de e-mail"))
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Não há nenhum app de e-mail disponível", Toast.LENGTH_SHORT).show()
        }
    }
}
