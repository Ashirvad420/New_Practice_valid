package com.NewPractice.controller;
import com.NewPractice.entity.Country;
import com.NewPractice.payload.CountryDto;
import com.NewPractice.service.Impl.CountryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cont")
public class CountryController {

    private CountryServiceImpl countryService;

    public CountryController(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    // save the data in database
    @PostMapping
    public ResponseEntity<CountryDto> createPost(@RequestBody CountryDto countryDto)
    {
       CountryDto dto = countryService.createPost(countryDto);
       return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    // get data by id
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
      Country country = countryService.getById(id);
      if (country!=null)
      {
          return new ResponseEntity<>(country,HttpStatus.OK);
      }
      return new ResponseEntity<>("Not Found Country Id",HttpStatus.NOT_FOUND);
    }

    // get all data
    @GetMapping("/all")
    public List<CountryDto> getAll()
    {
        List<CountryDto> countries = countryService.getAll();
        return countries;
    }

    // this is also using get data by id
    @GetMapping
    private ResponseEntity<CountryDto> getCountById(@RequestParam  Long id)
    {
        CountryDto dto = countryService.getCountById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    // Pagination Concept.....  // http://localhost:8080/api/cont/Pagination?pageNo=2&pageSize=3&sortBy=countryName&sortDir=asc

    @GetMapping("/Pagination")
    public ResponseEntity<List<Country>> getPagination(

            @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", required = false,defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir", required = false,defaultValue = "id") String sortDir

            )
    {
       List<Country> countryDtos = countryService.getPagination(pageNo,pageSize,sortBy,sortDir);
       return new ResponseEntity<>(countryDtos,HttpStatus.OK);
    }



    // Delete By Id
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> getdeleteById(@PathVariable Long id)
    {
       String str = countryService.getdeleteById(id);
       if (str!=null)
       {
           return new ResponseEntity<>("Deleted",HttpStatus.OK);
       }
       return new ResponseEntity<>("Record not found for this id",HttpStatus.NOT_FOUND);
    }

    // Delete All Data
    @DeleteMapping("/deleteAlls")
    public ResponseEntity<?> getdeleteAll()
    {
        String  delete = countryService.getdeleteAll();
        return new ResponseEntity<>(delete,HttpStatus.OK);
    }

    // Update the data using id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> getUpdate(@PathVariable Long id,@RequestBody Country country)
    {
       Country countries  = countryService.getUpdate(id,country);
       if (countries!=null)
       {
           return new ResponseEntity<>(countries,HttpStatus.OK);
       }
       return new ResponseEntity<>("Country Not present for this Id",HttpStatus.NOT_FOUND);
    }

}


// stream():- it takes the Object address(posts) and given to posts

// SortBy - it is using based on the colum
// date:-2024-01-16 how to save data using map concept using stream api in getAll
