package lotto.domain

import lotto.constant.LottoMessages

class WinningLotto private constructor(val winningLotto: Lotto, val bonusNumber: LottoNumber) {
    companion object {
        fun of(lotto: Lotto, bonusNumber: Int): WinningLotto {
            return WinningLotto(lotto, LottoNumber(bonusNumber))
        }

        fun of(numbers: List<Int>, bonusNumber: Int): WinningLotto {
            return WinningLotto(Lotto(numbers), LottoNumber(bonusNumber))
        }
    }
}
