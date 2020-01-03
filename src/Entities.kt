/**
 * with a data class, Kotlin will generate getters(), setters() and useful hashCode(), equals(), and toString()
 */
data class Book(var title: String = "default value", var author: Author) {

}

data class Author(var name: String)