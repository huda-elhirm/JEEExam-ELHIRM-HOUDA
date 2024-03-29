package com.example.jsfjpadao.Controller;

import com.example.jsfjpadao.DAO.EmployeDAOImpl;
import com.example.jsfjpadao.DAO.ProjetDAO;
import com.example.jsfjpadao.DAO.ProjetDAOImpl;
import com.example.jsfjpadao.Model.Employe;
import com.example.jsfjpadao.Model.Projet;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.*;


@Named("projetBean")
@ViewScoped
public class ProjetBean implements Serializable {
    @PersistenceContext
    private EntityManager entityManager;
    private List<Projet> projets;
    private ProjetDAO projetDAO= new ProjetDAOImpl();

    private Map<Employe, Set<Projet>> projetEmpMap;

    @PostConstruct
    public void init() {
        projetEmpMap = new HashMap<>();
        EmployeDAOImpl employeDAO = new EmployeDAOImpl();
        List<Employe> employes = employeDAO.getAll();
        for (Employe e : employes) {
            // Retrieve courses for each student
            Set<Projet> empProj = new HashSet<>(e.getProjets());
            // Populate the map with each student and their associated courses
            projetEmpMap.put(e, empProj);
        }
    }

    public Map<Employe, Set<Projet>> getProjetEmpMap() {
        return projetEmpMap;
    }

    public ProjetBean() {
    }
}
