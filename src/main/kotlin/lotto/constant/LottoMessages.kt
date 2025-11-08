package lotto.constant

object LottoMessages {
    private const val ERROR_TAG = "[ERROR]"
    private const val SPACE = " "

    private const val MONEY_ERROR = "구입 금액은 %d원 단위로 입력해야 합니다."
    private const val LOTTO_NUMBER_RANGE_ERROR = "로또 번호는 %d부터 %d 사이의 숫자여야 합니다."
    private const val LOTTO_NUMBER_COUNT_ERROR = "로또 번호는 중복이 되지 않는 %d개 숫자여야 합니다."
    private const val BONUS_NUMBER_DUPLICATE_ERROR = "보너스 번호는 당첨 번호와 중복될 수 없습니다."
    private const val INVALID_VALUE_ERROR = "%d는 유효하지 않은 값입니다."

    const val INPUT_MONEY_MESSAGE: String = "구입금액을 입력해 주세요."
    const val INPUT_WINNING_NUMBER_MESSAGE: String = "당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER_MESSAGE: String = "보너스 번호를 입력해 주세요."

    const val BUY_LOTTO_MESSAGE: String = "%d개를 구매했습니다.\n"
    const val WINNING_RESULT_MESSAGE: String = "당첨 통계"
    const val SEPARATE_BAR: String = "---"
    const val RESULT_MESSAGE: String = "%d개 일치%s(%,d원) - %d개\n"
    const val TOTAL_PROFIT_MESSAGE: String = "총 수익률은 %.1f%%입니다."
    const val BONUS_MESSAGE: String = ", 보너스 볼 일치 "
    const val BLANK: String = " "

    fun moneyError(money: Int): String {
        return "$ERROR_TAG $MONEY_ERROR".format(money)
    }

    fun lottoNumberRangeError(min: Int, max: Int): String {
        return "$ERROR_TAG $LOTTO_NUMBER_RANGE_ERROR".format(min, max)
    }

    fun lottoNumberCountError(size: Int): String {
        return "$ERROR_TAG $LOTTO_NUMBER_COUNT_ERROR".format(size)
    }

    fun duplicateBonusNumberError(): String {
        return "$ERROR_TAG $BONUS_NUMBER_DUPLICATE_ERROR"
    }

    fun invalidValueError(rankCount: Int): String {
        return "$ERROR_TAG $INVALID_VALUE_ERROR".format(rankCount)
    }
}
