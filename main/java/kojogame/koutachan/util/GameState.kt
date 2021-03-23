package kojogame.koutachan.util

class GameState(state: Int) {

    init {
        GameState = state
    }

    companion object {
        var GameState: Int = 0
        //0 = 開始されていない
        //1 = カウントダウン中
        //2 = 開始
        //3 = ゲーム終了
    }
}