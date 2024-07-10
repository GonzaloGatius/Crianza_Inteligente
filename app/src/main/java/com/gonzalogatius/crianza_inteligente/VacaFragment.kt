package com.gonzalogatius.crianza_inteligente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class VacaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vaca, container, false)

        val btnIrTernero: Button = view.findViewById(R.id.btn_ir_ternero_1)
        btnIrTernero.setOnClickListener {
            (activity as PrepartoActivity).showTerneroFragment(1) // Cambia el número según el ternero
        }

        return view
    }
}
