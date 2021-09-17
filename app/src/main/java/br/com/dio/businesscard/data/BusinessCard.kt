package br.com.dio.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Classe responsavel por passar para o banco de dados o que iremos gravar
@Entity
// @Entity -> Irá integrar ao banco room
data class BusinessCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val phone: String,
    val email: String,
    val company: String,
    val customBackgroud: String
)