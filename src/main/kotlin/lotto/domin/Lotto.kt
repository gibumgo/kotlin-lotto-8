package lotto.domin

import lotto.constant.LottoMessages
import lotto.constant.LottoRules
import lotto.domain.LottoNumber

class Lotto(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LottoRules.LOTTO_NUMBER_SIZE) {
            LottoMessages.lottoNumberCountError(LottoRules.LOTTO_NUMBER_SIZE)
        }
    }
    constructor(numbers: List<Int>) : this(
        numbers.map(::LottoNumber).toSet()
    )

    constructor(vararg numbers: Int) : this(numbers.map(::LottoNumber).toSet())
}