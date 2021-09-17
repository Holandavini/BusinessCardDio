package br.com.dio.businesscard

import android.app.Application
import br.com.dio.businesscard.data.AppDatabase
import br.com.dio.businesscard.data.BusinessCardRepository

// Classe para carregar antes da tela inicial. Deve ser informado no manifest
class App: Application() {
    // Ao iniciar o app deve instanciar o necessário
    val database by lazy { AppDatabase.getDatabase(this) } // Instanciar o Room
    val repository by lazy {BusinessCardRepository(database.businessDao())} // Instanciar o Repository


}