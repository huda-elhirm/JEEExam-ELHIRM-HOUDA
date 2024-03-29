package com.example.jsfjpadao.Controller;

import com.example.jsfjpadao.DAO.EmployeDAO;
import com.example.jsfjpadao.DAO.EmployeDAOImpl;
import com.example.jsfjpadao.Model.Employe;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

@Named("empBean")
@ViewScoped
public class EmployeBean implements Serializable {

    @PersistenceContext(unitName = "exam-pu")
    private EntityManager entityManager;

    private List<Employe> employeList;

    private EmployeDAO employeDAO = new EmployeDAOImpl();

    public EmployeBean(){
        employeList = employeDAO.getAll();
    }
    public List<Employe> getEmployeList() {
        System.out.println("Studentbean function is called");
        employeList = employeDAO.getAll();
        return employeList;
    }

}
