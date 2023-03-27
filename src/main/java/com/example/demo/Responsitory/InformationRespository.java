package com.example.demo.Responsitory;

import com.example.demo.Entity.Infomation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InformationRespository extends JpaRepository<Infomation,String> {
    List<Infomation> findAllByLastnameIgnoreCase(String lastname);

//    @Query("SELECT i FROM Information i WHERE i.lastname = :lastname")
//    Infomation findLastnameByParams(@Param("lastname") String lastname);
}
