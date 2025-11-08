package lotto.domin

import lotto.constant.LottoMessages
import lotto.constant.LottoRules

data class Money (private val money: Int) {
    init {
        validate(money)
    }

    private fun validate(money: Int) {
        if (isInvalidAmount(money)) {
            throw IllegalArgumentException(LottoMessages.moneyError(LottoRules.MONEY_PER_LOTTO))
        }
    }

    private fun isInvalidAmount(money: Int): Boolean {
        return money < 0 || money % 1000 != 0
    }

    fun countOfBuyLotto(): Int {
        return money / 1000;
    }

}
