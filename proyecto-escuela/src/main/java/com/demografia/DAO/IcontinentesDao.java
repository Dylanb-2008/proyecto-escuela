package com.demografia.DAO;

import com.demografia.model.*;
import java.util.List;

public interface IcontinentesDao {
    boolean add(continentes c);
    List<continentes> list();
    boolean update(continentes c);
    boolean delete(int id);
}