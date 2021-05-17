package com.example.carepet.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.carepet.databinding.FragmentPetDialogBinding
import com.example.carepet.enum.AffectionLevelEnum
import com.example.carepet.model.User
import com.example.carepet.storage.UserDatabase
import com.example.carepet.user.UserViewModel
import com.example.carepet.user.UserViewModelFactory

class DialogPetFragment : DialogFragment(){

    private var _binding: FragmentPetDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPetDialogBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        var userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.addPettingScore()
        binding.textViewPetDialog.text = userViewModel.message

        // remove black outer overlay, or change opacity
        dialog?.window?.also { window ->
            window.attributes?.also { attributes ->
                attributes.dimAmount = 0.0f
                window.attributes = attributes
            }
        }



    }


}