package com.example.Travel_Experience_Route_Sharing_Platform.Service;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Users;
import com.example.Travel_Experience_Route_Sharing_Platform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Users createUser(Users users) {
        if (users.getPasswordHash() == null) {
            users.setPasswordHash("temp_hashed_password_123");
        }
        return userRepository.save(users);
    }

    public List<Users> createUserMany(List<Users> users) {
        return userRepository.saveAll(users);
    }

    public List<Users> fetch() {
        return userRepository.findAll();
    }

    public String delete(Long id)
    {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Deletion Success";
        }
        return "Unable to delete or id not found";
    }

    public Users fetchById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public Users update(Long id, Users users)
    {
        Users users1=userRepository.findById(id).orElse(null);
        if(users1!=null){
            users1.setBio(users.getBio());
            users1.setEmail(users.getEmail());
            users1.setRole(users.getRole());
            users1.setProfileImageUrl(users.getProfileImageUrl());
            users1.setFullName(users.getFullName());
            users1.setPasswordHash(users.getPasswordHash());
            //users1.setEndLocation(users1.getEndLocation);
            return userRepository.save(users1);
        }
        return null;
    }
}
