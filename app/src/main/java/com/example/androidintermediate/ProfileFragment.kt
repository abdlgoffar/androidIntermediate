package com.example.androidintermediate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidintermediate.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {


    companion object {
        var numberRandom = "number random"
    }

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //cara menangkap data yang dikirim dari fragment, code 001
        if (arguments != null) binding.textViewProfileFragmentRandom.text = "The number random: ${arguments?.getString(numberRandom)}"
        //code 001

        binding.buttonProfileFragmentGoToHomeFragment.setOnClickListener {
            val parentFragmentManager = parentFragmentManager
            parentFragmentManager
                .beginTransaction()
                .apply {
                    replace(  R.id.frameLayoutFragmentActivity, HomeFragment(), HomeFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
        }

        binding.buttonProfileFragmentGoToGreetingFragment.setOnClickListener {
            val childFragmentManager = childFragmentManager
            val greetingFragment = GreetingFragment()
            greetingFragment
                .show(childFragmentManager, GreetingFragment::class.java.simpleName)
        }
    }

    var dialogListenerGreetingFragmentProfileImplementation: GreetingFragment.DialogListener = object: GreetingFragment.DialogListener {
        override fun onSubmitButtonGreetingFragmentToAnswer(data: String) {
            Toast.makeText(requireActivity(), "Your Type $data", Toast.LENGTH_SHORT).show()
        }
    }
}