package com.NewPractice.service.Impl;

import com.NewPractice.entity.Country;
import com.NewPractice.exception.ResourceNotFoundException;
import com.NewPractice.payload.CountryDto;
import com.NewPractice.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl {

    private CountryRepository countryRepository;
    private ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository,ModelMapper modelMapper) {

        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    public CountryDto createPost(CountryDto countryDto) {


           Country countries = mapToEntity(countryDto);
        Country saved = countryRepository.save(countries);

        // Country country = new Country();
//            country.setId(countryDto.getId());
//            country.setCountryName(countryDto.getCountryName());
//            country.setCountryArea(countryDto.getCountryArea());
//            country.setCountryPopu(countryDto.getCountryPopu());



//            CountryDto dto = new CountryDto();
//            dto.setId(saved.getId());
//            dto.setCountryName(saved.getCountryName());
//            dto.setCountryArea(saved.getCountryArea());
//            dto.setCountryPopu(saved.getCountryPopu());
//            return dto;

       CountryDto countryDtos = mapToDto(saved);
       return countryDtos;

    }

    Country mapToEntity(CountryDto countryDto)
    {
        Country country = modelMapper.map(countryDto,Country.class);
//        Country country=new Country();
//        country.setId(countryDto.getId());
//        country.setCountryName(countryDto.getCountryName());
//        country.setCountryArea(countryDto.getCountryArea());
//        country.setCountryPopu(countryDto.getCountryPopu());
        return country;
    }

    CountryDto mapToDto(Country country)
    {
       CountryDto dto = modelMapper.map(country,CountryDto.class);
//        CountryDto dto = new CountryDto();
//        dto.setId(country.getId());
//        dto.setCountryName(country.getCountryName());
//        dto.setCountryArea(country.getCountryArea());
//        dto.setCountryPopu(country.getCountryPopu());
        return dto;
    }


    // get By id
    public Country getById(Long id) {
        Optional<Country> NewCon = countryRepository.findById(id);
        if (NewCon.isPresent())
        {
            Country country = NewCon.get();
            return country;
        }

        return null;
    }

    // get All Country
    public List<CountryDto> getAll() {
        List<Country> countries = countryRepository.findAll();
        List<CountryDto> countryDtos =countries.stream().map(country -> mapToDto(country)).collect(Collectors.toList());
        return countryDtos;

    }

    // this is throws the exception
    public CountryDto getCountById(Long id) {
       Country country = countryRepository.findById(id).orElseThrow(
               ()->new ResourceNotFoundException("Country not found with id"+id)
        );

        CountryDto dto = new CountryDto();
        dto.setId(country .getId());
        dto.setCountryName(country .getCountryName());
        dto.setCountryArea(country .getCountryArea());
        dto.setCountryPopu(country.getCountryPopu());
        return dto;
    }

    // Pagination Concept.....  // http://localhost:8080/api/cont/Pagination?pageNo=2&pageSize=3&sortBy=countryName&sortDir=asc
    public List<Country> getPagination(int pageNo, int pageSize, String sortBy, String sortDir)
    {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Country> pageCountries = countryRepository.findAll(pageable);
        List<Country> countries = pageCountries.getContent(); // Convert PageCountry to ListContent Using "getContent"
        Sort sort =(sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        return countries;
    }


    // Delete Data By id
    public String getdeleteById(Long id) {
       Optional<Country> OpCountry = countryRepository.findById(id);
       if (OpCountry.isPresent())
       {
            countryRepository.deleteById(id);
         return "Delete";
       }
       return null;
    }

    // get Delete All data
    public String getdeleteAll() {
        countryRepository.deleteAll();
        return "Deleted";
    }

    // Update data by id
    public Country getUpdate(Long id, Country country) {
        Optional<Country> OpByid = countryRepository.findById(id);
        if (OpByid.isPresent())
        {
            Country count = OpByid.get();
            count.setCountryName(country.getCountryName());
            Country saved = countryRepository.save(count);
            return saved;
        }
        return null;
    }
}

// date:-2024-01-16 how to save data using map concept using stream api in getAll
// date:-2024-01-17 how to do pagination
// Date:-2024-01-29  ModelMapper is a third Party Library