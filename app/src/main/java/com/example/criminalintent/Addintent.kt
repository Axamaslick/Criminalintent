package com.example.criminalintent

import android.net.Uri
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import java.io.File

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

