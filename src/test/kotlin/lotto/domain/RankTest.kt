package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("Rank 테스트")
class RankTest {

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = ["6:false"], delimiter = ':')
    @DisplayName("1등 확인 (6개 일치)")
    fun firstRankTest(matchCount: Int, isBonus: Boolean) {
        val rank = Rank.of(matchCount, isBonus)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = ["5:true"], delimiter = ':')
    @DisplayName("2등 확인 (5개 + 보너스 일치)")
    fun secondRankTest(matchCount: Int, isBonus: Boolean) {
        val rank = Rank.of(matchCount, isBonus)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = ["5:false"], delimiter = ':')
    @DisplayName("3등 확인 (5개 일치)")
    fun thirdRankTest(matchCount: Int, isBonus: Boolean) {
        val rank = Rank.of(matchCount, isBonus)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = ["4:false"], delimiter = ':')
    @DisplayName("4등 확인 (4개 일치)")
    fun fourthRankTest(matchCount: Int, isBonus: Boolean) {
        val rank = Rank.of(matchCount, isBonus)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = ["3:false"], delimiter = ':')
    @DisplayName("5등 확인 (3개 일치)")
    fun fifthRankTest(matchCount: Int, isBonus: Boolean) {
        val rank = Rank.of(matchCount, isBonus)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @ParameterizedTest(name = "matchCount = {0}, bonus = {1}")
    @CsvSource(value = ["0:false"], delimiter = ':')
    @DisplayName("3개 미만 확인 → MISS")
    fun missRankTest(matchCount: Int, isBonus: Boolean) {
        val rank = Rank.of(matchCount, isBonus)
        assertThat(rank).isEqualTo(Rank.MISS)
    }

    @Test
    @DisplayName("1등 상금 계산 테스트")
    fun calculatePrizeFirst() {
        val first = Rank.FIRST
        val prize = first.calculatePrize(1)
        assertThat(prize).isEqualTo(Money(2_000_000_000))
    }

    @ParameterizedTest(name = "matchCount = {0}")
    @CsvSource(value = ["-1", "7", "100"])
    @DisplayName("유효하지 않은 matchCount는 예외 발생")
    fun invalidMatchCountTest(matchCount: Int) {
        val exception = assertThrows<IllegalArgumentException> {
            Rank.of(matchCount, false)
        }
        assertThat(exception.message).contains(matchCount.toString())
    }
}
