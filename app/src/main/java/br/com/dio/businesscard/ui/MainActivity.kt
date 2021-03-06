package br.com.dio.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.dio.businesscard.App
import br.com.dio.businesscard.databinding.ActivityMainBinding
import br.com.dio.businesscard.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // injeção do Repository dentro do ViewModel
    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinessCardAdaptar() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListener()
    }

    private fun insertListener(){
        binding.fabAdd.setOnClickListener{
            // Devemos criar uma intenção para acessar a outra página, passando o this -> contexto atual e falar para onde queremos ir
            val intent = Intent(this@MainActivity, AddBusinessCardActivity::class.java)
            // Iniciar a activity passando a intent criada
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }

    // Função que irá notificar as alterações para recuperarmos as informações dos cartões
    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this,{ businessCards ->
            adapter.submitList(businessCards)
        })
    }
}