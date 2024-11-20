package ma.znagui.app.service.Impl;

import ma.znagui.app.dto.farm.FarmCreateDTO;
import ma.znagui.app.dto.farm.FarmResponseDTO;
import ma.znagui.app.entity.Farm;
import ma.znagui.app.mapper.FarmMapper;
import ma.znagui.app.repository.FarmRepository;
import ma.znagui.app.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmServiceImpl implements FarmService {
    @Autowired
    FarmRepository repository;
    @Autowired
    FarmMapper mapper;


    public FarmResponseDTO create(FarmCreateDTO dto) {
        Farm toCreate = mapper.createDTOtofarm(dto);
        Farm created = repository.save(toCreate);
        return mapper.farmToResponseDTO(created);
    }
}
