package lotto.domin

import lotto.constant.LottoMessages.lottoNumberRangeError
import lotto.constant.LottoRules
import lotto.domain.LottoNumber
import org.assertj.core.api.AssertionsForClassTypes
import org.assertj.core.api.ThrowableAssert
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    @DisplayName("유효한 숫자를 입력하면 정상 생성")
    fun createLottoNumber() {
        val lottoNumber: LottoNumber? = LottoNumber(1)
        AssertionsForClassTypes.assertThat<LottoNumber?>(lottoNumber).isEqualTo(LottoNumber(1))
    }

    @Test
    @DisplayName("범위 밖 숫자(0,46) 입력하면 예외 발생")
    fun validNumber() {
        AssertionsForClassTypes.assertThatThrownBy(ThrowableAssert.ThrowingCallable { LottoNumber(0) })
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(
                lottoNumberRangeError(
                    LottoRules.MIN_NUMBER,
                    LottoRules.MAX_NUMBER
                )
            )

        AssertionsForClassTypes.assertThatThrownBy(ThrowableAssert.ThrowingCallable { LottoNumber(46) })
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(
                lottoNumberRangeError(
                    LottoRules.MIN_NUMBER,
                    LottoRules.MAX_NUMBER
                )
            )
    }
}