package com.example.demo.Service;

import com.example.demo.DTO.InformationDTO;
import com.example.demo.Entity.Infomation;
import com.example.demo.Mapper.InformationMapper;
import com.example.demo.Responsitory.InformationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplInformationService implements InformationService{
    @Autowired
    private final InformationRespository informationRespository;

    public ImplInformationService(InformationRespository informationRespository) {
        this.informationRespository = informationRespository;
    }

    @Override
    public List<InformationDTO> fillAllInformation() {
        return InformationMapper.mapper.maptoListInformation(informationRespository.findAll());
    }

    @Override
    public InformationDTO findById(String id) {
        return InformationMapper.mapper.maptoInformationDTO(informationRespository.findById(id).get());
    }

    @Override
    public Infomation saveInformation(Infomation infomation) throws Exception {
            return informationRespository.save(infomation);
    }

    @Override
    public Infomation updateInformation(Infomation infomation,String id) {
        Infomation findById = informationRespository.findById(id).orElse(null);
        if(!findById.equals(null))
        {
            infomation.setId(id);
            return informationRespository.save(infomation);
        }
        return null;
    }

    @Override
    public void deleteInformation(String id) {
        informationRespository.deleteById(id);
    }

    @Override
    public List<Infomation> findAllByLastname(String lastname) {
        return informationRespository.findAllByLastnameIgnoreCase(lastname);
    }


//    @Override
//    public Infomation findLastnameByParams(String lastname) {
//        return informationRespository.findLastnameByParams(lastname);
//    }

}
