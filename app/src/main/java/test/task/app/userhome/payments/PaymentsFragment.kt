package test.task.app.userhome.payments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import test.task.app.MainActivity
import test.task.app.MainViewModel
import test.task.app.databinding.PaymentsBinding

class PaymentsFragment : Fragment() {
    private var _binding: PaymentsBinding? = null
    private val binding get() = _binding!!
    lateinit var viewmodel: MainViewModel
    lateinit var adapter: PaymentsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PaymentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = (activity as MainActivity).viewModel
        adapter = PaymentsRecyclerAdapter()
        binding.paymentsRV.adapter = adapter
        binding.paymentsRV.layoutManager = LinearLayoutManager(requireContext())
        viewmodel.getPayments{
            binding.PrBPayments.visibility = View.INVISIBLE
            if (it != null) adapter.updateAllItem(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}