package service;

import model.JobModel;
import model.UserModel;
import repository.JobRepository;
import repository.UserRepository;

import java.util.List;

public class JobService {
    private JobRepository jobRepository = new JobRepository();
    public List<JobModel> getAllJobs(){
        List<JobModel> list= jobRepository.findAllJobs();

        return list;

    }

    public boolean insertJob(String name, String startDate, String endDate) {
        return jobRepository.insertJob(name,startDate,endDate);
    }
    public boolean deleteJob(int id){
        return jobRepository.deleteJobById(id);
    }

}
