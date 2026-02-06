package service;

import model.Task;
import repository.taskRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class taskService {

    private final taskRepository repository;

    public taskService(taskRepository repository){
        this.repository = repository;
    }

    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public Optional<Task> getTaskByID(long id){
        return repository.findById(id);
    }

    public  Task createTask(Task task){
        return repository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask){
        return repository.findById(id).map(task ->{
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return repository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
