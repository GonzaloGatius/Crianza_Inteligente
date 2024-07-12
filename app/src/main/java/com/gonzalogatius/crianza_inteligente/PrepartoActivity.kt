package com.gonzalogatius.crianza_inteligente

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class PrepartoActivity : AppCompatActivity(), TerneroFragment.OnNextTerneroListener {

    private var totalTerneros: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preparto)

        // Mostrar el fragment de la vaca madre al inicio
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, VacaFragment())
                .commit()
        }

//        // Configurar el botón Volver a Vaca Madre
//        val btnVolverAVaca = findViewById<Button>(R.id.btn_volver_a_vaca)
//        btnVolverAVaca.setOnClickListener {
//            // Aquí se debe hacer el intent para volver al fragment de la vaca madre
//            supportFragmentManager.popBackStackImmediate()
//        }
    }
    fun updateTerneroCount(count: Int) {
        totalTerneros = count
    }
    override fun onNextTernero() {
        // Lógica para navegar al siguiente ternero
        val terneroActual = supportFragmentManager.findFragmentById(R.id.fragment_container) as TerneroFragment?
        val terneroNumber = terneroActual?.arguments?.getInt("terneroNumber", 1) ?: 1

        // Determinar hacia dónde navegar
        when (terneroNumber) {
            1 -> showTerneroFragment(2)
            2 -> showTerneroFragment(3)
            // No hacer nada si ya se está en el tercer ternero
        }
    }

    // Método para cambiar de fragment
    fun showTerneroFragment(terneroNumber: Int) {
        val terneroFragment = TerneroFragment.newInstance(terneroNumber, totalTerneros)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, terneroFragment)
            .addToBackStack(null)
            .commit()
    }

    fun showVacaFragment() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

}






