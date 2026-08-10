package com.demografia.DAO;

import com.demografia.config.Conexion;
import com.demografia.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IimplementecionContinentes implements IcontinentesDao {
    private Connection conn;

    public IimplementecionContinentes() {
        this.conn = Conexion.getConnection();
    }

    @Override
    public boolean add(continentes continente) {
        String sql = "INSERT INTO continentes (id, nombre) VALUES (?, ?);";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, continente.getId());
            stmt.setString(2, continente.getNombre());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<continentes> list() {
        List<continentes> listaContinentes = new ArrayList<>();
        String sql = "SELECT * FROM continentes";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                listaContinentes.add(new continentes(
                    rs.getInt("id"), 
                    rs.getString("nombre")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaContinentes;
    }

    @Override
    public boolean update(continentes continente) {
        String sql = "UPDATE continentes SET nombre = ? WHERE id = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, continente.getNombre());
            stmt.setInt(2, continente.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM continentes WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
