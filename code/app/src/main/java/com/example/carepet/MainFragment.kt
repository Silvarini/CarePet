package com.example.carepet

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.carepet.databinding.FragmentMainBinding
import com.example.carepet.user.UserViewModel
import kotlinx.coroutines.delay

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.buttonMedication.setOnClickListener{
            it.findNavController().navigate(MainFragmentDirections.actionMainActivityToMedication())
        }


        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onStart() {
        super.onStart()

        val videoViewPet = binding.videoViewPet

        var count = 0

        //Pet Animations
        val animationEndPet = Uri.parse("android.resource://${activity?.packageName}/${R.raw.pet_end}")
        val animationReceivingPet = Uri.parse("android.resource://${activity?.packageName}/${R.raw.pet_receiving}")
        val animationInitPet = Uri.parse("android.resource://${activity?.packageName}/${R.raw.pet_init}")
        val animationAskPet = Uri.parse("android.resource://${activity?.packageName}/${R.raw.ask_pet}")
        val animationIdle = Uri.parse("android.resource://${activity?.packageName}/${R.raw.idle}")
        val animationGreetings = Uri.parse("android.resource://${activity?.packageName}/${R.raw.greetings}")

        fun playAnimation(animation: Uri?) {
            videoViewPet.setVideoURI(animation)
            videoViewPet.start()
        }

        fun playEndPet(){
            playAnimation(animationEndPet)
            findNavController().navigate(MainFragmentDirections.actionDestinationMainToDialogPetFragment())


        }

        fun playReceivingPet(){
            playAnimation(animationReceivingPet)
        }

        fun playInitPet() {
            playAnimation(animationInitPet)
        }

        fun playAskPet(){
            playAnimation(animationAskPet)
        }

        fun playIdle() {
            playAnimation(animationIdle)
            ++count
            if(count%5 == 0){
                playAskPet()
            }
            Log.d("COUNT", count.toString())
        }



        fun setOnTouchListener() {
            videoViewPet.setOnTouchListener { v, event ->
                val pCounter = event.pointerCount

                for (i in 0 until pCounter){
                    val x=event.getX(i)
                    val y=event.getY(i)
                    val act=event.action
                    val actIndex=event.actionIndex
                    val id=event.getPointerId(i)
                    var actString : String

                    when(act){
                        MotionEvent.ACTION_DOWN -> actString = "petInit"
                        //MotionEvent.ACTION_SCROLL -> actString = "petRECEIVE"
                        MotionEvent.ACTION_UP -> actString = "petEND"
                        else -> actString = ""
                    }

                    if(actString=="petInit") {
                        playInitPet()
                        videoViewPet.setOnCompletionListener {
                            playReceivingPet()
                        }
                    }else if(actString=="petEND"){
                        playEndPet()
                        videoViewPet.setOnCompletionListener {
                            actString=""
                            playIdle()

                        }

                    }
                }

                true
            }
        }

        setOnTouchListener()



        fun playGreetings() {
            playAnimation(animationGreetings)
            videoViewPet.setOnCompletionListener {
                playIdle()
            }
        }

        playGreetings()




    }




}










