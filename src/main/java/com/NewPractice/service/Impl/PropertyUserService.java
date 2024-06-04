package com.NewPractice.service.Impl;

import com.NewPractice.entity.PropertyUser;
import com.NewPractice.payload.LoginDto;
import com.NewPractice.payload.PropertyUserDto;
import com.NewPractice.repository.PropertyUserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyUserService {

    private PropertyUserRepository propertyUserRepository;
    private JWTService jwtService;

    public PropertyUserService(PropertyUserRepository propertyUserRepository,JWTService jwtService) {
        this.propertyUserRepository = propertyUserRepository;
        this.jwtService = jwtService;
    }


    public PropertyUser addProperty(PropertyUserDto propertyUserDto) {

        PropertyUser propertyUser = new PropertyUser();
        propertyUser.setFirstName(propertyUserDto.getFirstName());
        propertyUser.setLastName(propertyUserDto.getLastName());
        propertyUser.setUsername(propertyUserDto.getUsername());
        propertyUser.setEmail(propertyUserDto.getEmail());
        propertyUser.setPassword(new BCrypt().hashpw(propertyUserDto.getPassword(),BCrypt.gensalt(10)));
        propertyUser.setUserRole(propertyUserDto.getUserRole());
        PropertyUser saved = propertyUserRepository.save(propertyUser);
        return saved;
    }

//    public Boolean loginUser(LoginDto loginDto) {
//
//       Optional<PropertyUser> OpUser = propertyUserRepository.findByUsername(loginDto.getUsername());
//       if (OpUser.isPresent())
//       {
//           PropertyUser user = OpUser.get();
//           return BCrypt.checkpw(loginDto.getPassword(),user.getPassword());
//       }
//        return false;
//    }


    // this is Part 2 JWT Token
    public String loginUser(LoginDto loginDto) {
        Optional<PropertyUser> OpUser = propertyUserRepository.findByUsername(loginDto.getUsername());
        if (OpUser.isPresent())
        {
            PropertyUser user = OpUser.get();
           if (BCrypt.checkpw(loginDto.getPassword(),user.getPassword()));
            {
               return jwtService.generatedToken(user);
            }
        }
        return null;
    }
}


// This is Part TwO Date:-28-03-2024