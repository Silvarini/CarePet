package com.example.carepet.medication

import android.Manifest
import android.app.*
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.carepet.R
import com.example.carepet.common.Constants
import com.example.carepet.common.Constants.CAMERA
import com.example.carepet.databinding.FragmentMedicationAddBinding
import com.example.carepet.dialog.AlarmReceiver
import com.example.carepet.enum.DurationTypes
import com.example.carepet.model.Doses
import com.example.carepet.model.Medication
import com.example.carepet.user.UserApplication
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.android.synthetic.main.fragment_medication_doses.view.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.absoluteValue

class MedicationAddFragment : Fragment(){

    private val medicationViewModel: MedicationViewModel by activityViewModels {
        MedicationViewModelFactory((requireActivity().application as UserApplication).repository)
    }

    private var _binding: FragmentMedicationAddBinding? = null
    private val binding get() = _binding!!

    private val itemDataList = ArrayList<Doses>()



    //Medication Attributes
    var medicationId: Int = 0 // for the auto_increment to work, this needs to be 0
    var mImagePath: String = ""
    var userId: Int = 1

    //Dose Attributes
    var doseQuantity: Int = 0
    var scheduleDoseHour: Int = 0
    var scheduleDoseMinutes: Int = 0



    data class ItemData(
            val quantityTitle: String,
            val scheduleTitle: String,
            var quantityValue: Int,
            var scheduleMinutes: Int,
            var scheduleHours: Int
            )




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicationAddBinding.inflate(inflater, container, false)
        createNotificationChannel()


        binding.imageViewPhotoAdd.setOnClickListener {
            imageSelectionDialog()
            binding.imageViewPhotoAdd.visibility = View.GONE
        }


        fun initAdapterWithData(): ArrayList<ItemData>{
           val itemDataList = ArrayList<ItemData>()
            for (i in 0..medicationViewModel.takingQuantity){
                itemDataList.add(ItemData("QUANTIDADE ${i+1} DOSE", "HORARIO ${i+1} DOSE", 1, 0,0))
            }
            return itemDataList
        }



        medicationViewModel.getMedicationId.observe(viewLifecycleOwner){
            if(it != null) {
                medicationViewModel.getLastMedicationId(it)
            }
        }

        binding.buttonConfirm.setOnClickListener{
            medicationViewModel.confirmMedicationTaking()
            if(binding.fragmentContainerView.visibility != View.GONE) {
                binding.fragmentContainerView.visibility = View.GONE
            } else{
                doseQuantity = binding.listViewDoses.textView_quantity_value.text.toString().toInt()
                medicationViewModel.getDoseQuantity(doseQuantity)
                scheduleDoseHour = binding.listViewDoses.textView_schedule_hours_value.text.toString().toInt()
                medicationViewModel.getDoseHour(scheduleDoseHour)
                scheduleDoseMinutes = binding.listViewDoses.textView_schedule_minutes_value.text.toString().toInt()
                medicationViewModel.getDoseMinutes(scheduleDoseMinutes)
                medicationViewModel.saveMedication()
                findNavController().navigate(MedicationAddFragmentDirections.actionMedicationAddFragmentToDestinationMain())
            }
            val listView = binding.listViewDoses
            listView.adapter = MyCustomAdapter(this.requireContext(),initAdapterWithData())


        }


        return binding.root
    }



    private fun createNotificationChannel(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val name: CharSequence = "CarePetReminderChannel"
            val description = "Channel for Alarm Manager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("CarePet", name, importance)
            channel.description = description
            val notificationManager = activity?.getSystemService(
                NotificationManager::class.java
            )

            notificationManager?.createNotificationChannel(channel)
        }
    }


    class MyCustomAdapter(context: Context, itemDataList: ArrayList<ItemData>): BaseAdapter() {

        private val mContext: Context
        val _itemDataList = itemDataList

        init{
            mContext = context
        }

        override fun getCount(): Int {
            return _itemDataList.size-1
        }

        override fun getItem(position: Int): Any {
            return position.toLong()
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.fragment_medication_doses, parent, false)


            fun bindData(itemData:ItemData){
                rowMain.textView_quantity_title.text = itemData.quantityTitle
                rowMain.textView_schedule_title.text = itemData.scheduleTitle
                rowMain.textView_quantity_value.text = "${itemData.quantityValue}"
                rowMain.textView_schedule_hours_value.text = "${itemData.scheduleHours}"
                rowMain.textView_schedule_minutes_value.text = "${itemData.scheduleMinutes}"
            }

            fun addDose(itemData: ItemData) {
                itemData.quantityValue+=1
                rowMain.textView_quantity_value.text = "${itemData.quantityValue}"
            }

            fun minusDose(itemData: ItemData) {
                itemData.quantityValue-=1
                rowMain.textView_quantity_value.text = "${itemData.quantityValue}"
            }

            fun addHour(itemData: ItemData) {
                itemData.scheduleHours+=1
                rowMain.textView_schedule_hours_value.text = "${itemData.scheduleHours}"
            }

            fun minusHour(itemData: ItemData) {
                itemData.scheduleHours-=1
                rowMain.textView_schedule_hours_value.text = "${itemData.scheduleHours}"
            }

            fun addMinutes(itemData: ItemData) {
                itemData.scheduleMinutes+=1
                rowMain.textView_schedule_minutes_value.text = "${itemData.scheduleMinutes}"
            }

            fun minusMinutes(itemData: ItemData) {
                itemData.scheduleMinutes-=1
                rowMain.textView_schedule_minutes_value.text = "${itemData.scheduleMinutes}"
            }
            bindData(_itemDataList[position])

            rowMain.button_increment_quantity.setOnClickListener{
                addDose(_itemDataList[position])
            }

            rowMain.button_decrement_quantity.setOnClickListener{
                minusDose(_itemDataList[position])
            }

            rowMain.button_increment_hours.setOnClickListener{
                addHour(_itemDataList[position])
            }

            rowMain.button_decrement_hours.setOnClickListener{
                minusHour(_itemDataList[position])
            }

            rowMain.button_increment_minutes.setOnClickListener{
                addMinutes(_itemDataList[position])
            }

            rowMain.button_decrement_minutes.setOnClickListener{
                minusMinutes(_itemDataList[position])
            }


            return rowMain
        }

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
        mImagePath = file.absolutePath
        medicationViewModel.getMedicationImage(mImagePath)
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
                    saveImageToInternalStorage(thumbnail)
                }
            }
        }
    }




    //mImagePath = saveImageToInternalStorage()



}