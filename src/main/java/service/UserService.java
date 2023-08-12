package service;

import model.RoleModel;
import model.UserModel;
import repository.RoleRepository;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository userRepository = new UserRepository();
    private RoleRepository roleRepository = new RoleRepository();

    public List<UserModel> checkList(){
        List<UserModel> list= userRepository.findAllUsers();

        return list;

    }
    public List<RoleModel> getAllRoles(){
        return  roleRepository.findAll();


    }
    public boolean insertUser(String fullname, String email, String password,int roleId){
        return userRepository.insertUser(email,fullname,password,roleId);
    }
    public boolean deleteUser(int id){
        return userRepository.deleteUserById(id);
    }
    public List<UserModel> getUserById(int id){
        List<UserModel> list= userRepository.getUserById(id);

        return list;

    }
    public boolean updateUser(String fullname, String email,int roleId,String password,int id){
        return userRepository.updateUser(email,fullname,roleId,password, id);
    }

}
