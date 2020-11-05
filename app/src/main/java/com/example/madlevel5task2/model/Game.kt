package com.example.madlevel5task2.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "game_table")
data class Game (

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    val name: String,

    val platform: String,

    var releaseDate: Date,
)