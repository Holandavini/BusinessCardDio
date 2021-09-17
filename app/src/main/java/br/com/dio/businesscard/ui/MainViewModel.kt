package br.com.dio.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.dio.businesscard.data.BusinessCard
import br.com.dio.businesscard.data.BusinessCardRepository

// Classe que irá trafegar os dados entre o Repository e a tela
class MainViewModel(private val businessCardRepository: BusinessCardRepository) : ViewModel() {
    // Fuções para notificar a view
    fun insert(businessCard: BusinessCard){
        businessCardRepository.insert(businessCard)
    }

    fun getAll() : LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }

}

class MainViewModelFactory(private val repository: BusinessCardRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        } else {
            throw IllegalArgumentException("unknown ViewModel class")
        }

    }


}