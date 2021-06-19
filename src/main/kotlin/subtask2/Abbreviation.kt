package subtask2

import java.util.*

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        //переводив в прописные
        val strA = a.toUpperCase(Locale("en"))
        var strConcat = ""

        // пробегаем и совпадающие откладываем во временную переменную
        strA.forEach {
            if (it in b) {
                strConcat += it
            }
        }

        // проверяем строки и длину
        if (strConcat == b && strConcat.length == b.length) {
            return "YES"
        }

        // ответ по-умолчанию
        return "NO"
    }
}
