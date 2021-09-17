package br.com.dio.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// @Dao -> Para indicar para o banco room que essa classe é um DAO
@Dao
interface BusinessCardDAO {
    // Função que irá retornar um LiveData contendo uma lista de entidades BusinessCard
    // @Query -> Para buscar os dados no banco de dados
    @Query("SELECT * FROM BusinessCard")
    fun getAll(): LiveData<List<BusinessCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard: BusinessCard)
}