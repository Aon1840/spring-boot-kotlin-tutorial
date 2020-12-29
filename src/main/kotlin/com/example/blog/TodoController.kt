package com.example.blog

import Todo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController {

    private var todoList: List<Todo>? = null

    init {
        todoList = listOf(
                Todo(1, "attapon"),
                Todo(2, "attaporn"),
                Todo(3, "natnicha"))
    }

    @GetMapping("/todos")
    fun getTodo(): String {
        return "todos"
    }

    @GetMapping("/todo")
    fun getTodos(): List<Todo>? {
        return todoList
    }

    // path
    @GetMapping("/todo/{id}")
    fun getTodoById(@PathVariable id: Long): Todo? {
        return todoList?.find { it.id == id }
    }

    // query string
    @GetMapping("/todo/search")
    fun getTodoByName(@RequestParam(defaultValue = "natnicha") name: String): Todo? {
        return todoList?.find { it.name == name }
    }
}