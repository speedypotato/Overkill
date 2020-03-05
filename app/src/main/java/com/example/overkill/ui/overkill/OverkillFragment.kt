package com.example.overkill.ui.overkill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.overkill.R

class OverkillFragment : Fragment() {

    private lateinit var overkillViewModel: OverkillViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        overkillViewModel =
                ViewModelProviders.of(this).get(OverkillViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_overkill, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        overkillViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
