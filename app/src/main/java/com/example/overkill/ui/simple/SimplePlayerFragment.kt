package com.example.overkill.ui.simple

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.overkill.CalcEnum

import com.example.overkill.R
import kotlinx.android.synthetic.main.fragment_simple_player.*
import kotlinx.android.synthetic.main.simple_calc.*

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
        root.findViewById<ImageButton>(R.id.divideButton).apply {
            setOnClickListener { divideOnClick() }
        }
        root.findViewById<ImageButton>(R.id.addButton).apply {
            setOnClickListener { addOnClick() }
        }

        root.findViewById<ImageButton>(R.id.calc0Button).apply {
            setOnClickListener { numOnClick(0) }
        }
        root.findViewById<ImageButton>(R.id.calc1Button).apply {
            setOnClickListener { numOnClick(1) }
        }
        root.findViewById<ImageButton>(R.id.calc2Button).apply {
            setOnClickListener { numOnClick(2) }
        }
        root.findViewById<ImageButton>(R.id.calc3Button).apply {
            setOnClickListener { numOnClick(3) }
        }
        root.findViewById<ImageButton>(R.id.calc4Button).apply {
            setOnClickListener { numOnClick(4) }
        }
        root.findViewById<ImageButton>(R.id.calc5Button).apply {
            setOnClickListener { numOnClick(5) }
        }
        root.findViewById<ImageButton>(R.id.calc6Button).apply {
            setOnClickListener { numOnClick(6) }
        }
        root.findViewById<ImageButton>(R.id.calc7Button).apply {
            setOnClickListener { numOnClick(7) }
        }
        root.findViewById<ImageButton>(R.id.calc8Button).apply {
            setOnClickListener { numOnClick(8) }
        }
        root.findViewById<ImageButton>(R.id.calc9Button).apply {
            setOnClickListener { numOnClick(9) }
        }
        root.findViewById<ImageButton>(R.id.calcDelButton).apply {
            setOnClickListener { calcValView.text = (calcValView.text.toString().toInt() / 10).toString() }
        }
        root.findViewById<ImageButton>(R.id.calcEqButton).apply {
            setOnClickListener { eqReturnOnClick() }
        }

        initViews()

        return root
    }

    private fun initViews() {
        root.findViewById<ConstraintLayout>(R.id.simpleCalcView).visibility = View.GONE
        root.findViewById<ConstraintLayout>(R.id.simpleOptionsView).visibility = View.VISIBLE
        calcValView = root.findViewById<TextView>(R.id.text_calc)
    }

    private fun subtractOnClick() {
        root.findViewById<ConstraintLayout>(R.id.simpleOptionsView).visibility = View.GONE
        root.findViewById<ConstraintLayout>(R.id.simpleCalcView).visibility = View.VISIBLE
        calcMode = CalcEnum.SUBTRACT
        text_calc_sign.text = "-"
    }

    private fun divideOnClick() {
        root.findViewById<ConstraintLayout>(R.id.simpleOptionsView).visibility = View.GONE
        root.findViewById<ConstraintLayout>(R.id.simpleCalcView).visibility = View.VISIBLE
        calcMode = CalcEnum.DIVIDE
        text_calc_sign.text = "÷"
    }

    private fun addOnClick() {
        root.findViewById<ConstraintLayout>(R.id.simpleOptionsView).visibility = View.GONE
        root.findViewById<ConstraintLayout>(R.id.simpleCalcView).visibility = View.VISIBLE
        calcMode = CalcEnum.ADD
        text_calc_sign.text = "+"
    }

    private fun numOnClick(num: Int) {
        if (calcValView.length() >= 9) return   //stop int overflow
        calcValView.text = (calcValView.text.toString().toInt() * 10 + num).toString()
    }

    private fun eqReturnOnClick() {
        val calcVal = calcValView.text.toString().toInt()
        if (calcVal == 0 && calcMode == CalcEnum.DIVIDE) {  //divide by zero check
            AlertDialog.Builder(this.context)
                .setTitle(resources.getString(R.string.error))
                .setMessage(resources.getString(R.string.error_divide_by_zero))
                .setPositiveButton(resources.getString(R.string.ok), null)
                .show()
            return
        }

        root.findViewById<ConstraintLayout>(R.id.simpleCalcView).visibility = View.GONE
        root.findViewById<ConstraintLayout>(R.id.simpleOptionsView).visibility = View.VISIBLE
        val pHealthView = root.findViewById<TextView>(R.id.text_health)
        when (calcMode) {
            CalcEnum.SUBTRACT -> { pHealthView.text = (pHealthView.text.toString().toInt() - calcVal).toString()}
            CalcEnum.DIVIDE -> { pHealthView.text = (pHealthView.text.toString().toInt() / calcVal).toString()}
            CalcEnum.ADD -> { pHealthView.text = (pHealthView.text.toString().toInt() + calcVal).toString()}
        }

        val curHealth = pHealthView.text.toString().toInt()
        when {
            curHealth <= 0 -> { pHealthView.setTextColor(ContextCompat.getColor(pHealthView.context, R.color.colorPrimary)) }
            else -> { pHealthView.setTextColor(ContextCompat.getColor(pHealthView.context, R.color.colorAccent)) }
        }
        calcValView.text = resources.getString(R.string.simple_calc_default)
    }

    private lateinit var calcValView: TextView
    private lateinit var calcMode: CalcEnum

    private lateinit var root: View
    private lateinit var simpleViewModel: SimpleViewModel
}
