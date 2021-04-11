package kojogame.koutachan.util

enum class GameState {
    LOBBY, STARTING, PLAYING, ENDING;
}

class Timer(timer: Int) {

    init {
        Timer = timer
    }

    companion object {
        var Timer: Int = 0
    }
}