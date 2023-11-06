package com.example.androidintermediate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidintermediate.databinding.FragmentHomeBinding
import kotlin.random.Random


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private var random: String = Random.nextInt(100000, 200000).toString()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //cara berpindah dari satu fragment ke fragment lain, code 001
        binding.buttonHomeFragmentGoToProfileFragment.setOnClickListener {
            val profileFragment = ProfileFragment()
            //cara mengirim data dari fragment ke fragment lain, code 002
            var bundle = Bundle()
            bundle.putString(ProfileFragment.numberRandom, random)
            profileFragment.arguments =  bundle
            //code 002

            val parentFragmentManager = parentFragmentManager
            parentFragmentManager
                .beginTransaction()
                .apply {
                    replace(  R.id.frameLayoutFragmentActivity, profileFragment, ProfileFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
        }
        //code 001

        binding.buttonHomeFragmentGoToGreetingFragment.setOnClickListener {
            val childFragmentManager = childFragmentManager

            val greetingFragment = GreetingFragment()
            greetingFragment
                .show(childFragmentManager, GreetingFragment::class.java.simpleName)
        }
    }

    var dialogListenerGreetingFragmentHomeImplementation: GreetingFragment.DialogListener = object: GreetingFragment.DialogListener {
        override fun onSubmitButtonGreetingFragmentToAnswer(data: String) {
            Toast.makeText(requireActivity(), "Your Type $data", Toast.LENGTH_SHORT).show()
        }
    }
}