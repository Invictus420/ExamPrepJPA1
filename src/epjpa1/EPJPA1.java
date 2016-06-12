/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epjpa1;

import javax.persistence.Persistence;

/**
 *
 * @author David
 */
public class EPJPA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Persistence.generateSchema("EPJPA1PU", null);
        ControllerFac cc = new ControllerFac();
        cc.createUser("David", "david@pfg.dk");
        cc.createUser("Alex", "nigger@fag.dk");
        cc.createUser("Marco", "warco@gay.dk");
        System.out.println(cc.findUser(1).toString());
        System.out.println(cc.getAllUsers().toString());
        cc.createProject("ds", "project1");
        cc.assignUserProject(2, 1);
        cc.assignUserProject(3, 1);
        System.out.println(cc.findProject(1));
        cc.newTask(1, "task", "do something", 9001);
        cc.done();
    
    }
    
}
