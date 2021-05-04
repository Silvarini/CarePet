package com.example.carepet

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

lateinit var videoViewPet: VideoView
lateinit var mMediaPlayer: MediaPlayer

var mCurrentVideoPosition: Int = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        playVideo(selectUri())

}

    private fun selectUri(): Uri? {
        val videoGreetings = Video(R.raw.greetings,false)
        val videoAsk = Video(R.raw.ask_pet,false)
        val videoIdle = Video(R.raw.idle,true)
        val videoPetEnd = Video(R.raw.pet_end,false)
        val videoPetInit = Video(R.raw.pet_init,false)
        val videoPetReceiving = Video(R.raw.pet_receiving,true)

        val uri = Uri.parse("""android.resource://$packageName/${videoGreetings.videoID}""")
        return uri
    }

    private fun playVideo(video: Video){

        videoViewPet = findViewById<VideoView>(R.id.videoView_pet)

        videoViewPet.setVideoURI(video.videoID)

        videoViewPet.start()

        videoViewPet.setOnPreparedListener { mp ->

            mMediaPlayer = mp

            if (video.loopable) mMediaPlayer.isLooping = true

            if(mCurrentVideoPosition != 0){
                mMediaPlayer.seekTo(mCurrentVideoPosition)
                mMediaPlayer.start()

            }

        }
    }

   data class Video(var videoID: Int, var loopable: Boolean)


    override fun onPause() {

        super.onPause()


        mCurrentVideoPosition = mMediaPlayer.currentPosition

        videoViewPet.pause()

    }


    override fun onResume() {

        super.onResume()


        videoViewPet.start()

    }


    override fun onDestroy() {

        super.onDestroy()


        mMediaPlayer.release()

        //mMediaPlayer = null

    }

}