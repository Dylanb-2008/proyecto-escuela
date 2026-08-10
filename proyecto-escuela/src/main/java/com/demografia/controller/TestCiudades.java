package com.demografia.controller;

import com.demografia.DAO.IimplementacionCiudades;
import com.demografia.model.ciudades;
import java.util.List;

public class TestCiudades {
    public static void main(String[] args) {
        IimplementacionCiudades dao = new IimplementacionCiudades();

        ciudades ciu1 = new ciudades(100, "Rosario", 1); 
        ciudades ciu2 = new ciudades(101, "Mendoza", 1);

        System.out.println("--- Insertando Ciudades ---");
        if (dao.add(ciu1)) {
            System.out.println("Ciudad 1 insertada.");
        }
        if (dao.add(ciu2)) {
            System.out.println("Ciudad 2 insertada.");
        }

        System.out.println("\n--- Lista de Ciudades ---");
        List<ciudades> lista = dao.list();
        for (ciudades c : lista) {
            System.out.println("ID: " + c.getId() + " | Nombre: " + c.getNombre() + " | País ID: " + c.getPaisId());
        }

        System.out.println("\n--- Actualizando Ciudad con ID 100 ---");
        ciu1.setNombre("Rosario Actualizada");
        if (dao.update(ciu1)) {
            System.out.println("Ciudad actualizada en la base de datos.");
        }

        System.out.println("\n--- Eliminando Ciudad con ID 101 ---");
        if (dao.delete(101)) {
            System.out.println("Ciudad con ID 101 eliminada.");
        } else {
            System.out.println("No se pudo eliminar la ciudad.");
        }
    }
}
