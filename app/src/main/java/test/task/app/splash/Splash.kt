package test.task.app.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import test.task.app.databinding.SplashBinding
import test.task.app.utils.safeNavigate

class Splash: Fragment() {

    private var _binding: SplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.postDelayed({
            _binding ?: return@postDelayed
            safeNavigate(findNavController(), SplashDirections.splashToAuth())
        }, 1000)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}