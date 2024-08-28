package com.aecode.webcoursesback.servicesimplement;

import com.aecode.webcoursesback.dtos.UserProfileDTO;
import com.aecode.webcoursesback.entities.UserProfile;
import com.aecode.webcoursesback.repositories.IUserProfileRepository;
import com.aecode.webcoursesback.services.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImplement implements IUserProfileService {
    @Autowired
    private IUserProfileRepository upR;
    @Override
    public void insert(UserProfileDTO userdto) {
        if (upR.existsByProfile_email(userdto.getEmail())) {
            throw new RuntimeException("El correo electrónico ya está en uso");
        }
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(userdto.getUsername());
        userProfile.setEmail(userdto.getEmail());
        userProfile.setPasswordHash(userdto.getPasswordHash());
        userProfile.setFirstName(userdto.getFirstName());
        userProfile.setLastName(userdto.getLastName());
        upR.save(userProfile);
    }

    @Override
    public List<UserProfile> list() {
        return upR.findAll();
    }

    @Override
    public void delete(int userId) {
        upR.deleteById(userId);
    }

    @Override
    public UserProfile listId(int userId) {
        return upR.findById(userId).orElse(new UserProfile());
    }

    @Override
    public void update(UserProfile userprofile) {
        upR.save(userprofile);
    }

    @Override
    public UserProfile authenticateUser(String usernameOrEmail, String password) {
        UserProfile user = upR.findByEmailOrUsername(usernameOrEmail, usernameOrEmail);
        if (user != null && user.getPasswordHash().equals(password)) {
            return user; // Devolver el perfil solo si las credenciales son válidas
        }
        return null;
    }
}
