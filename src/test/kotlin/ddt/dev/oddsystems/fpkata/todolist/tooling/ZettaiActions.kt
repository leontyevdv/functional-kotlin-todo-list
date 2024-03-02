package ddt.dev.oddsystems.fpkata.todolist.tooling

import com.ubertob.pesticide.core.DdtActions
import com.ubertob.pesticide.core.DdtProtocol
import com.ubertob.pesticide.core.DomainDrivenTest
import dev.oddsystems.fpkata.todolist.domain.ListName
import dev.oddsystems.fpkata.todolist.domain.ToDoItem
import dev.oddsystems.fpkata.todolist.domain.ToDoList
import dev.oddsystems.fpkata.todolist.domain.User

interface ZettaiActions : DdtActions<DdtProtocol> {
    fun ToDoListOwner.`starts with a list`(listName: String, items: List<String>)

    fun getToDoList(user: User, listName: ListName): ToDoList?
    fun addListItem(user: User, listName: ListName, item: ToDoItem)
}

typealias ZettaiDDT = DomainDrivenTest<ZettaiActions>

fun allActions() = setOf(
    DomainOnlyActions(),
    HttpActions()
)