package com.example.jsfjpadao.DAO;

import com.example.jsfjpadao.Model.Projet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProjetDAOImpl implements ProjetDAO{

    private EntityManagerFactory emf ;

    public ProjetDAOImpl() {
        emf = Persistence.createEntityManagerFactory("exam-pu");
    }

    @Override
    public List<Projet> AllProjetc() {
        System.out.println("Courses coming");

        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();

            TypedQuery<Projet> query = em.createQuery("SELECT p FROM Projet p", Projet.class);

            List<Projet> courseList = query.getResultList();

            em.getTransaction().commit();

            return courseList;
        }catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }    }
}
