package lotto.domain

class LottoResult {
    private val lottoResult: MutableMap<Rank, Int> = Rank.entries.associateWith { INITIAL_COUNT }.toMutableMap()

    fun incrementRankCount(rank: Rank) {
        val currentCount = lottoResult.getValue(rank)
        lottoResult[rank] = currentCount + COUNT_INCREMENT
    }

    fun getCount(rank: Rank?): Int {
        return lottoResult.getOrDefault(rank, INITIAL_COUNT)
    }

    companion object {
        const val INITIAL_COUNT: Int = 0
        const val COUNT_INCREMENT: Int = 1
    }
}
