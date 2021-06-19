package subtask3

import subtask1.DateFormatter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {

        // определяем тип класса
        return when (blockB) {

            String::class -> doMakeString(blockA)
            Int::class -> doMakeInt(blockA)
            LocalDate::class -> doMakeDate(blockA)
            else -> throw Exception("Wrong blockB")
        }
    }

    private fun doMakeString(blockA: Array<*>): String {
        return blockA.filterIsInstance<String>().joinToString(separator = "")
    }
    private fun doMakeInt(blockA: Array<*>): Int {
        return blockA.filterIsInstance<Int>().sum()
    }
    private fun doMakeDate(blockA: Array<*>): String {
          return (blockA.filterIsInstance<LocalDate>().max() as LocalDate)
              .format(DateTimeFormatter.ofPattern("dd.MM.yyyy",Locale("ru")))
    }
 }
