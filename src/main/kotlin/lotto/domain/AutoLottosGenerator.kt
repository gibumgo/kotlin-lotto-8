package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.LottoRules

class AutoLottosGenerator : LottosGenerator {
    private val START_INCLUSIVE = 0

    override fun generate(money: Money): Lottos {
        return (START_INCLUSIVE until money.countOfBuyLotto())
            .map { Lotto(generateAutoNumbers()) }
            .let { Lottos.of(it) }
    }

    private fun generateAutoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            LottoRules.MIN_NUMBER,
            LottoRules.MAX_NUMBER,
            LottoRules.LOTTO_NUMBER_SIZE
        )
    }
}