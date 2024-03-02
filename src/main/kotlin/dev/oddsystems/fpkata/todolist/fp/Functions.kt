package dev.oddsystems.fpkata.todolist.fp

fun <U : Any> CharSequence?.unlessNullOrEmpty(f: (CharSequence) -> U): U? =
    if (isNullOrEmpty()) null else f(this)

fun <T> T.printIt(prefix: String = ">"): T = also { println("$prefix $this") }