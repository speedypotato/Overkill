package com.example.overkill.ui.simple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

import com.example.overkill.R
import kotlinx.android.synthetic.main.fragment_simple_player.*

/**
 * A simple [Fragment] subclass.
 * Use the [SimplePlayerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SimplePlayerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_simple_player, container, false)

        simpleViewModel = ViewModelProviders.of(this).get(SimpleViewModel::class.java)
        simpleViewModel.playerHealth.observe(viewLifecycleOwner, Observer {
            text_health.text = it.toString()
        })

        root.findViewById<ImageButton>(R.id.subtractButton).apply {
            setOnClickListener { subtractOnClick() }
        }

        root.findViewById<ImageButton>(R.id.imageButton10).apply {
            setOnClickListener { subtractReturnOnClick() }
        }

        initViews()

        return root
    }

    private fun initViews() {
        root.findViewById<ConstraintLayout>(R.id.simpleCalcView).visibility = View.GONE
        root.findViewById<ConstraintLayout>(R.id.simpleOptionsView).visibility = View.VISIBLE
    }

    private fun subtractOnClick() {
        root.findViewById<ConstraintLayout>(R.id.simpleOptionsView).visibility = View.GONE
        root.findViewById<ConstraintLayout>(R.id.simpleCalcView).visibility = View.VISIBLE
    }

    private fun subtractReturnOnClick() {
        root.findViewById<ConstraintLayout>(R.id.simpleCalcView).visibility = View.GONE
        root.findViewById<ConstraintLayout>(R.id.simpleOptionsView).visibility = View.VISIBLE
    }

    private lateinit var root: View
    private lateinit var simpleViewModel: SimpleViewModel
}
