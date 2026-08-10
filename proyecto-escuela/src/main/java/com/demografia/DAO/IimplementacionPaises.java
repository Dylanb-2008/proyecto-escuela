package com.demografia.DAO;

import com.demografia.config.Conexion;
import com.demografia.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IimplementacionPaises implements IpaisesDao {
    private Connection conn;

    public IimplementacionPaises() {
        this.conn = Conexion.getConnection();
    }

    @Override
    public boolean add(paises pais) {
        String sql = "INSERT INTO paises (id, nombre, poblacion, continente_id) VALUES (?, ?, ?, ?);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pais.getId());
            stmt.setString(2, pais.getNombre());
            stmt.setLong(3, pais.getPoblacion());
            stmt.setInt(4, pais.getContinenteId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<paises> list() {
        List<paises> listaPaises = new ArrayList<>();
        String sql = "SELECT * FROM paises";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                listaPaises.add(new paises(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getLong("poblacion"), 
                    rs.getInt("continente_id") 
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPaises;
    }

    @Override
    public boolean update(paises pais) {
        String sql = "UPDATE paises SET nombre = ?, poblacion = ?, continente_id = ? WHERE id = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pais.getNombre());
            stmt.setLong(2, pais.getPoblacion());
            stmt.setInt(3, pais.getContinenteId());
            stmt.setInt(4, pais.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM paises WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
