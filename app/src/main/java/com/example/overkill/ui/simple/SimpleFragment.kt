package com.example.overkill.ui.simple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.overkill.R

class SimpleFragment : Fragment() {

    private lateinit var simpleViewModel: SimpleViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        simpleViewModel =
                ViewModelProviders.of(this).get(SimpleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_simple, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        simpleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
