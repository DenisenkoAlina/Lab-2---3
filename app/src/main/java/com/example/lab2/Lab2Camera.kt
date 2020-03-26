package com.example.lab2

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab2_camera.*

class Lab2Camera : AppCompatActivity() {

    private val cameraRequest = 0
    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2_camera)
        title = "Camera"

        imageView = pictureImage
    }

    fun onClick(v: View?) {
        try {
            // Неявний намір для зупуску камери
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, cameraRequest)
        } catch (e: ActivityNotFoundException) {
            // Виводимо помідомлення про помилку
            val errorMessage = "Ваше устройство не поддерживает съемку"
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == cameraRequest && resultCode == Activity.RESULT_OK) {
            // Зробили фото, витягуємо картинку
            val thumbnailBitmap = data!!.extras!!["data"] as Bitmap?
            imageView!!.setImageBitmap(thumbnailBitmap)
        }
    }
}
