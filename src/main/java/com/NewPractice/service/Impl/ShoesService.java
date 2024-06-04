package com.NewPractice.service.Impl;

import com.NewPractice.entity.Shoes;
import com.NewPractice.exception.ResourceNotFoundException;
import com.NewPractice.payload.ShoesDto;
import com.NewPractice.repository.ShoesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoesService {

    private ShoesRepository shoesRepository;

    public ShoesService(ShoesRepository shoesRepository) {
        this.shoesRepository = shoesRepository;
    }

    // save the data in database
    public ShoesDto CreateShoe(ShoesDto shoesDto) {

        Shoes shoes = mapToEntity(shoesDto);
        Shoes saved = shoesRepository.save(shoes);
//        Shoes shoes = new Shoes();
//        shoes.setId(shoesDto.getId());
//        shoes.setShoeName(shoesDto.getShoeName());
//        shoes.setShoesColor(shoesDto.getShoesColor());
//        shoes.setShoeShops(shoesDto.getShoeShops());


//        ShoesDto dto = new ShoesDto();
//        dto.setId(saved.getId());
//        dto.setShoeName(saved.getShoeName());
//        dto.setShoesColor(saved.getShoesColor());
//        dto.setShoeShops(saved.getShoeShops());
        ShoesDto dto = mapToDto(saved);
        return dto;

    }

    Shoes mapToEntity(ShoesDto shoesDto)
    {
        Shoes shoes = new Shoes();
        shoes.setId(shoesDto.getId());
        shoes.setShoeName(shoesDto.getShoeName());
        shoes.setShoesColor(shoesDto.getShoesColor());
        shoes.setShoeShops(shoesDto.getShoeShops());
        return shoes;
    }

    ShoesDto mapToDto(Shoes shoes)
    {
        ShoesDto dto = new ShoesDto();
        dto.setId(shoes.getId());
        dto.setShoeName(shoes.getShoeName());
        dto.setShoesColor(shoes.getShoesColor());
        dto.setShoeShops(shoes.getShoeShops());
        return dto;
    }

    // get data by id
    public Shoes getShowId(Long id) {
       Optional<Shoes> Opshoes = shoesRepository.findById(id);
       if (Opshoes.isPresent())
       {
           Shoes shoes = Opshoes.get();
           return shoes;
       }
       return null;
    }

    // get all data
    public List<ShoesDto> getAllShoe() {
       List<Shoes> sho = shoesRepository.findAll();
       List<ShoesDto> shoe =sho.stream().map(shoes-> mapToDto(shoes)).collect(Collectors.toList());
       return shoe;
    }

    // this is throws the exception by id
    public ShoesDto getShoesId(Long id) {
        Shoes shoes = shoesRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Shoe Id is not Found"+id)
        );
        ShoesDto dto = new ShoesDto();
        dto.setId(shoes.getId());
        dto.setShoeName(shoes.getShoeName());
        dto.setShoesColor(shoes.getShoesColor());
        dto.setShoeShops(shoes.getShoeShops());
        return dto;
    }


    // Pagination Concept.....  // http://localhsot:8080/api/posts?pageNo=0&pageSize=3
    public List<Shoes> getPageShoe(int pageNo, int pageSize, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Shoes> shoes =shoesRepository.findAll(pageable);
        List<Shoes> shw = shoes.getContent();
        Sort sort =(sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        return shw;
    }


    // Delete By Id
    public String getDeleteById(Long id) {
      Optional<Shoes> OpShoe =  shoesRepository.findById(id);
      if (OpShoe.isPresent())
      {
          shoesRepository.deleteById(id);
          return "Deleted";
      }
      return null;
    }

    // Delete All Data
    public String getdeleteall() {
        shoesRepository.deleteAll();
        return "Deleted";
    }

    // Update the data using id
    public Shoes getUpdatedId(Long id, Shoes shoes) {

      Optional<Shoes> OpSho = shoesRepository.findById(id);
      if (OpSho.isPresent())
      {
          Shoes shoes1 = OpSho.get();
          shoes1.setShoeName(shoes1.getShoeName());
          Shoes saved = shoesRepository.save(shoes1);
          return saved;
      }
      return null;
    }

}

// date:-2024-01-16 how to save data using map concept using stream api in getAll
// date:-2024-01-17 how to do pagination