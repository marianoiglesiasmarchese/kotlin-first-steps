
fun callMe(greeting: () -> Unit) {
    greeting()
}

fun callMeWithArgument(function: (String) -> Unit) {
    function("high order with argument")
}

fun highOrderFunctionFunctionalProgramming() {
    callMe { println("Hello!") }
    callMeWithArgument { print: String -> println(print) }
    callMeWithArgument { println(it) }
}
