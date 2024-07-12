package com.gonzalogatius.crianza_inteligente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class TerneroFragment : Fragment() {

    private var terneroNumber: Int? = null
    private var totalTerneros: Int = 1 // Cambia este valor según los datos reales

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            terneroNumber = it.getInt("terneroNumber")
            totalTerneros = it.getInt("totalTerneros", 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ternero, container, false)

        // Actualizar el título con el número del ternero
        val tituloTernero: TextView = view.findViewById(R.id.tv_titulo_ternero)
        tituloTernero.text = "Ternero $terneroNumber"

        // Actualizar los hints de los EditText y otros elementos
        val etRpTernero: EditText = view.findViewById(R.id.et_rp_ternero)
        etRpTernero.hint = "RP del Ternero $terneroNumber"

        val etCantidadCalostro: EditText = view.findViewById(R.id.et_cantidad_calostro)
        etCantidadCalostro.hint = "Cantidad Calostro (en Litros) - Ternero $terneroNumber"

        val etObservaciones: EditText = view.findViewById(R.id.et_observaciones)
        etObservaciones.hint = "Observaciones Ternero $terneroNumber"

        // Configurar el botón "Volver a Vaca Madre"
        val btnVolverAVaca: Button = view.findViewById(R.id.btn_volver_a_vaca)
        btnVolverAVaca.setOnClickListener {
            (requireActivity() as PrepartoActivity).showVacaFragment()
        }

        // Configurar el botón "Guardar e ir al siguiente Ternero"
        val btnIrSiguienteTernero: Button = view.findViewById(R.id.btn_ir_siguiente_ternero)
        if (terneroNumber == totalTerneros) {
            btnIrSiguienteTernero.visibility = View.GONE
        } else {
//            btnIrSiguienteTernero.text = "Guardar e ir al siguiente Ternero"
//            btnIrSiguienteTernero.setOnClickListener {
//                terneroNumber?.let { currentTernero ->
//                    if (currentTernero < totalTerneros) {
//                        (requireActivity() as PrepartoActivity).onNextTernero()
//                    }
//                }
//            }
            btnIrSiguienteTernero.setOnClickListener {
                (requireActivity() as PrepartoActivity).onNextTernero()
            }
        }

        // Mostrar un mensaje para verificar el número del ternero
        Toast.makeText(requireContext(), "Ternero número: $terneroNumber", Toast.LENGTH_SHORT)
            .show()

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(terneroNumber: Int, totalTerneros: Int) =
            TerneroFragment().apply {
                arguments = Bundle().apply {
                    putInt("terneroNumber", terneroNumber)
                    putInt("totalTerneros", totalTerneros)
                }
            }
    }

    // Interfaz para manejar eventos en PrepartoActivity desde TerneroFragment
    interface OnNextTerneroListener {
        fun onNextTernero()
    }
}
