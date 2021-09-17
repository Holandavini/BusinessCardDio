package br.com.dio.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Classe que irá fazer a chamada do DAO
class BusinessCardRepository(private val dao: BusinessCardDAO){

    fun insert(businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO){
            dao.insert(businessCard)
        }
    }

    fun getAll() = dao.getAll()

}