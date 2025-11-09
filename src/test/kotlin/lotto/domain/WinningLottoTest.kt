package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.stream.IntStream

internal class WinningLottoTest {
    @Test
    @DisplayName("정상 Lotto와 보너스 번호로 WinningLotto 생성")
    fun create() {
        val lotto = Lotto(VALID_NUMBERS)
        val winningLotto = WinningLotto.of(lotto, 7)

        assertThat(winningLotto).isNotNull
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val START_NUMBER = 1
        private val VALID_NUMBERS = (START_NUMBER..LOTTO_SIZE).toList()
    }
}