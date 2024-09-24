package br.com.mizaeldouglas.jetpack_viewbinding_componentes_interfaces

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import br.com.mizaeldouglas.jetpack_viewbinding_componentes_interfaces.databinding.ActivityLinearLayoutBinding
import br.com.mizaeldouglas.jetpack_viewbinding_componentes_interfaces.databinding.ActivityMainBinding

class LinearLayoutActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLinearLayoutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding){
            fabBtn.setOnClickListener {
                if (groupMenu.isVisible){
                    groupMenu.visibility = View.INVISIBLE
                }else{
                    groupMenu.visibility = View.VISIBLE
                }
            }
        }


    }
}