package com.NewPractice.controller;

import com.NewPractice.entity.School;
import com.NewPractice.payload.SchoolDto;
import com.NewPractice.service.Impl.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    // save the data in database
    @PostMapping
    public ResponseEntity<?> createDto(@RequestBody SchoolDto schoolDto)
    {
        SchoolDto school = schoolService.createDto(schoolDto);
        return new ResponseEntity<>(school, HttpStatus.CREATED);
    }

    // get data by id
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        School schools =schoolService.getById(id);
        if (schools!=null)
        {
            return new ResponseEntity<>(schools,HttpStatus.OK);
        }
        return new ResponseEntity<>("School Id is not Find",HttpStatus.NOT_FOUND);
    }

    // get all data
    @GetMapping("/all")
    public List<SchoolDto> getAll()
    {
        List<SchoolDto>  schools  = schoolService.getAll();
        return schools;
    }

    // this is throws the exception by id

    @GetMapping
    public ResponseEntity<SchoolDto> getSchoolId(@RequestParam Long id)
    {
        SchoolDto dto = schoolService.getSchoolId(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }


    // Pagination Concept.....  //http://localhost:8080/api/school/ScPage?pageNo=0&pageSize=5&sortBy=schoolpopu&sortDir=desc

    @GetMapping("/ScPage")
    public List<School> getSchoolPage
            (
                @RequestParam(name = "pageName", required = false, defaultValue = "0") int pageNo,
                @RequestParam(name= "pageSize",required = false,defaultValue = "3") int pageSize,
                @RequestParam(name = "sortBy", required = false,defaultValue = "id") String sortBy,
                @RequestParam(name = "sortDir",required = false,defaultValue = "id") String sortDir
            )
    {
       List<School> schools = schoolService.getSchoolPage(pageNo,pageSize,sortBy,sortDir);
       return schools;
    }

    // Delete By Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> getdeleteById(@PathVariable Long id)
    {
       String school =schoolService.getdeleteById(id);
       if (school!=null)
       {
           return new ResponseEntity<>(school,HttpStatus.OK);
       }
       return new ResponseEntity<>("Id is not found",HttpStatus.NOT_FOUND);
    }

    // Delete All Data
    @DeleteMapping("/deleteSch")
    public ResponseEntity<?> getDeleteByAll()
    {
        String str = schoolService.getDeleteByAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Update the data using id
    @PutMapping("/delete/{Id}")
    public ResponseEntity<?> getUpdated(@PathVariable Long id, @RequestBody School school)
    {
        School str = schoolService.getUpdated(id,school);
        if (str!=null)
        {
            return new ResponseEntity<>(str,HttpStatus.OK);
        }
        return new ResponseEntity<>("School is not present for this id",HttpStatus.NOT_FOUND);
    }
}
