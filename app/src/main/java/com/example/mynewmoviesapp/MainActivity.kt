package com.example.mynewmoviesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mynewmoviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var number = 1

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val note = NoteData("Заметка", "Очень длинное описание заметки")

        val noteCopy = note.copy(title = "Копия Заметки")

        binding.buttonPlus.setOnClickListener {
            clickPlus()
        }

        binding.buttonMinus.setOnClickListener {
            clickMinus()
        }

        binding.buttonShowTextNote.setOnClickListener {
            binding.textNote.setText(note.title + "\n" + note.description)
        }

        binding.buttonShowTextCopyNote.setOnClickListener {
            binding.textNote.setText(noteCopy.title + "\n" + noteCopy.description)
        }

        for(i in 1..10) {
            print("Заметка $i \n")
        }

        for(i in 10 downTo 1 step 2) {
            print("Заметка $i \n")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun clickPlus () {
        binding.textView.text = "Кнопка нажата " + (number++) + " раз(а)"
    }

    @SuppressLint("SetTextI18n")
    private fun clickMinus () {
        binding.textView.text = "Кнопка нажата " + (number--) + " раз(а)"
    }

}