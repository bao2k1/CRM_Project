package service;

import model.UserModel;
import repository.UserRepository;

import java.util.List;

public class LoginService {
    private UserRepository userRepository = new UserRepository();

    public boolean checkLogin(String email, String password){
        List<UserModel> list= userRepository.findByEmailAndPassword(email,password);
        return list.size()>0;
    }
    public List<UserModel> profileLogin(String email, String password){
        List<UserModel> user= userRepository.findByEmailAndPassword(email,password);
        return  user;
    }
    public boolean checkList(){
        List<UserModel> list= userRepository.findAllUsers();
        return list.size()>0;
    }

}
