package service;

import model.RoleModel;
import model.UserModel;
import repository.RoleRepository;
import repository.UserRepository;

import java.util.List;

public class RoleService {

    private RoleRepository roleRepository = new RoleRepository();

    public List<RoleModel> getAllRoles(){
        List<RoleModel> list= roleRepository.findAll();

        return list;

    }

    public boolean insertRole(String name, String desc) {
        return roleRepository.insertRole(name,desc);
    }

    public boolean deleteRole(int id) {
        return roleRepository.deleteRoleById(id);
    }
}
