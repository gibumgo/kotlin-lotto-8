package lotto.domain

import lotto.constant.LottoMessages
import lotto.constant.LottoRules

data class LottoNumber(val value: Int) {
    init {
        require(value in LottoRules.MIN_NUMBER..LottoRules.MAX_NUMBER) {
            LottoMessages.lottoNumberRangeError(
                LottoRules.MIN_NUMBER, LottoRules.MAX_NUMBER
            )
        }
    }
}