//class PrepartoActivity : AppCompatActivity() {
//
//    // V A C A   M A D R E
//    private lateinit var rpmadre: EditText
//    private lateinit var spinnerTipoParto: Spinner
//    private lateinit var spinnerHoraParto: Spinner
//    private lateinit var rgCantidadTerneros: RadioGroup
//    private lateinit var rbUnTernero: RadioButton
//    private lateinit var rbDosTerneros: RadioButton
//    private lateinit var rbTresTerneros: RadioButton
//    private lateinit var rgVacaVaquillona: RadioGroup
//    private lateinit var rbVaca: RadioButton
//    private lateinit var rbVaquillona: RadioButton
//    private lateinit var edObservaciones: EditText
//
//    // T E R N E R O  1
//    private lateinit var etRpTernero1: EditText
//    private lateinit var rgTernero1: RadioGroup
//    private lateinit var rbTernero1MachoVivo: RadioButton
//    private lateinit var rbTernero1HembraViva: RadioButton
//    private lateinit var rbTernero1MachoMuerto: RadioButton
//    private lateinit var rbTernero1HembraMuerta: RadioButton
//    private lateinit var spinnerVitalidadTernero1: Spinner
//    private lateinit var etCantidadCalostroTernero1: EditText
//    private lateinit var spinnerCalidadCalostroTernero1: Spinner
//    private lateinit var etObservacionesTernero1: EditText
//
//    // T E R N E R O  2
//    private lateinit var etRpTernero2: EditText
//    private lateinit var rgTernero2: RadioGroup
//    private lateinit var rbTernero2MachoVivo: RadioButton
//    private lateinit var rbTernero2HembraViva: RadioButton
//    private lateinit var rbTernero2MachoMuerto: RadioButton
//    private lateinit var rbTernero2HembraMuerta: RadioButton
//    private lateinit var spinnerVitalidadTernero2: Spinner
//    private lateinit var etCantidadCalostroTernero2: EditText
//    private lateinit var spinnerCalidadCalostroTernero2: Spinner
//    private lateinit var etObservacionesTernero2: EditText
//
//    // T E R N E R O  3
//    private lateinit var etRpTernero3: EditText
//    private lateinit var rgTernero3: RadioGroup
//    private lateinit var rbTernero3MachoVivo: RadioButton
//    private lateinit var rbTernero3HembraViva: RadioButton
//    private lateinit var rbTernero3MachoMuerto: RadioButton
//    private lateinit var rbTernero3HembraMuerta: RadioButton
//    private lateinit var spinnerVitalidadTernero3: Spinner
//    private lateinit var etCantidadCalostroTernero3: EditText
//    private lateinit var spinnerCalidadCalostroTernero3: Spinner
//    private lateinit var etObservacionesTernero3: EditText
//
//    // B O T O N   G U A R D A R
//    private lateinit var btnGuardar: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_preparto)
//
//        // V A C A   M A D R E
//        rpmadre = findViewById(R.id.ed_rpmadre)
//        spinnerTipoParto = findViewById(R.id.spinner_tipoparto)
//        spinnerHoraParto = findViewById(R.id.spinner_horaparto)
//        rgCantidadTerneros = findViewById(R.id.rg_cantidadterneros)
//        rbUnTernero = findViewById(R.id.rb_unternero)
//        rbDosTerneros = findViewById(R.id.rb_dosterneros)
//        rbTresTerneros = findViewById(R.id.rb_tresterneros)
//        rgVacaVaquillona = findViewById(R.id.rg_vacavaquillona)
//        rbVaca = findViewById(R.id.rb_vaca)
//        rbVaquillona = findViewById(R.id.rb_vaquillona)
//        edObservaciones = findViewById(R.id.ed_observaciones_vaca_madre)
//
//        // Configuración de inputType
//        rpmadre.inputType = InputType.TYPE_CLASS_NUMBER
//        edObservaciones.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
//
//        // Configurar Spinners
//        configurarSpinner(spinnerTipoParto, R.array.tipo_parto_options)
//        configurarSpinner(spinnerHoraParto, R.array.momento_dia_parto_options)
//
//        // T E R N E R O  1
//        etRpTernero1 = findViewById(R.id.et_rp_ternero_1)
//        rgTernero1 = findViewById(R.id.rg_ternero_1)
//        rbTernero1MachoVivo = findViewById(R.id.rb_ternero_1_macho_vivo)
//        rbTernero1HembraViva = findViewById(R.id.rb_ternero_1_hembra_viva)
//        rbTernero1MachoMuerto = findViewById(R.id.rb_ternero_1_macho_muerto)
//        rbTernero1HembraMuerta = findViewById(R.id.rb_ternero_1_hembra_muerta)
//        spinnerVitalidadTernero1 = findViewById(R.id.spinner_vitalidad_ternero_1)
//        etCantidadCalostroTernero1 = findViewById(R.id.et_cantidad_calostro_ternero_1)
//        spinnerCalidadCalostroTernero1 = findViewById(R.id.spinner_calidad_calostro_ternero_1)
//        etObservacionesTernero1 = findViewById(R.id.et_observaciones_ternero_1)
//
//        // Configuración de inputType para campos específicos
//        etRpTernero1.inputType = InputType.TYPE_CLASS_TEXT
//        etCantidadCalostroTernero1.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
//
//        // Configurar Spinners
//        configurarSpinner(spinnerVitalidadTernero1, R.array.vitalidad_options)
//        configurarSpinner(spinnerCalidadCalostroTernero1, R.array.calidad_calostro_options)
//
//        // T E R N E R O  2
//        etRpTernero2 = findViewById(R.id.et_rp_ternero_2)
//        rgTernero2 = findViewById(R.id.rg_ternero_2)
//        rbTernero2MachoVivo = findViewById(R.id.rb_ternero_2_macho_vivo)
//        rbTernero2HembraViva = findViewById(R.id.rb_ternero_2_hembra_viva)
//        rbTernero2MachoMuerto = findViewById(R.id.rb_ternero_2_macho_muerto)
//        rbTernero2HembraMuerta = findViewById(R.id.rb_ternero_2_hembra_muerta)
//        spinnerVitalidadTernero2 = findViewById(R.id.spinner_vitalidad_ternero_2)
//        etCantidadCalostroTernero2 = findViewById(R.id.et_cantidad_calostro_ternero_2)
//        spinnerCalidadCalostroTernero2 = findViewById(R.id.spinner_calidad_calostro_ternero_2)
//        etObservacionesTernero2 = findViewById(R.id.et_observaciones_ternero_2)
//
//        // Configuración de inputType para campos específicos
//        etRpTernero2.inputType = InputType.TYPE_CLASS_TEXT
//        etCantidadCalostroTernero2.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
//
//        // Configurar Spinners
//        configurarSpinner(spinnerVitalidadTernero2, R.array.vitalidad_options)
//        configurarSpinner(spinnerCalidadCalostroTernero2, R.array.calidad_calostro_options)
//
//        // T E R N E R O  3
//        etRpTernero3 = findViewById(R.id.et_rp_ternero_3)
//        rgTernero3 = findViewById(R.id.rg_ternero_3)
//        rbTernero3MachoVivo = findViewById(R.id.rb_ternero_3_macho_vivo)
//        rbTernero3HembraViva = findViewById(R.id.rb_ternero_3_hembra_viva)
//        rbTernero3MachoMuerto = findViewById(R.id.rb_ternero_3_macho_muerto)
//        rbTernero3HembraMuerta = findViewById(R.id.rb_ternero_3_hembra_muerta)
//        spinnerVitalidadTernero3 = findViewById(R.id.spinner_vitalidad_ternero_3)
//        etCantidadCalostroTernero3 = findViewById(R.id.et_cantidad_calostro_ternero_3)
//        spinnerCalidadCalostroTernero3 = findViewById(R.id.spinner_calidad_calostro_ternero_3)
//        etObservacionesTernero3 = findViewById(R.id.et_observaciones_ternero_3)
//
//        // Configuración de inputType para campos específicos
//        etRpTernero3.inputType = InputType.TYPE_CLASS_TEXT
//        etCantidadCalostroTernero3.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
//
//        // Configurar Spinners
//        configurarSpinner(spinnerVitalidadTernero3, R.array.vitalidad_options)
//        configurarSpinner(spinnerCalidadCalostroTernero3, R.array.calidad_calostro_options)
//
//        // B O T O N   G U A R D A R
//        btnGuardar = findViewById(R.id.btn_guardar)
//    }
//
//    private fun configurarSpinner(spinner: Spinner, opcionesArrayResId: Int) {
//        ArrayAdapter.createFromResource(
//            this,
//            opcionesArrayResId,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = adapter
//        }
//    }
//}
