package com.example.demo.Service;
import com.example.demo.DTO.InformationDTO;
import com.example.demo.Entity.Infomation;

import java.util.List;
import java.util.Optional;

public interface InformationService {
    List<InformationDTO> fillAllInformation();
    InformationDTO findById(String id);
    Infomation saveInformation(Infomation infomation) throws Exception;
    Infomation updateInformation(Infomation infomation,String id);
    void deleteInformation(String id);
    List<Infomation> findAllByLastname(String lastname);

}
