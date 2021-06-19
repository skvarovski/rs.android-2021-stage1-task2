package subtask1

import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.util.*


class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        return try {
            // создаём переменную на основе обьекта даты (без времени)
            // в случае некоректных данных, оно из под капота кидает DateException
            val locDate = LocalDate.of(year.toInt(), month.toInt(), day.toInt())

            // создаём паттерн-формат строки вывода согласно Т3 учитывая локаль.
            // необходимо: день имя_месяца [запятая] имя_дня_недели
            // dd - день,   ММММ  - имя месяца,  EEEE - имя дня недели
            // https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
            val formatDate = DateTimeFormatter.ofPattern("dd MMMM, EEEE", Locale("ru"))

            // преобразование даты по нужному паттерну
            locDate.format(formatDate)

        } catch (ex: DateTimeException) {
            // в случае ошибки с датамы выкидываем строку
            "Такого дня не существует"
        }
    }
}