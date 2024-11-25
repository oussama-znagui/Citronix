package ma.znagui.app.service.Impl;

import ma.znagui.app.dto.farm.FarmCreateDTO;
import ma.znagui.app.dto.farm.FarmResponseDTO;
import ma.znagui.app.entity.Farm;
import ma.znagui.app.entity.Field;
import ma.znagui.app.exception.ResourceNotFoundExeption;
import ma.znagui.app.mapper.FarmMapper;
import ma.znagui.app.repository.FarmRepository;
import ma.znagui.app.service.FarmService;
import ma.znagui.app.specification.FarmSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FarmServiceImpl implements FarmService {
    @Autowired
    FarmRepository repository;
    @Autowired
    FarmMapper mapper;


    public FarmResponseDTO create(FarmCreateDTO dto) {
        Farm toCreate = mapper.createDTOtofarm(dto);
        toCreate.setCreationDate(LocalDate.now());
        Farm created = repository.save(toCreate);
        return mapper.farmToResponseDTO(created);
    }


    public FarmResponseDTO getOneFarm(Long id) {
        Farm farm = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Farm",id));

        return mapper.farmToResponseDTO(farm);
    }

    public Farm getFarmEntityByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Farm",id));
    }

    public FarmResponseDTO updateFarm(FarmCreateDTO dto, Long farmID) {
        Farm farm = mapper.createDTOtofarm(dto);
        Farm toUpdate = getFarmEntityByID(farmID);
        farm.setCreationDate(toUpdate.getCreationDate());

        return mapper.farmToResponseDTO(repository.save(farm));
    }








    public Double getFarmfreeArea(Farm farm){
        if (farm.getFields() == null){
            return farm.getArea();
        }else {
            Double usedArea  = farm.getFields().stream().mapToDouble(Field::getArea).sum();
            return farm.getArea() - usedArea;
        }
    }

    public List<FarmResponseDTO> findFarms(String name, String location, LocalDate creationDate) {
        Specification<Farm> spec = Specification.where(FarmSpecifications.hasName(name))
                .and(FarmSpecifications.hasLocation(location))
                .and(FarmSpecifications.wasCreatedAfter(creationDate));

//
//        System.out.println(repository.findAll(spec));

        return repository.findAll(spec).stream().map(farm -> mapper.farmToResponseDTO(farm)).toList();

    }

    public FarmResponseDTO deleteByID(Long id) {
        Farm farm = getFarmEntityByID(id);
        repository.deleteById(id);
        return mapper.farmToResponseDTO(farm);
    }

























    public List<FarmResponseDTO> getFarmlHarvsedInh(){
        List<Farm> farms = repository.findAll();
        List<Farm> farmsResut = new ArrayList<>();

    for (int i = 0;i < farms.size();i++){
       List<Field> fields =  farms.get(i).getFields();
       for (int j = 0;j < fields.size();j++){
           if (fields.get(i).getHarvests() != null){
               farmsResut.add(farms.get(i));
           }
       }
    }






        return null;
    }



}
