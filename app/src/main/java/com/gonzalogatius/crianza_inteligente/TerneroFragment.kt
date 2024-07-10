package com.gonzalogatius.crianza_inteligente


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class TerneroFragment : Fragment() {

    private var terneroNumber: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            terneroNumber = it.getInt("terneroNumber")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ternero, container, false)

        // Mostrar un mensaje para verificar el número del ternero
        Toast.makeText(requireContext(), "Ternero número: $terneroNumber", Toast.LENGTH_LONG).show()

        return view
    }
}