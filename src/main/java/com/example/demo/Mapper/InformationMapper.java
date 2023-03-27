package com.example.demo.Mapper;

import com.example.demo.DTO.InformationDTO;
import com.example.demo.Entity.Infomation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InformationMapper {
    InformationMapper mapper = Mappers.getMapper(InformationMapper.class);
    //@Mapping(source = "firstnameDTO",target = "firsname")
    @Mapping(source = "firstnameDTO",target = "firstname")
    @Mapping(source = "lastnameDTO",target = "lastname")
    Infomation maptoInformation (InformationDTO informationDTO);
    @Mapping(source = "firstname",target = "firstnameDTO")
    @Mapping(source = "lastname",target = "lastnameDTO")
    InformationDTO maptoInformationDTO (Infomation infomation);
    @Mapping(source = "firstname",target = "firstnameDTO")
    @Mapping(source = "lastname",target = "lastnameDTO")
    List<InformationDTO> maptoListInformation(List<Infomation> infomations);
}
