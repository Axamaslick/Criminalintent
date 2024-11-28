package com.example.criminalintent

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import android.widget.Toast
import android.content.Intent
import android.provider.MediaStore

private lateinit var photoFile: File
private lateinit var photoUri: Uri
private lateinit var titleField: EditText
private lateinit var dateButton: Button
private lateinit var solvedCheckBox: CheckBox
private lateinit var reportButton: Button
private lateinit var suspectButton: Button
private lateinit var photoButton: ImageButton
private lateinit var photoView: ImageView

private val PICK_IMAGE_REQUEST = 1
private lateinit var crime_photo: Button
private lateinit var crime_camera: ImageView

class Addintent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_addintent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        crime_camera = findViewById(R.id.crime_camera)
        crime_photo = findViewById(R.id.crime_photo)

        // Устанавливаем обработчик нажатия на кнопку
        crime_camera.setOnClickListener {
            openGallery()
        }

    }

    // Метод для открытия галереи
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    // Обработка результата выбора изображения
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            selectedImageUri?.let {
                // Загружаем изображение в ImageView
                crime_camera.setImageURI(it)
            } ?: run {
                Toast.makeText(this, "Ошибка при выборе изображения", Toast.LENGTH_SHORT).show()
            }
        }
    }
}