import java.util.Scanner
import kotlin.concurrent.thread

fun main(args: Array<String>){
    while (true){
        println("0 выход")
        println("1 задача приложение, которое подсчитывает количество подряд идущих одинаковых символов во введенной строке.")
        println("2 задача приложение, которое подсчитывает количество различных символов во введенной строке. Символы в ответе расположить в алфавитном порядке.")
        println("3 задача приложение, которое преобразует введенное пользователем натуральное число из 10-ичной системы в двоичную")
        println("4 задача приложение, с помощью которого пользователь, введя два числа и символ операции, узнает результат. Символами операции могут быть: / — деление, * — умножение, + — сложение, - — вычитание. Числа могут быть вещественными.")
        println("5 задача приложение, с помощью которого пользователь, введя целое число n и основание степени x узнает, существует ли целочисленный показатель степени y для которого выполняется равенство x(у) = n")
        println("6 задача приложение, в котором пользователь вводит две различных цифры. На выходе приложение выдает, если это возможно, из введенных цифр, нечетное число.")
    println("выберите пункт меню:")

    val input = readln()

    when(input)
    {
        "0" -> return
        "1" -> task1()
        "2" -> task2()
        "3" -> task3()
        "4" -> task4()
        "5" -> task5()
        "6" -> task6()
        else -> println("неверный ввод")
    }
    }
}
fun task1() {
    println("введите слово")
    val input = readln()
    println(input)
    var count = 1
    val result = StringBuilder()

    for(i in 1 until input.length){
        if(input[i] == input[i-1]) {
            count++
        } else {
            result.append(input[i-1])
            if(count > 1) {
                result.append(count)
            }
            count = 1
        }
    }


    result.append(input.last())
    if(count > 1) {
        result.append(count)
    }

    println(result.toString())
    backInMenu()
}

fun task2() {
    println("введите слово")
    val input = readln()
    println(input)
    val cleanedInput = input.uppercase().filter { it != ' ' }

    val symbolFrequency = mutableMapOf<Char, Int>()

    for (ch in cleanedInput) {
        symbolFrequency[ch] = symbolFrequency.getOrDefault(ch, 0) + 1
    }

    val sortedSymbols = symbolFrequency.keys.sorted()

    for (symbol in sortedSymbols) {
        println("${symbol} - ${symbolFrequency[symbol]}")
    }
    backInMenu()
}
fun convertToBinary(number: Int): String {
    if (number == 0) return "0"
    var num = number
    val result = StringBuilder()

    while(num > 0) {
        result.insert(0, num % 2)
        num /= 2
    }

    return result.toString()
}

fun task3() {
    print("Введите натуральное число: ")
    val numberStr = readln()

    try {
        val decimalNumber = numberStr.toInt()
        if(decimalNumber <= 0) throw IllegalArgumentException("Необходимо ввести положительное целое число!")

        val binaryRepresentation = convertToBinary(decimalNumber)

        println("Двоичное представление числа $decimalNumber: $binaryRepresentation")
    } catch(e: NumberFormatException) {
        println("Ошибка: Введено некорректное число.")
    } catch(e: Exception) {
        println("Ошибка: ${e.message}")
    }
    backInMenu()
}
fun task4() {
    val scanner = Scanner(System.`in`)

    println("Введите выражение в формате 'ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ':")
    val input = scanner.nextLine().split(' ')

    if(input.size != 3){
        println("Ошибка ввода!")
        return
    }

    try{
        val num1 = input[0].toDouble()
        val num2 = input[1].toDouble()
        val operation = input[2]

        when(operation){
            "/" -> printResult(num1 / num2)
            "*" -> printResult(num1 * num2)
            "+" -> printResult(num1 + num2)
            "-" -> printResult(num1 - num2)
            else -> println("Неверный оператор!")
        }
    } catch(e : NumberFormatException){
        println("Некорректный ввод чисел.")
    }
    backInMenu()
}

fun printResult(result: Double){
    println("Результат: $result")
}

fun task5() {
    val scanner = Scanner(System.`in`)

    println("Введите целое число n:")
    val n = scanner.nextInt()

    println("Введите основание степени x:")
    val x = scanner.nextInt()

    if(x <= 0 || n <= 0){
        println("Основание и степень должны быть положительными числами.")
        return
    }

    var result = ""
    for(y in 1..n){
        if(Math.pow(x.toDouble(), y.toDouble()) == n.toDouble()){
            result = "$y"
            break
        }
    }

    if(result.isNotEmpty())
        println("Показатель степени: $result")
    else
        println("Целочисленный показатель не существует.")
    backInMenu()
}
fun task6() {
    val scanner = Scanner(System.`in`)

    println("Введите первую цифру:")
    val digit1 = scanner.nextInt()

    println("Введите вторую цифру:")
    val digit2 = scanner.nextInt()
    val numberAB = digit1 * 10 + digit2
    val numberBA = digit2 * 10 + digit1

    if ((numberAB % 2 != 0) || (numberBA % 2 != 0)) {
        // Выбираем первое попавшееся нечетное число
        if (numberAB % 2 != 0) {
            println(numberAB)
        } else {
            println(numberBA)
        }
    } else {
        println("Создать нечетное число невозможно.")
    }
    backInMenu()
}

fun backInMenu()
{
    println("напишете что нибудь для возращения")
    val back = readln()
}