package ddt.dev.oddsystems.fpkata.todolist.tooling

import com.ubertob.pesticide.core.DdtActor
import dev.oddsystems.fpkata.todolist.domain.ListName
import dev.oddsystems.fpkata.todolist.domain.ToDoItem
import dev.oddsystems.fpkata.todolist.domain.User
import strikt.api.expectThat
import strikt.assertions.containsExactlyInAnyOrder
import strikt.assertions.isNotNull
import strikt.assertions.isNull

data class ToDoListOwner(override val name: String) : DdtActor<ZettaiActions>() {

    val user = User(name)

    fun `can add #item to #listname`(itemName: String, listName: String) =
        step(itemName, listName) {
            val item = ToDoItem(itemName)
            addListItem(user, ListName.fromUntrustedOrThrow(listName), item)
        }

    fun `can see #listname with #itemnames`(listName: String, expectedItems: List<String>) =
        step(listName, expectedItems) {
            val list = getToDoList(user, ListName.fromUntrustedOrThrow(listName))
            expectThat(list)
                .isNotNull()
                .get { items.map { it.description } }
                .containsExactlyInAnyOrder(expectedItems)
        }

    fun `cannot see #listname`(listName: String) = step(listName) {
        val list = getToDoList(user, ListName.fromUntrustedOrThrow(listName))
        expectThat(list).isNull()
    }

}