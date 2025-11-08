package lotto.domin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    @DisplayName("정상 생성 테스트")
    fun create() {
        val money = Money(1_000)
        assertThat(money).isEqualTo(Money(1_000))
    }
}
