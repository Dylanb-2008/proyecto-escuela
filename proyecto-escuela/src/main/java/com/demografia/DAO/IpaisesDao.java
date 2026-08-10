package com.demografia.DAO;

import com.demografia.model.*;
import java.util.List;

public interface IpaisesDao {    
	boolean add(paises p);
    List<paises> list();
    boolean update(paises p);
    boolean delete(int id);
}
