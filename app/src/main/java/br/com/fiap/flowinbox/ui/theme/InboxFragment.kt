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
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        emailAdapter = EmailAdapter(getDummyEmails())
        recyclerView.adapter = emailAdapter

        Log.d("InboxFragment", "Adapter set with ${emailAdapter.itemCount} items")


        val composeButton: Button = view.findViewById(R.id.composeButton)
        composeButton.setOnClickListener {
            findNavController().navigate(R.id.action_inboxFragment_to_composeFragment)
        }
    }

    private fun getDummyEmails(): List<Email> {
        return listOf(
            Email("Leslie Alexander", "Lorem ipsum dolor sit amet ", "10:00 AM",  R.drawable.l),
            Email("Roman Bray", "Consectetur adipiscing elit ", "9:00 AM", R.drawable.r),
            Email("Jaxson May", "Lorem ipsum dolor sit amet.Consectetur adipiscing elit  ", "8:00 AM", R.drawable.j),
            Email("Emily Clark", "Curabitur suscipit suscipit tellus ", "11:00 AM", R.drawable.e),
            Email("Daniel Smith", "Pellentesque habitant morbi tristique ", "7:30 AM", R.drawable.d),
            Email("Sophia Johnson", "Vivamus vestibulum ntulla ", "6:45 AM", R.drawable.s))
    }
}
