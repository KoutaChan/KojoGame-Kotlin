package kojogame.koutachan.util

class IronSponges(Boolean: Boolean) {

    init {
        IronSponges = Boolean
    }

    companion object {
        var IronSponges: Boolean = false
        //false = 壊されてない
        //true = 壊されている
    }
}

class GoldSponges(Boolean: Boolean) {

    init {
        GoldSponges = Boolean
    }

    companion object {
        var GoldSponges: Boolean = false
        //false = 壊されてない
        //true = 壊されている
    }
}

class DiamondSponges(Boolean: Boolean) {

    init {
        DiamondSponges = Boolean
    }

    companion object {
        var DiamondSponges: Boolean = false
        //false = 壊されてない
        //true = 壊されている
    }
}
