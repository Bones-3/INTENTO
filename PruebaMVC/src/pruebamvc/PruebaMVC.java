/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebamvc;

import DAO.ConexionDAO;
import controller.ControllerHome;

/**
 *
 * @author Fabia
 */
public class PruebaMVC {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {  
            ConexionDAO.obtenerInstancia(); 
            
            ControllerHome ctrlHome = new ControllerHome();
            ctrlHome.iniciarVista();
            
        } catch (Exception e) {
            System.out.println("Error crítico al iniciar: " + e.getMessage());
        }
    }
}