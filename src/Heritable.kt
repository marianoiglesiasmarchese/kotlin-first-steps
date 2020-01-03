open class Heritable(attribute: Boolean = true) {

    open fun doSomething(attribute: Boolean?): Boolean{
        return attribute ?: false;
    }
}