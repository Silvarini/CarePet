package com.example.carepet.medication

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carepet.R
import com.example.carepet.common.Constants
import com.example.carepet.databinding.FragmentMedicationAddBinding
import com.karumi.dexter.Dexter
import kotlinx.android.synthetic.main.fragment_medication_add.view.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*
import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import com.example.carepet.common.Constants.CAMERA
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

class MedicationAddFragment : Fragment() {

    private var _binding: FragmentMedicationAddBinding? = null
    private val binding get() = _binding!!


    private val mImagePath: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedicationAddBinding.inflate(inflater, container, false)

        binding.imageViewPhotoAdd.setOnClickListener{
                imageSelectionDialog()
                binding.imageViewPhotoAdd.visibility = View.GONE

        }


        return binding.root
    }


    private fun saveImageToInternalStorage(
            bitmap: Bitmap
    ): String{
        val wrapper = ContextWrapper(
                context
        )

        var file = wrapper.getDir(
                Constants.IMAGE_DIRECTORY,
                Context.MODE_PRIVATE
        ) //only accesed by application
        file = File(
                file,
                "${UUID.randomUUID()}.jpg"
        )

        try{
            val stream : OutputStream = FileOutputStream(
                    file
            )
            bitmap.compress(
                    Bitmap.CompressFormat.JPEG,
                    80,
                    stream)
            stream.flush()
            stream.close()
        }catch (e: IOException){
            e.printStackTrace()
        }

        return file.absolutePath
    }




    private fun imageSelectionDialog(){

        Dexter.withContext(this.activity)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA
        ).withListener(
        object: MultiplePermissionsListener {
            override fun onPermissionsChecked(
                    report: MultiplePermissionsReport?
            ) {
                report?.let{
                    if(report.areAllPermissionsGranted()){
                        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                        startActivityForResult(intent, CAMERA)
                    }
                }
            }

            override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
            ) {
                showRationalDialogForPermissions()
            }

        }

        ).onSameThread().check()




    }

    private fun showRationalDialogForPermissions(){
        AlertDialog.Builder(this.activity).setMessage("It looks like you have turned off permissions")
                .setPositiveButton("GO TO SETTINGS"){
                    _,_ ->
                    try{
                        val intent = Intent(Settings.ACTION_APPLICATION_SETTINGS)
                        val uri = Uri.fromParts(
                                "package",
                                activity?.packageName,
                                null)
                        intent.data = uri
                        startActivity(intent)
                    }catch (e: ActivityNotFoundException){
                        e.printStackTrace()
                    }
                }
                .setNegativeButton("Cancel"){dialog,_ ->
                        dialog.dismiss()
                }.show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == CAMERA){
                data?.extras?.let{
                    val thumbnail : Bitmap = data.extras!!.get("data") as Bitmap
                    binding.imageViewMedicationImage.setImageBitmap(thumbnail)
                }
            }
        }
    }

    //mImagePath = saveImageToInternalStorage()

}