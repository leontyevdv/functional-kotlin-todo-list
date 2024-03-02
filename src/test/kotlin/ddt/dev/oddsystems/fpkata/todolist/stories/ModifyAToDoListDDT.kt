package ddt.dev.oddsystems.fpkata.todolist.stories

import com.ubertob.pesticide.core.DDT
import ddt.dev.oddsystems.fpkata.todolist.tooling.ToDoListOwner
import ddt.dev.oddsystems.fpkata.todolist.tooling.ZettaiDDT
import ddt.dev.oddsystems.fpkata.todolist.tooling.allActions

class ModifyAToDoListDDT : ZettaiDDT(allActions()) {

    val ann by NamedActor(::ToDoListOwner)

    @DDT
    fun `the list owner can add new items`() = ddtScenario {
        setUp {
            ann.`starts with a list`("diy", emptyList())
        }.thenPlay(
            ann.`can add #item to #listname`("paint the shelf", "diy"),
            ann.`can add #item to #listname`("fix the gate", "diy"),
            ann.`can add #item to #listname`("change the lock", "diy"),
            ann.`can see #listname with #itemnames`(
                "diy", listOf(
                    "fix the gate", "paint the shelf", "change the lock"
                )
            )
        )
    }
}