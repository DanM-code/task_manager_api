package controller;

import model.Task;
import service.taskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* RESTful API setup */
@RestController
@RequestMapping("/api/tasks")
public class taskController {

    private final taskService service;

    public taskController(taskService service){
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskByID(@PathVariable Long id){
        return service.getTaskByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return service.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }

}
