package com.example.overkill.ui.simple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.overkill.R
import kotlinx.android.synthetic.main.fragment_simple_player.*
import kotlinx.android.synthetic.main.fragment_simple.*
import org.w3c.dom.Text

class SimpleFragment : Fragment() {

//    private lateinit var simpleViewModels: Array<SimpleViewModel>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_simple, container, false)
    }
}
