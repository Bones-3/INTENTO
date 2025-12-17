/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Fabia
 */
public class Espada {
    private int id;
    private String material;
    private int longitud;
    
    //Constructor Vacio
    public Espada() {
    }
    
    //Constructor con parametros
    public Espada(int id, String material, int longitud) {
        this.id = id;
        this.material = material;
        this.longitud = longitud;
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }
    
    //Setters
    public void setMaterial(String material) {
        this.material = material;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    
}
