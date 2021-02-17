/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class Conexion {
    /*private static EntityManager en;
    private static EntityManagerFactory enf;
    private static Conexion conectar = new Conexion();

    public Conexion() {
    }
    
    
    public static Conexion getInstance(){
        conectar();
        return conectar;
    }
    
    private static void conectar(){
        if(enf == null){
            enf = Persistence.createEntityManagerFactory("Administracion_De_TorneosPU");
        }
        if(en == null){
             en = enf.createEntityManager();
        }

    }
    
    public EntityManager en(){
        return en;
    }*/
    
    public static EntityManagerFactory sesion(){
        return Persistence.createEntityManagerFactory("PerfilUsuarioPU");
    }
    
    public static EntityManager em(){
        return Conexion.sesion().createEntityManager();
    }
    
    public static void main(String[] args) {
        Conexion.em();
    }
}
