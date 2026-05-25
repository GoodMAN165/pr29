package com.example.pr29

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tv = TextView(context)
        tv.text = arguments?.getString("def") ?: "Выберите термин"
        tv.textSize = 20f
        return tv
    }

    companion object {
        fun newInstance(def: String): DetailFragment {
            val f = DetailFragment()
            val b = Bundle()
            b.putString("def", def)
            f.arguments = b
            return f
        }
    }
}