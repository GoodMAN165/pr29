package com.example.pr29

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class WordFragment : ListFragment() {

    private var listener: OnListFragmentInteractionListener? = null

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(term: String)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val terms = arguments?.getStringArray("terms") ?: arrayOf("Kotlin", "Fragment", "Activity")
        listAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, terms)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        val term = listAdapter?.getItem(position) as String
        listener?.onListFragmentInteraction(term)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) listener = context
    }

    companion object {
        fun newInstance(terms: Array<String>): WordFragment {
            val fragment = WordFragment()
            val args = Bundle()
            args.putStringArray("terms", terms)
            fragment.arguments = args
            return fragment
        }
    }
}