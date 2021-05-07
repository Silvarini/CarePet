package com.example.carepet.view.activities


import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import com.example.carepet.R
import com.example.carepet.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var pDownX=0
    var pDownY=0
    var pUpX=0
    var pUpY=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }



        val videoViewPet = binding.videoViewPet


        fun playAnimation(animation: Uri?) {
            videoViewPet.setVideoURI(animation)
            videoViewPet.start()
        }

        fun playendPet(){
            val animationEndPet = Uri.parse("android.resource://$packageName/${R.raw.pet_end}")
            playAnimation(animationEndPet)
        }

        fun playReceivingPet(){
            val animationReceivingPet = Uri.parse("android.resource://$packageName/${R.raw.pet_receiving}")
            playAnimation(animationReceivingPet)
        }

        fun playInitPet() {
            val animationInitPet = Uri.parse("android.resource://$packageName/${R.raw.pet_init}")
            playAnimation(animationInitPet)
        }

        fun playAskPet(){
            val animationAskPet = Uri.parse("android.resource://$packageName/${R.raw.ask_pet}")
            playAnimation(animationAskPet)
        }

        var count = 0
        fun playIdle() {
            val animationIdle = Uri.parse("android.resource://$packageName/${R.raw.idle}")
            playAnimation(animationIdle)
            ++count
            if(count%5 == 0){
                playAskPet()
            }
            Log.d("COUNT", count.toString());
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
                        playendPet()
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
            val animationGreetings = Uri.parse("android.resource://$packageName/${R.raw.greetings}")
            playAnimation(animationGreetings)
            videoViewPet.setOnCompletionListener {
                playIdle()
            }
        }

    playGreetings()

    }




}

