package br.com.fiap.flowinbox.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.flowinbox.R
import br.com.fiap.flowinbox.data.Email

class EmailAdapter(private val emailList: List<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderTextView: TextView = itemView.findViewById(R.id.senderTextView)
        val subjectTextView: TextView = itemView.findViewById(R.id.subjectTextView)
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        val senderImageView: ImageView = itemView.findViewById(R.id.senderImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.senderTextView.text = email.sender
        holder.subjectTextView.text = email.subject
        holder.timeTextView.text = email.time
        holder.senderImageView.setImageResource(email.imageResId)
    }

    override fun getItemCount(): Int {
        return emailList.size
    }
}

