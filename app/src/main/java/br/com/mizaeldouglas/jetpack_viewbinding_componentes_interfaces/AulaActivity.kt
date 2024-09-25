package br.com.mizaeldouglas.jetpack_viewbinding_componentes_interfaces

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.mizaeldouglas.jetpack_viewbinding_componentes_interfaces.databinding.ActivityAulaBinding
import br.com.mizaeldouglas.jetpack_viewbinding_componentes_interfaces.databinding.ActivityLinearLayoutBinding

class AulaActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityAulaBinding.inflate(layoutInflater)
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
//        supportActionBar?.hide()
        inicializarActionBar()

        with(binding) {

        }
    }

    private fun inicializarActionBar() {
        addMenuProvider(
            object : MenuProvider{
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu_principal,menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    when(menuItem.itemId){
                        R.id.itemAdd -> Toast.makeText(applicationContext, "Adicionar", Toast.LENGTH_SHORT).show()
                    }
                return true
                }
            }
        )
    }

    //Maneira antiga

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_principal, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.itemAdd -> Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show()
//        }
//
//        return true
//    }
}