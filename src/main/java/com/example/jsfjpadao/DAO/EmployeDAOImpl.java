package com.example.jsfjpadao.DAO;

import com.example.jsfjpadao.Model.Employe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmployeDAOImpl implements EmployeDAO{


    private EntityManagerFactory emf;

    public EmployeDAOImpl() {
        emf = Persistence.createEntityManagerFactory("exam-pu");

    }
    @Override
    public List<Employe> getAll() {
            System.out.println("get all is called");
            // Create EntityManager
            EntityManager entityManager = emf.createEntityManager();
            try {
                // Begin transaction
                entityManager.getTransaction().begin();

                // Create query to retrieve all students
                TypedQuery<Employe> query = entityManager.createQuery("SELECT s FROM Employe s", Employe.class);

                // Execute query and get result list
                List<Employe> employes = query.getResultList();

                // Commit transaction
                entityManager.getTransaction().commit();

                return employes;
            } catch (Exception ex) {
                // If any exception occurs, rollback the transaction
                entityManager.getTransaction().rollback();
                throw ex;
            } finally {
                // Close EntityManager
                entityManager.close();
            }

    }



}
