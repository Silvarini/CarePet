package com.example.carepet.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.example.carepet.databinding.FragmentMainBinding
import com.example.carepet.databinding.FragmentPetDialogBinding
import com.example.carepet.enum.AffectionLevelEnum
import com.example.carepet.model.User
import com.example.carepet.storage.UserDatabase
import com.example.carepet.user.UserApplication
import com.example.carepet.user.UserViewModel
import com.example.carepet.user.UserViewModelFactory

//import com.example.carepet.user.UserViewModelFactory

class DialogPetFragment : DialogFragment(){

    private var _binding: FragmentPetDialogBinding? = null
    private val binding get() = _binding!!

    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory((requireActivity().application as UserApplication).repository)
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPetDialogBinding.inflate(inflater, container, false)

       // userViewModel.user.observe(viewLifecycleOwner) {
            // update UI
        //}

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        userViewModel.getAllUserData.observe(viewLifecycleOwner) {
            scores ->
            scores.let {
                for(item in it){
                    var message = userViewModel.choosePettingMessage(userViewModel.calculateAffectionScore(item.pettingScore, item.taskScore))
                    binding.textViewPetDialog.setText(message)
                }
            }
        }

        // remove black outer overlay, or change opacity
        dialog?.window?.also { window ->
            window.attributes?.also { attributes ->
                attributes.dimAmount = 0.0f
                window.attributes = attributes
            }
        }



    }


}