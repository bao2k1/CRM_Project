package service;

import model.TaskModel;
import model.UserModel;
import repository.TaskRepository;
import repository.UserRepository;

import java.util.List;

public class TaskService {
    private TaskRepository taskRepository = new TaskRepository();
    public List<TaskModel> getAllTasks(){
        List<TaskModel> list= taskRepository.findAllTasks();

        return list;

    }
    public boolean insertTask(String name,String startDate,String endDate,int user_id,int job_id,int status_id){
        return taskRepository.insertTask(name,startDate,endDate,user_id,job_id,status_id);
    }

    public boolean deleteTask(int id) {
        return taskRepository.deleteTaskById(id);
    }
}
