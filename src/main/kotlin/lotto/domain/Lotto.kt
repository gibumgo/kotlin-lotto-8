package lotto.domain

import lotto.constant.LottoMessages
import lotto.constant.LottoRules

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

    fun contains(number: LottoNumber): Boolean {
        return this.numbers.contains(number)
    }
}