/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epjpa1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author David
 */
@Entity
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    private String name;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModified;
    @ManyToMany(mappedBy = "p")
    private List<ProjectUser> pu = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> t = new ArrayList<>();

    public List<Task> getT() {
        return t;
    }

    public void setT(List<Task> t) {
        this.t = t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project() {
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }



    public List<ProjectUser> getPu() {
        return pu;
    }

    public void setPu(List<ProjectUser> pu) {
        this.pu = pu;
    }

    public void addUser(ProjectUser user){
        this.pu.add(user);
    }
    
    public void addTask(Task t){
        this.t.add(t);
    }
    
}
