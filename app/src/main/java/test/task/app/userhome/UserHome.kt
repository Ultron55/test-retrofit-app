package test.task.app.userhome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import test.task.app.MainActivity
import test.task.app.MainViewModel
import test.task.app.R
import test.task.app.databinding.UserHomeBinding
import test.task.app.utils.safeNavigate

class UserHome : Fragment() {
    private var _binding: UserHomeBinding? = null
    val binding get() = _binding!!
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        viewModel.getPayments()
        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.logout_menu_item -> {
                    if (viewModel.logout()) {
                        safeNavigate(findNavController(), UserHomeDirections.userHomeToSplash())
                    }
                    true
                }
                else -> false
            }
        }
        binding.toolbar.setNavigationOnClickListener { binding.drawerLayout.open() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}