package com.example.madlevel5task2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.madlevel5task2.model.Game
import com.example.madlevel5task2.repository.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = GameRepository(application.applicationContext)

    private val mainScope = CoroutineScope(Dispatchers.Main)

    val gamesList: LiveData<List<Game>> = repository.getGameList()

    fun insertGame(name: String, platform: String, releaseDate: String) {
        mainScope.launch {
            val game = Game(
                name = name,
                platform = platform,
                releaseDate = releaseDate
            )
            withContext(Dispatchers.IO) {
                repository.insertGame(game)
            }
        }
    }

    fun deleteAllGames() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                repository.deleteAllGames()
            }
        }
    }

    fun deleteGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                repository.deleteGame(game)
            }
        }
    }

}