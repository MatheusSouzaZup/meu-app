package br.com.meuape.room.example

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Example(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var exampleTitle: String
)

