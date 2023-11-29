package test.task.app.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import test.task.app.databinding.AuthBinding
import test.task.app.utils.safeNavigate

class AuthFragment: Fragment() {

    private var _binding: AuthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.openLoginBtn.setOnClickListener {
            safeNavigate(findNavController(), AuthFragmentDirections.authToLogin())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}