package com.example.carepet.dialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carepet.R
import com.example.carepet.databinding.FragmentMedicationAddBinding
import com.example.carepet.databinding.FragmentTaskDialgoBinding


class TaskDialogFragment : Fragment() {


    private var _binding: FragmentTaskDialgoBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentTaskDialgoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}