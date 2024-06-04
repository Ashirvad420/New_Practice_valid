package com.NewPractice.controller;

import com.NewPractice.entity.PropertyUser;
import com.NewPractice.payload.LoginDto;
import com.NewPractice.payload.PropertyUserDto;
import com.NewPractice.payload.ResponceToken;
import com.NewPractice.service.Impl.PropertyUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/PropertyUser")
public class PropertyUserController {

    private PropertyUserService propertyUserService;

    public PropertyUserController(PropertyUserService propertyUserService) {
        this.propertyUserService = propertyUserService;
    }

    @PostMapping("/PropertyUse")
    public ResponseEntity<?> addProperty(@RequestBody PropertyUserDto propertyUserDto)
    {
        PropertyUser propertyUser = propertyUserService.addProperty(propertyUserDto);
        if (propertyUser!=null)
        {
            return new ResponseEntity<>("Registration is successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }


//    @PostMapping("/LoginUser")
//    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto)
//    {
//        Boolean val = propertyUserService.loginUser(loginDto);
//        if (val)
//        {
//            return new ResponseEntity<>("User Sign In",HttpStatus.OK);
//        }
//        return new ResponseEntity<>("In valid Credential",HttpStatus.UNAUTHORIZED);
//    }



    // JWT Token
    @PostMapping("/LoginUser")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto)
    {
        String token = propertyUserService.loginUser(loginDto);
        ResponceToken response = new ResponceToken();
        response.setToken(token);
        if (token!=null)
        {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return new ResponseEntity<>("In valid Credential",HttpStatus.UNAUTHORIZED);
    }

}
