package controller;

import DAO.EspadaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Espada;
import view.ViewHome;

/**
 * @author Fabia
 */
public class ControllerHome implements ActionListener {

    private final ViewHome vista;
    private EspadaDAO dao;

    public ControllerHome() {
        this.vista = new ViewHome();
        
        try {
            this.dao = new EspadaDAO();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error de conexión: " + e.getMessage());
        }

        this.vista.getBtnAgregar().addActionListener(this);
        this.vista.getBtnLimpiar().addActionListener(this);
        this.vista.getBtnVerRegistros().addActionListener(this);
    }

    public void iniciarVista() {
        vista.setLocationRelativeTo(null);
        vista.setTitle("Gestión de Espadas - Evaluación 3");
        vista.setVisible(true);
        listarEnTabla(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.getBtnAgregar()) {
            agregarEspada();
        } 
        
        else if (e.getSource() == vista.getBtnLimpiar()) {
            limpiarCampos();
        } 
        
        else if (e.getSource() == vista.getBtnVerRegistros()) {
            listarEnTabla();
        }
    }

    private void agregarEspada() {
        try {
            String material = vista.getTxtMaterial().getText();
            int longitud = Integer.parseInt(vista.getTxtLongitud().getText());

            if (material.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "El material no puede estar vacío.");
                return;
            }

            Espada nuevaEspada = new Espada(0, material, longitud); 
            
            if (dao.agregarEspada(nuevaEspada)) {
                JOptionPane.showMessageDialog(vista, "Espada agregada con éxito.");
                limpiarCampos(); 
                listarEnTabla(); 
            } else {
                JOptionPane.showMessageDialog(vista, "Error al guardar en base de datos.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La longitud debe ser un número entero.");
        }
    }

   
    private void limpiarCampos() {
        vista.getTxtMaterial().setText("");
        vista.getTxtLongitud().setText("0");
    }

   
    private void listarEnTabla() {
        List<Espada> lista = dao.listarEspadas();
             
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Material");
        modelo.addColumn("Longitud (cm)");

        for (Espada esp : lista) {
            Object[] fila = new Object[3];
            fila[0] = esp.getId();
            fila[1] = esp.getMaterial();
            fila[2] = esp.getLongitud();
            modelo.addRow(fila);
        }

        vista.getTablaEspadas().setModel(modelo);
    }
}