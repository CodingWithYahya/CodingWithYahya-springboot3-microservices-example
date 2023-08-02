package com.stagedemo.departementservice.controller;

import com.stagedemo.departementservice.client.EmployeeClient;
import com.stagedemo.departementservice.model.Departement;
import com.stagedemo.departementservice.repository.DepartementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartementController.class);

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Departement add(@RequestBody Departement departement){
        LOGGER.info("Departement add : {} " , departement);
        return departementRepository.addDepartement(departement);
    }

    @GetMapping
    public List<Departement> findAll(){
        LOGGER.info("Departement find");
        return departementRepository.findAll();
    }

    @GetMapping("/{id}")
    public Departement findById(@PathVariable Long id){
        LOGGER.info("Departement find : id={}" , id);
        return departementRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Departement> findAllWithEmployees(){
        LOGGER.info("Departement find");
        List<Departement> departements = departementRepository.findAll();
        departements.forEach(departement -> departement
                .setEmployees(employeeClient
                        .findByDepartement(departement.getId())
                )
        );
        return departements;
    }

}
