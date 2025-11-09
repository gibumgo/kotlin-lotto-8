package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    @DisplayName("Lottos 생성 및 추가 테스트")
    fun createLottos() {
        val lottos = Lottos.of(emptyList())
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val updated = lottos.add(lotto)

        assertThat(updated).isEqualTo(Lottos.of(listOf(lotto)))
    }
}
