package lotto.domain

import lotto.constant.LottoMessages.invalidValueError
import lotto.constant.LottoRules

enum class Rank(
    private val matchCount: Int,
    private val isRequiresBonus: Boolean,
    private val prizeMoney: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    fun calculatePrize(matchCount: Int): Money {
        return Money(prizeMoney * matchCount)
    }

    private fun isMatchingCount(count: Int): Boolean = this.matchCount == count

    private fun isBonusSatisfied(hasBonus: Boolean): Boolean = !isRequiresBonus || hasBonus

    companion object {
        private const val WINNING_MIN_COUNT = 3
        private const val IndexStartNumber = 0

        fun of(matchCount: Int, hasBonus: Boolean): Rank {
            require(matchCount in IndexStartNumber..LottoRules.LOTTO_NUMBER_SIZE) {
                invalidValueError(matchCount)
            }
            if (matchCount < WINNING_MIN_COUNT) return MISS
            return entries.first { it.isMatchingCount(matchCount) && it.isBonusSatisfied(hasBonus) }
        }
    }
}