package com.example.madlevel5task2.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "game_table")
class Game(
    val name: String,
    val platform: String,
    val releaseDate: String,

    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
)