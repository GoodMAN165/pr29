package com.example.pr29

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), WordFragment.OnListFragmentInteractionListener {

    private val definitions = mapOf(
        "Kotlin" to "Современный язык программирования для Android.",
        "Fragment" to "Модульная часть интерфейса приложения.",
        "Activity" to "Точка входа в экран приложения."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment1, WordFragment.newInstance(definitions.keys.toTypedArray()))
                .add(R.id.fragment2, DetailFragment.newInstance("Выберите термин"))
                .commit()
        }
    }

    override fun onListFragmentInteraction(term: String) {
        val def = definitions[term] ?: "Не найдено"
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment2, DetailFragment.newInstance(def))
            .commit()
    }
}