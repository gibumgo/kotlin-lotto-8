package lotto.domain

data class Lottos private constructor (private val lottos: List<Lotto>) {
    fun add(lotto: Lotto): Lottos = Lottos(lottos + lotto)

    companion object {
        fun of(lottos: List<Lotto>): Lottos = Lottos(lottos)
    }
}
