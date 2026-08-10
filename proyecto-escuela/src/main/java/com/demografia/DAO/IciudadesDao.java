package com.demografia.DAO;

import com.demografia.model.*;
import java.util.List;

public interface IciudadesDao {
    boolean add(ciudades c);
    List<ciudades> list();
    boolean update(ciudades c);
    boolean delete(int id);
}