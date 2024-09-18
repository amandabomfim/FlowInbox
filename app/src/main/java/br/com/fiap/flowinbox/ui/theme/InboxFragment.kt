package br.com.fiap.flowinbox.ui.theme

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.flowinbox.R
import br.com.fiap.flowinbox.adapter.EmailAdapter
import br.com.fiap.flowinbox.data.Email

class InboxFragment : Fragment(R.layout.inbox_fragment) {

    private lateinit var emailAdapter: EmailAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("InboxFragment", "onViewCreated called")  // Log para depuração

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())  // Adiciona o LayoutManager
        emailAdapter = EmailAdapter(getDummyEmails())
        recyclerView.adapter = emailAdapter

        Log.d("InboxFragment", "Adapter set with ${emailAdapter.itemCount} items")  // Verifica se o adapter foi configurado
    }

    private fun getDummyEmails(): List<Email> {
        return listOf(
            Email("Leslie Alexander", "Lorem ipsum dolor sit amet", "10:00 AM",  R.drawable.l),
            Email("Roman Bray", "Consectetur adipiscing elit", "9:00 AM", R.drawable.r),
            Email("Jaxson May", "Lorem ipsum dolor sit amet.Consectetur adipiscing elit", "8:00 AM", R.drawable.j)
        )
    }
}