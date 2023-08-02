package com.stagedemo.departementservice.repository;

import com.stagedemo.departementservice.model.Departement;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartementRepository {
    private List<Departement> departements = new ArrayList<>();

    public Departement addDepartement(Departement departement){
        departements.add(departement);
        return departement;
    }

    public Departement findById(Long id){
        return departements.stream()
                .filter(departement -> departement.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Departement> findAll(){
        return departements;
    }
}
