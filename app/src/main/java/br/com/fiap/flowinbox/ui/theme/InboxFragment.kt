package br.com.fiap.flowinbox.ui.theme

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.flowinbox.R
import br.com.fiap.flowinbox.adapter.EmailAdapter
import br.com.fiap.flowinbox.data.Email

class InboxFragment : Fragment(R.layout.inbox_fragment) {

    private lateinit var emailAdapter: EmailAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        emailAdapter = EmailAdapter(getDummyEmails())
        recyclerView.adapter = emailAdapter

        view.findViewById<Button>(R.id.composeButton).setOnClickListener {
            findNavController().navigate(R.id.action_inboxFragment_to_composeFragment)
        }
    }

    private fun getDummyEmails(): List<Email> {
        return listOf(
            Email("Leslie Alexander", "Lorem ipsum dolor sit amet", "8:00 AM"),
            Email("Roman Bray", "Consectetur adipiscing elit", "9:00 AM")
        )
    }
}