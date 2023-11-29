package test.task.app.userhome.payments

import android.annotation.SuppressLint
import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import test.task.app.R
import test.task.app.authorization.Payment
import java.text.SimpleDateFormat

class PaymentsRecyclerAdapter : RecyclerView.Adapter<PaymentsRecyclerAdapter.ViewHolder>() {

    val payments = ArrayList<Payment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.payment_item, parent, false))

    override fun getItemCount(): Int = payments.size

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTV.text = payments[position].title
        holder.idTV.text = payments[position].id.toString()
        holder.amountTV.text = payments[position].amount ?: "X"
        val created = payments[position].created
        if (created == null) holder.createdTV.text = "X"
        else {
            val time : Long =
            try {
                created.toLong()
            } catch (_ : Exception) {
                holder.createdTV.text = "X"
                return
            }
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = time
            val date = SimpleDateFormat("dd.mm.yyyy").format(calendar.time)
            holder.createdTV.text = date
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAllItem(list: List<Payment>) {
        payments.clear()
        payments.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleTV : TextView = view.findViewById(R.id.payment_titleTV)
        val idTV : TextView = view.findViewById(R.id.payment_idTV)
        val amountTV : TextView = view.findViewById(R.id.payment_amountTV)
        val createdTV : TextView = view.findViewById(R.id.payment_createdTV)
    }
}
