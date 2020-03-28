import java.lang.StringBuilder

fun incrementString(str: String): String {
    if (str.isBlank())
        return str + "1"

    val lastChar = str[str.length - 1]

    if (lastChar.toLowerCase() in 'a'..'z') {
        return str + "1"
    } else {
        // Grab the digits
        val regex = Regex("^([a-zA-Z]+)")
        val matchResult = regex.find(str)
        val strPart = matchResult?.value ?: ""

        val digitBuilder = StringBuilder()

        for (chr in str.reversed()) {
            if (chr.isDigit()) {
                digitBuilder.append(chr)
            } else {
                break
            }
        }

        val digitsLength = digitBuilder.length
        var digits = (digitBuilder.reverse().toString().toInt() + 1).toString()

        while (digits.length < digitsLength)
            digits = "0$digits"

        return "$strPart$digits"
    }
}

fun main() {
    println(incrementString("foobar000"))
    println(incrementString("foobar999"))
    println(incrementString("foobar00999"))
    println(incrementString("foo"))
    println(incrementString("foobar001"))
    println(incrementString("foobar1"))
    println(incrementString("1"))
    println(incrementString(""))
    println(incrementString("009"))
}