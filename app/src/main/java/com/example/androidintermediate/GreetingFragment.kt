package com.example.androidintermediate

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.androidintermediate.databinding.FragmentGreetingBinding


class GreetingFragment : DialogFragment() {

    private lateinit var binding: FragmentGreetingBinding
    private var dialogListener: DialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGreetingBinding.inflate(inflater, container, false)
        return binding.root

    }

    /**
     * method onViewCreated()
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.buttonGreetingFragmentToAnswer.setOnClickListener {
            dialogListener?.onSubmitButtonGreetingFragmentToAnswer(binding.editTextGreetingFragment.text.toString())
            dialog?.dismiss()
        }

    }

    override fun onAttach(context: Context)/*method onAttach() ini akan di eksekusi saat fragment ini running*/ {
        super.onAttach(context)
        Log.d("GreetingFragment", "Greeting Dialog Fragment Is Running")

        val parentFragment = parentFragment
        if (parentFragment is HomeFragment)  {
            Log.d("GreetingFragment", "The Greeting Dialog Fragment Start From Home Fragment")
            this.dialogListener = parentFragment.dialogListenerGreetingFragmentHomeImplementation
            return
        }
        if (parentFragment is ProfileFragment) {
            Log.d("GreetingFragment", "The Greeting Dialog Fragment Start From Profile Fragment")
            this.dialogListener = parentFragment.dialogListenerGreetingFragmentProfileImplementation
            return
        }

    }

    override fun onDetach()/*method onDetach() ini akan di eksekusi saat fragment ini di berhenti running*/ {
        super.onDetach()
        Log.d("GreetingFragment", "Greeting Dialog Fragment Is Stop")

        this.dialogListener = null
    }


    interface DialogListener {
        fun onSubmitButtonGreetingFragmentToAnswer(data: String)
    }


}