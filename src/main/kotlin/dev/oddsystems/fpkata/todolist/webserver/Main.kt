package dev.oddsystems.fpkata.todolist.webserver

import dev.oddsystems.fpkata.todolist.domain.ListName
import dev.oddsystems.fpkata.todolist.domain.ToDoItem
import dev.oddsystems.fpkata.todolist.domain.ToDoList
import dev.oddsystems.fpkata.todolist.domain.ToDoListFetcherFromMap
import dev.oddsystems.fpkata.todolist.domain.ToDoListHub
import dev.oddsystems.fpkata.todolist.domain.ToDoListStore
import dev.oddsystems.fpkata.todolist.domain.ToDoStatus
import dev.oddsystems.fpkata.todolist.domain.User
import java.time.LocalDate
import org.http4k.server.Jetty
import org.http4k.server.asServer


fun main() {
    val fetcher = ToDoListFetcherFromMap(storeWithExampleData())
    val hub = ToDoListHub(fetcher)

    Zettai(hub).asServer(Jetty(8080)).start()

    println("Server started at http://localhost:8080/todo/uberto/book")
}

fun storeWithExampleData(): ToDoListStore = mutableMapOf(
    User("uberto") to
            mutableMapOf(exampleToDoList().listName to exampleToDoList())
)

private fun exampleToDoList(): ToDoList {
    return ToDoList(
        listName = ListName.fromTrusted("book"),
        items = listOf(
            ToDoItem("prepare the diagram", LocalDate.now().plusDays(1), ToDoStatus.Done),
            ToDoItem("rewrite explanations", LocalDate.now().plusDays(2), ToDoStatus.InProgress),
            ToDoItem("finish the chapter"),
            ToDoItem("draft next chapter")
        )
    )
}