package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Espada;

/**
 *
 * @author Fabia
 */
public class EspadaDAO {
    
    private final Connection conexion;

    public EspadaDAO() throws Exception {
        this.conexion = ConexionDAO.obtenerInstancia().getConexion();
    }
    
    public boolean agregarEspada(Espada espada) {
        String sql = "INSERT INTO Espada (material, longitud) VALUES (?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, espada.getMaterial());
            ps.setInt(2, espada.getLongitud());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al agregar: " + ex.getMessage());
            return false;
        }
    }
    
    public List<Espada> listarEspadas() {
        List<Espada> lista = new ArrayList<>();
        String sql = "SELECT * FROM Espada";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Espada espada = new Espada();
                espada.setId(rs.getInt("id"));
                espada.setMaterial(rs.getString("material"));
                espada.setLongitud(rs.getInt("longitud"));
                lista.add(espada);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar: " + ex.getMessage());
        }
        return lista;
    }
}