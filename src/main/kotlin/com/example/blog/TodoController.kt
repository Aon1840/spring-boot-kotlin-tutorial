package com.example.blog

import Todo
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RestController
class TodoController {

    private var todoList = ArrayList<Todo>()

    // ========== GET METHOD ==========
    @GetMapping("/test")
    fun getTest(): String {
        return "Test"
    }

    @GetMapping("/todo")
    fun getTodos(): ArrayList<Todo>? {
        return todoList
    }

    // path
    @GetMapping("/todo/{id}")
    fun getTodoById(@PathVariable id: Long): Todo? {
        return todoList.find { it.id == id }
    }

    // query string
    @GetMapping("/todo/search")
    fun getTodoByName(@RequestParam(defaultValue = "natnicha") name: String): Todo? {
        return todoList.find { it.name == name }
    }

    // ========== POST METHOD ==========
    @PostMapping("/todo")
    fun addTodo(@RequestBody todo: Todo) {
        todoList.add(Todo(COUNTER.getAndIncrement(), todo.name))
    }

    // ========== PUT METHOD ==========
    @PutMapping("/todo")
    fun update(@RequestBody todo: Todo) {
        todo.id?.toInt()?.let { id ->
            todoList[id].name = todo.name
        }
    }

    @PutMapping("/todo/{id}")
    fun updateById(@PathVariable id: Long, @RequestBody todo: Todo) {
        todoList[id.toInt()].name = todo.name
    }

    companion object {
        private var COUNTER = AtomicLong()
    }
}