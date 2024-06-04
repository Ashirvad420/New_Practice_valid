package com.NewPractice.service.Impl;

import com.NewPractice.entity.School;
import com.NewPractice.exception.ResourceNotFoundException;
import com.NewPractice.payload.SchoolDto;
import com.NewPractice.repository.SchoolRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    // save the data in database
    public SchoolDto createDto(SchoolDto schoolDto) {


          School school = mapToEntity(schoolDto);
          School saved =  schoolRepository.save(school);

//        School school = new School();
//        school.setId(schoolDto.getId());
//        school.setSchoolName(schoolDto.getSchoolName());
//        school.setSchoolLocation(schoolDto.getSchoolLocation());
//        school.setSchoolPopu(schoolDto.getSchoolPopu());
//        School saved= schoolRepository.save(school);


//        SchoolDto dto = new SchoolDto();
//        dto.setId(saved.getId());
//        dto.setSchoolName(saved.getSchoolName());
//        dto.setSchoolLocation(saved.getSchoolLocation());
//        dto.setSchoolPopu(saved.getSchoolPopu());
//        return dto;

       SchoolDto schoolD = mapToDto(saved);
       return schoolD;

    }

    // mapToEntity Isme School , SchoolDto Pass krenge as Argument Lenge
   School mapToEntity(SchoolDto schoolDto)
   {
       School school = new School();
       school.setId(schoolDto.getId());
       school.setSchoolName(schoolDto.getSchoolName());
       school.setSchoolLocation(schoolDto.getSchoolLocation());
       school.setSchoolPopu(schoolDto.getSchoolPopu());
       School saved= schoolRepository.save(school);
       return saved;
   }

   // mapToDto isme Hum SchoolDto, And School As Argument Lenge
 SchoolDto  mapToDto(School school)
 {
     SchoolDto dto = new SchoolDto();
     dto.setId(school.getId());
     dto.setSchoolName(school.getSchoolName());
     dto.setSchoolLocation(school.getSchoolLocation());
     dto.setSchoolPopu(school.getSchoolPopu());
     return dto;
 }

    // get data by id
    public School getById(Long id) {
      Optional<School> opSchool = schoolRepository.findById(id);
      if (opSchool.isPresent())
      {
          School schools = opSchool.get();
          return schools;
      }
      return null;
    }

    // get all data
    public List<SchoolDto> getAll() {
       List<School> schools = schoolRepository.findAll();
       List<SchoolDto> sh =schools.stream().map(school -> mapToDto(school)).collect(Collectors.toList());
       return  sh;
    }


    // Pagination Concept.....  // http://localhost:8080/api/school/ScPage?pageNo=0&pageSize=5&sortBy=schoolpopu&sortDir=desc
    public List<School> getSchoolPage(int pageNo, int pageSize, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page <School> schools = schoolRepository.findAll(pageable);
        List<School> school = schools.getContent();
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        return school;
    }



    // this is throws the exception by id
    public SchoolDto getSchoolId(Long id) {
        School school = schoolRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("School id is not Found"+id)
        );
        SchoolDto dto = new SchoolDto();
        dto.setId(school.getId());
        dto.setSchoolName(school.getSchoolName());
        dto.setSchoolLocation(school.getSchoolLocation());
        dto.setSchoolPopu(school.getSchoolPopu());
        return dto;
    }

    // Delete By Id
    public String  getdeleteById(Long id) {
       Optional<School>  Opschool = schoolRepository.findById(id);
       if (Opschool.isPresent())
       {
           schoolRepository.deleteById(id);
           return "delete";
       }
       return null;
    }

    // Delete All Data
    public String getDeleteByAll() {
        schoolRepository.deleteAll();
        return "delete All";
    }


    // Update the data using id
    public School getUpdated(Long id, School school) {
       Optional<School> OpSchool = schoolRepository.findById(id);
       if (OpSchool.isPresent())
       {
           School school1= OpSchool.get();
           school1.setSchoolName(school1.getSchoolName());
           School saved = schoolRepository.save(school1);
           return saved;
       }
       return null;
    }
}

// date:-2024-01-16 how to save data using map concept using stream api in getAll
// date:-2024-01-17 how to do pagination