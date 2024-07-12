package com.gonzalogatius.crianza_inteligente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.Fragment

class VacaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vaca, container, false)

        val rgCantidadTerneros: RadioGroup = view.findViewById(R.id.rg_cantidad_terneros)
        val btnIrTernero: Button = view.findViewById(R.id.btn_ir_ternero_1)

        btnIrTernero.setOnClickListener {
            val selectedTerneros = when (rgCantidadTerneros.checkedRadioButtonId) {
                R.id.rb_un_ternero -> 1
                R.id.rb_dos_terneros -> 2
                R.id.rb_tres_terneros -> 3
                else -> 1
            }
            (activity as PrepartoActivity).updateTerneroCount(selectedTerneros)
            (activity as PrepartoActivity).showTerneroFragment(1)
        }

        return view
    }
}
