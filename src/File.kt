fun variableDeclaration() {
    val staticName: String? = ""
    val len = staticName?.length
    println(len)
    var dynamicNumber: String? = null
    val numberLen = dynamicNumber?.length
    println(numberLen)
    var dynamicName = "pepe"
    println(dynamicName)
}

fun dataClasses() {
    /**
     *  {@link Book#Book()} // TODO not recognized
     *  @link Book#Book(String, Author) // TODO not recognized
     *  @see Book#Book(String, Author) // TODO partially recognized
     *  @see #main() // TODO not recognized
     */
    val book = Book("pepe", Author("pepe"))
    var pepe: Book
    println(book)
    println(book.toString())
    val namedArgumentBook = Book(author = Author("pepe"), title = "named arguments")
    println(namedArgumentBook)
    pepe = book
    val copy = book.copy()
    val puzzlers = book.copy(title = "Java Puzzlers")
    pepe = puzzlers
    println(pepe)
    val gof = book.copy(title = "Design Patterns", author = Author("Gang of Four"))
    val (title) = book
    println(title)
    var (firs, second) = book
    second = Author("otro")
    println(book)
    println(second)
}

fun collectionsAndArrays() {
    var list: Iterable<Double> = arrayListOf(1.0, 0.0, 3.1415, 2.718)  // Only need Iterable interface
    println(list)
    val arrayList = arrayListOf("Kotlin", "Scala", "Groovy")  // Type is ArrayList
    println(arrayList)
    arrayList.add("something else")
    println(arrayList)
}

fun lambdasFunctionalProgramming(){
    val mixList = arrayListOf(-42, "17", 13.5, -9, 12)
    println(mixList)
    val numbers = arrayListOf(-42, 17, 13, -9, 12)
    // lambda implicit single input
    val nonNegative = numbers.filter { it >= 0 }
    println(nonNegative)
    val function = { num: Int -> num + 1}
    println(function(1))
    val function2 = { a: Int, b: Int  -> a + b}
    println(function2(5,5))
    println(numbers.take(2))  // First two elements: [-42, 17]
    println(numbers.drop(2))  // List without first two elements: [13, -9, 12]
    println(numbers.foldRight(0, { a, b -> a + b }))  // Sum of all elements: -9
    numbers.forEach { print("${it * 2} ") }  // -84 34 26 -18 24
    val genres = listOf("Action", "Comedy", "Thriller")
    val myKindOfMovies: Iterable<String> = genres.filter { it.length <= 6 }.map { it + " Movie" }
    println(myKindOfMovies)  // [Action Movie, Comedy Movie]
}

fun callMe(greeting: () -> Unit) {
    greeting()
}

fun highOrderFunctionFunctionalProgramming() {
    callMe {println("Hello!")}
}

object BookFactory {
    // objects always exists as a single instance, so can be used as singletons
    fun getBook(): Book {
        return Book("pepe", Author("pepe"));
    }
}

fun objects() {
    val book = BookFactory.getBook()
    println(book)
}

object SubHeritable : Heritable() {

    override fun doSomething(attribute: Boolean?): Boolean{
        return attribute ?: true;
    }
}

fun objectsInheritance() {
    val heritable = Heritable()
    println(heritable.doSomething(null))
    val subHeritable = SubHeritable.doSomething(null)
    println(subHeritable)
}


fun main(args: Array<String>){
    variableDeclaration()
    dataClasses()
    collectionsAndArrays()
    lambdasFunctionalProgramming()
    highOrderFunctionFunctionalProgramming()
    objects()
    objectsInheritance()
}
