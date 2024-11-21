package ma.znagui.app.service.Impl;

import ma.znagui.app.dto.field.FieldCreateDTO;
import ma.znagui.app.dto.field.FieldResponseDTO;
import ma.znagui.app.entity.Farm;
import ma.znagui.app.entity.Field;
import ma.znagui.app.exception.IncompatibleAreaExeption;
import ma.znagui.app.exception.ResourceNotFoundExeption;
import ma.znagui.app.mapper.FieldMapper;
import ma.znagui.app.repository.FieldRepository;
import ma.znagui.app.service.FarmService;
import ma.znagui.app.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldServiceImpl implements FieldService {
    @Autowired
    FieldMapper mapper;
    @Autowired
    FarmService farmService;
    @Autowired
    FieldRepository repository;


    public FieldResponseDTO createField(FieldCreateDTO dto) {
        Field field =  mapper.createDTOtoField(dto);
        Farm farm = farmService.getFarmEntityByID(field.getFarm().getId());

        if (farmService.getFarmfreeArea(farm) < field.getArea() || field.getArea() > farm.getArea()/2 || field.getArea() < 1000){
            throw new IncompatibleAreaExeption(farm.getId(),farmService.getFarmfreeArea(farm));
        }
        Field created = repository.save(field);
        created.setFarm(farm);
        return mapper.fieldToResponseDTO(created);
    }




    public FieldResponseDTO getfield(Long id) {
        Field field1 = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Champs",id));
        return mapper.fieldToResponseDTO(field1);
    }


    public Field getFieldEntityByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Champs",id));
    }


}
