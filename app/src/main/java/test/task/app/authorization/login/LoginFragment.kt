package test.task.app.authorization.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import test.task.app.MainActivity
import test.task.app.MainViewModel
import test.task.app.databinding.LoginBinding
import test.task.app.utils.LOGIN
import test.task.app.utils.PASSWORD

class LoginFragment: Fragment() {

    private var _binding: LoginBinding? = null
    private val binding get() = _binding!!
    var isInLogining = false
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        binding.forgetPassTV.setOnClickListener {
            binding.loginET.setText(LOGIN)
            binding.passwordET.setText(PASSWORD)
        }
        binding.loginBtn.setOnClickListener {
            checkAuthData()
        }
        viewModel.loginIs.observe(viewLifecycleOwner) {
            if (_binding != null)
            {
                if (it) {

                }
                else if (isInLogining)
                    binding.wrongAuthDataTV.visibility = View.VISIBLE
            }
        }
    }

    private fun checkAuthData() {
        val login = binding.loginET.editableText.toString()
        val password = binding.passwordET.editableText.toString()
        if (login.length >= 4 && password.length >= 4)
            login(login, password)
        else
            binding.wrongAuthDataTV.visibility = View.VISIBLE

    }

    private fun login(login: String, password: String) {
        isInLogining = true
        viewModel.login(login, password)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}