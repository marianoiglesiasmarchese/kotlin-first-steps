fun lambdasFunctionalProgramming() {
    val mixList = arrayListOf(-42, "17", 13.5, -9, 12)
    println(mixList)

    val numbers = arrayListOf(-42, 17, 13, -9, 12)
    // lambda implicit single input
    val nonNegative = numbers.filter { it >= 0 }
    println(nonNegative)

    val function = { num: Int -> num + 1 }
    println(function(1))

    val function2 = { a: Int, b: Int -> a + b }
    println(function2(5, 5))
    println(numbers.take(2))  // First two elements: [-42, 17]
    println(numbers.drop(2))  // List without first two elements: [13, -9, 12]
    println(numbers.foldRight(0, { a, b -> a + b }))  // Sum of all elements: -9

    numbers.forEach { print("${it * 2} ") }  // -84 34 26 -18 24

    val genres = listOf("Action", "Comedy", "Thriller")
    val myKindOfMovies: Iterable<String> = genres.filter { it.length <= 6 }.map { "$it Movie" }
    println(myKindOfMovies)  // [Action Movie, Comedy Movie]
    println(numbers.map { it * 2 })
    println(numbers)

    val calculus = { it: Int -> println(it * 2) }
    numbers.forEach(calculus)
    println(numbers) // produce no alteration on numbers collection

    // functions that return a Boolean are often called predicate functions.
    val predicate = { it: Int -> it > 0 }
    println("use of predicate:")
    println(numbers.filter(predicate)) // return a new list with the subgroup of elements major than 0
    println(mixList.zip(numbers)) // aggregates the contents of two lists into a single list of pairs.
    println(numbers.partition { it > 0 }) // splits a list based on where it falls with respect to a predicate function.
    println(numbers.find { it < 13 }) //  returns the first element of a collection that matches a predicate function.

    val tenNumbers = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(tenNumbers.drop(5)) // drops the first i elements
    println("drop while: " + tenNumbers.dropWhile { it / 3 == 0 })  // removes up to the first element that match a predicate function.
    println(tenNumbers.fold(0) { acc, element -> println("accumulator: $acc - element: $element"); element + acc }) // 0 is the starting value, and m acts as an accumulator.
    println(tenNumbers.foldRight(0) { element, acc -> println("accumulator: $acc - element: $element"); element + acc }) // the same than fold but the arguments means the inverse

    val listOfLists = listOf(listOf(1, 2), listOf(3, 4))
    println(listOfLists)
    println(listOfLists.flatten()) //  collapses one level of nested structure.
    // that example calling map and then flatten is an example of the “combinator”-like nature of these functions.
    println(listOfLists.flatMap { list: List<Int> -> list.map { it * 2 } }) // takes a function that works on the nested lists and then concatenates the results back together. think on it as a shortcut to make something and then flatt it !

    // same apply for maps
    val map = mapOf(Pair("something", 100), Pair("something else", 200))
    println(map.filter { it.value < 150 })

    // What we’d like is to be able to write our own functional combinations.
    // every functional combinator shown above can be written on top of fold:
    val function3 = { element: Int -> element * 2 }
    val myMapResult = myMap(tenNumbers, function3)
    println("myMapResult: $myMapResult")

    // is something isn't null do something else do something else
    val id : String? = null
    id?.also { it } ?: "something"

}

fun myMap(numbers: ArrayList<Int>, fn: (Int) -> Int): ArrayList<Int> {
    return numbers.fold(arrayListOf(), { list, element -> list.add(fn(element)); list })
}
