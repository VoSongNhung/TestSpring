package com.example.demo.Controller;

import com.example.demo.DTO.InformationDTO;
import com.example.demo.FileUpload;
import com.example.demo.Responsitory.InformationRespository;
import com.example.demo.Service.InformationService;
import com.example.demo.Entity.Infomation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/information2")
public class Information2Controller {
    private final InformationService informationService;
    private final InformationRespository informationRespository;
@Autowired
private FileUpload fileUpload;
    public Information2Controller(InformationService informationService, InformationRespository informationRespository) {
        this.informationService = informationService;
        this.informationRespository = informationRespository;
    }
    @GetMapping
    public List<InformationDTO> findAllInformation(){
        return informationService.fillAllInformation();
    }
//  Cũng có thể sử dụng
//  private final InformationResponsitory informationResponsitory;
//    @GetMapping
//    public List<Infomation> findAllInformation(){
//        return informationResponsitory.fillAll();
//    }

    @GetMapping("/id/{id}")
    public InformationDTO findById(@PathVariable("id") String id){
        return informationService.findById(id);
    }
    @PostMapping
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public Infomation saveInformation(@RequestPart(name = "file") MultipartFile file, @ModelAttribute Infomation infomation) throws Exception {
        fileUpload.saveAs(file, "/imageInformation/" + file.getOriginalFilename());
        infomation.setImage(file.getOriginalFilename());
        return informationService.saveInformation(infomation);
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateInformation(@RequestBody Infomation infomation,@PathVariable String id) throws Exception {
        informationService.updateInformation(infomation,id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public void deteleInformation(@PathVariable("id") String id){
        informationService.deleteInformation(id);
    }
    @GetMapping("/lastname/{lastname}")
    public List<Infomation> findAllByLastname(@PathVariable("lastname") String lastname){
        return informationService.findAllByLastname(lastname);
    }
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        informationRespository.deleteAll();
    }
//    @GetMapping("/{lastname}")
//    public Infomation findLastnameByParams(@PathVariable("lastname") String lastname){
//        return informationService.findLastnameByParams(lastname);
//    }
}
