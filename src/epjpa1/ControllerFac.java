/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epjpa1;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author David
 */
public class ControllerFac {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public ControllerFac() {
        emf = Persistence.createEntityManagerFactory("EPJPA1PU");
        em = emf.createEntityManager();
    }
    
    
    
    public void createUser(String name, String email){
        
        ProjectUser user = new ProjectUser();
        user.setUserName(name);
        user.setEmail(email);
        user.setCreated(new Date());
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        
    }
    
    public ProjectUser findUser(int id){
        
        ProjectUser user = em.find(ProjectUser.class, id);
        return user;
    }
    
    public List<ProjectUser> findUser(String name){
        
        
        Query q = em.createQuery("SELECT a FROM ProjectUser a WHERE a.userName=:" + name);
        return q.getResultList();
        
    }
    
    public List<ProjectUser> getAllUsers(){
        
        List<ProjectUser> list;
        Query q = em.createQuery("SELECT c from ProjectUser c");
        list = q.getResultList();
        return list;
    }
    
    public void createProject(String name, String disc){
        
        Project p = new Project(name, disc);
        p.setCreated(new Date());
        p.setLastModified(new Date());
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
    }
    
    public void assignUserProject(int userID, int projectID){
        ProjectUser user = em.find(ProjectUser.class, userID);
        Project p = em.find(Project.class, projectID);
        p.setLastModified(new Date());
        user.addProject(p);
        p.addUser(user);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    
    public Project findProject(int id){
        return em.find(Project.class, id);
    }
    
    public void newTask(int pid, String name, String desc, int hours){
        Task t = new Task();
        t.setName(name);
        t.setDescription(desc);
        t.setHoursAssigned(hours);
        Project p = em.find(Project.class, pid);
        p.addTask(t);
        p.setLastModified(new Date());
        em.getTransaction().begin();
        em.getTransaction().commit();
        
    }
    
    
    public void done(){
        em.close();
        emf.close();
    }
    
    
}
