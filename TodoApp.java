import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

// Spring Boot Application
@SpringBootApplication
public class TodoApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TodoApp.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("To-Do App läuft unter: http://localhost:8080");
    }

    @RestController
    @RequestMapping("/api/todos")
    public class TodoController {
        private List<String> todos = new ArrayList<>();

        @GetMapping
        public List<String> getTodos() {
            return todos;
        }

        @PostMapping
        public String addTodo(@RequestBody String todo) {
            todos.add(todo);
            return "Added: " + todo;
        }

        @DeleteMapping("/{index}")
        public String deleteTodo(@PathVariable int index) {
            if (index >= 0 && index < todos.size()) {
                return "Removed: " + todos.remove(index);
            }
            return "Invalid index!";
        }
    }

    @Controller
    public class WebController implements WebMvcConfigurer {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("forward:/index.html");
        }
    }

    @RestController
    public class FrontendFilesController {
        @GetMapping("/index.html")
        public String index() {
            return """
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>To-Do App</title>
                        <style>
                            body {
                                font-family: Arial, sans-serif;
                                background-color: #f4f4f4;
                                margin: 0;
                                padding: 0;
                            }
                            .container {
                                max-width: 600px;
                                margin: 50px auto;
                                background: #fff;
                                padding: 20px;
                                border-radius: 10px;
                                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                            }
                            h1 {
                                text-align: center;
                                color: #333;
                            }
                            #todoInput {
                                width: calc(100% - 100px);
                                padding: 10px;
                                margin-right: 10px;
                                border: 1px solid #ddd;
                                border-radius: 5px;
                            }
                            button {
                                padding: 10px 20px;
                                background-color: #28a745;
                                color: #fff;
                                border: none;
                                border-radius: 5px;
                                cursor: pointer;
                            }
                            button:hover {
                                background-color: #218838;
                            }
                            ul {
                                list-style: none;
                                padding: 0;
                            }
                            li {
                                padding: 10px;
                                background: #f9f9f9;
                                border: 1px solid #ddd;
                                margin-top: 10px;
                                border-radius: 5px;
                                display: flex;
                                justify-content: space-between;
                            }
                            li button {
                                background-color: #dc3545;
                                border: none;
                                color: #fff;
                                padding: 5px 10px;
                                border-radius: 5px;
                                cursor: pointer;
                            }
                            li button:hover {
                                background-color: #c82333;
                            }
                        </style>
                    </head>
                    <body>
                        <div class="container">
                            <h1>To-Do App</h1>
                            <input type="text" id="todoInput" placeholder="Neue Aufgabe hinzufügen...">
                            <button id="addTodo">Hinzufügen</button>
                            <ul id="todoList"></ul>
                        </div>
                        <script>
                            const todoInput = document.getElementById('todoInput');
                            const addTodoButton = document.getElementById('addTodo');
                            const todoList = document.getElementById('todoList');
                            const API_URL = '/api/todos';

                            async function loadTodos() {
                                const response = await fetch(API_URL);
                                const todos = await response.json();
                                renderTodos(todos);
                            }

                            function renderTodos(todos) {
                                todoList.innerHTML = '';
                                todos.forEach((todo, index) => {
                                    const li = document.createElement('li');
                                    li.textContent = todo;
                                    const deleteButton = document.createElement('button');
                                    deleteButton.textContent = 'Löschen';
                                    deleteButton.onclick = () => deleteTodo(index);
                                    li.appendChild(deleteButton);
                                    todoList.appendChild(li);
                                });
                            }

                            addTodoButton.addEventListener('click', async () => {
                                const todo = todoInput.value.trim();
                                if (todo) {
                                    await fetch(API_URL, {
                                        method: 'POST',
                                        headers: { 'Content-Type': 'application/json' },
                                        body: JSON.stringify(todo)
                                    });
                                    todoInput.value = '';
                                    loadTodos();
                                }
                            });

                            async function deleteTodo(index) {
                                await fetch(`${API_URL}/${index}`, { method: 'DELETE' });
                                loadTodos();
                            }

                            loadTodos();
                        </script>
                    </body>
                    </html>
                    """;
        }
    }
}
