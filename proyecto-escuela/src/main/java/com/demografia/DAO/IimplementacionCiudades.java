package com.demografia.DAO;

import com.demografia.config.Conexion;
import com.demografia.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IimplementacionCiudades implements IciudadesDao {
    private Connection conn;

    public IimplementacionCiudades() {
        this.conn = Conexion.getConnection();
    }

    @Override
    public boolean add(ciudades ciudad) {
        String sql = "INSERT INTO ciudades (id, nombre, pais_id) VALUES (?, ?, ?);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ciudad.getId());
            stmt.setString(2, ciudad.getNombre());
            stmt.setInt(3, ciudad.getPaisId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ciudades> list() {
        List<ciudades> listaCiudades = new ArrayList<>();
        String sql = "SELECT * FROM ciudades";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                listaCiudades.add(new ciudades(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getInt("pais_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCiudades;
    }

    @Override
    public boolean update(ciudades ciudad) {
        String sql = "UPDATE ciudades SET nombre = ?, pais_id = ? WHERE id = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ciudad.getNombre());
            stmt.setInt(2, ciudad.getPaisId());
            stmt.setInt(3, ciudad.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM ciudades WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
