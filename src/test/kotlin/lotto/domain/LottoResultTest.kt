package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultTest {
    private var lottoResult: LottoResult = LottoResult()

    @Test
    @DisplayName("초기 등수 개수 생성")
    fun countIsZero() {
        for (rank in Rank.values()) {
            assertThat(lottoResult.getCount(rank)).isZero()
        }
    }

    @Test
    @DisplayName("등수 개수 증가")
    fun incrementRankCount() {
        lottoResult.incrementRankCount(Rank.FIRST)
        lottoResult.incrementRankCount(Rank.FIRST)

        assertThat(lottoResult.getCount(Rank.FIRST)).isEqualTo(2)
    }
}
