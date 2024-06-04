package com.NewPractice.controller;

import com.NewPractice.entity.Shoes;
import com.NewPractice.payload.ShoesDto;
import com.NewPractice.service.Impl.ShoesService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shoe")
public class ShoeController {

    private ShoesService shoesService;


    public ShoeController(ShoesService shoesService
                       ) {
        this.shoesService = shoesService;
    }

    // save the data in database

    @PostMapping
    public ResponseEntity<?> CreateShoe(@Valid @RequestBody ShoesDto shoesDto, BindingResult bindingResult)
    {   if(bindingResult.hasErrors()){
        return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
    }
        ShoesDto dto = shoesService.CreateShoe(shoesDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    // get data by id
    @GetMapping("{id}")
    public ResponseEntity<?> getShowId(@PathVariable Long id)
    {
        Shoes shoes = shoesService.getShowId(id);
        if (shoes!=null)
        {
            return new ResponseEntity<>(shoes,HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found shows Is",HttpStatus.NOT_FOUND);
    }

    // get all data
    @GetMapping("/all")
    public List<ShoesDto> getAllShoe()
    {
       List<ShoesDto> sh = shoesService.getAllShoe();
       return sh;
    }

    // this is throws the exception by id

    @GetMapping
    public ResponseEntity<ShoesDto> getShoesId(@RequestParam Long id)
    {
        ShoesDto dto = shoesService.getShoesId(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    // Pagination Concept.....  // http://localhsot:8080/api/posts?pageNo=0&pageSize=3
        @GetMapping("/shoePage")
        public List<Shoes> getPageShoe
        (
            @RequestParam(name="pageNo",required = false, defaultValue = "0") int pageNo,
            @RequestParam(name="pageSize",required = false,defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy",required = false,defaultValue = "id") String sortBy,
            @RequestParam(name = "sortBy", required = false,defaultValue = "id") String sortDir
        )
        {
            List<Shoes> shoes = shoesService.getPageShoe(pageNo,pageSize,sortBy,sortDir);
            return shoes;
        }

    // Delete By Id
    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<?> getDeleteById(@PathVariable Long id)
    {
        String str = shoesService.getDeleteById(id);
        if(str!=null)
        {
            return new ResponseEntity<>(str,HttpStatus.OK);
        }
        return new ResponseEntity<>("Record is not found for this id",HttpStatus.NOT_FOUND);
    }

    // Delete All Data
    @DeleteMapping("/deleletallsc")
    public ResponseEntity<?>  getdeleteall()
    {
        String shoes = shoesService.getdeleteall();
        return new ResponseEntity<>(shoes,HttpStatus.OK);

    }

    // Update the data using id
    @PutMapping("Updated{id}")
    public ResponseEntity<?> getUpdatedId(@PathVariable Long id, @RequestBody Shoes shoes)
    {
       Shoes shoes1 = shoesService.getUpdatedId(id,shoes);
       if (shoes1!=null)
       {
           return new ResponseEntity<>(shoes1,HttpStatus.OK);
       }
       return new ResponseEntity<>("Shoes is not find for this id",HttpStatus.NOT_FOUND);
    }
}
