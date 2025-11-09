package lotto.domain

import lotto.constant.LottoMessages
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    @DisplayName("정상 생성 테스트")
    fun create() {
        val money = Money(1_000)
        assertThat(money).isEqualTo(Money(1_000))
    }


    @Test
    @DisplayName("0 미만 예외 발생")
    fun failNegative() {
        assertMoneyException(-1000)
    }

    @Test
    @DisplayName("금액 단위(1000) 예외 발생")
    fun failNotMultipleOf1000() {
        assertMoneyException(7777)
    }

    @Test
    @DisplayName("금액으로 구매 가능한 로또 개수 계산 기능")
    fun countOfBuyLotto() {
        val money = Money(10_000)
        val count = money.countOfBuyLotto()
        assertThat(count).isEqualTo(10)
    }

    private fun assertMoneyException(amount: Int) {
        assertThatThrownBy { Money(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith(LottoMessages.ERROR_TAG)
    }
}
