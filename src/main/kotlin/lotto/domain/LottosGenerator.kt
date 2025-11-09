package lotto.domain

interface LottosGenerator {
    fun generate(money: Money): Lottos
}
