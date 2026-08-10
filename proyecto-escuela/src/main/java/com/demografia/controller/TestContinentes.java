package com.demografia.controller;

import com.demografia.DAO.*;
import com.demografia.model.continentes;
import java.util.List;

public class TestContinentes {
    public static void main(String[] args) {
        IimplementecionContinentes dao = new IimplementecionContinentes();

        continentes c1 = new continentes(4, "África");
        continentes c2 = new continentes(5, "Oceanía");

        System.out.println("--- Insertando Continentes ---");
        if (dao.add(c1)) {
            System.out.println("Continente 1 insertado.");
        }
        if (dao.add(c2)) {
            System.out.println("Continente 2 insertado.");
        }

        System.out.println("\n--- Lista de Continentes ---");
        List<continentes> lista = dao.list();
        for (continentes c : lista) {
            System.out.println("ID: " + c.getId() + " | Nombre: " + c.getNombre());
        }

        System.out.println("\n--- Actualizando Continente con ID 4 ---");
        c1.setNombre("África Central");
        if (dao.update(c1)) {
            System.out.println("Continente actualizado correctamente.");
        }

        System.out.println("\n--- Eliminando Continente con ID 5 ---");
        if (dao.delete(5)) {
            System.out.println("Continente con ID 5 eliminado.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}
