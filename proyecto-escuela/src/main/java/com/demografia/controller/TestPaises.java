package com.demografia.controller;

import com.demografia.DAO.IimplementacionPaises;
import com.demografia.model.paises;
import java.util.List;

public class TestPaises {
    public static void main(String[] args) {
        IimplementacionPaises dao = new IimplementacionPaises();
        
        paises p1 = new paises(20, "Uruguay", 34000000L, 1);
        paises p2 = new paises(21, "Portugal", 10000000L, 2);
        
        System.out.println("--- Insertando Países ---");
        if (dao.add(p1)) {
            System.out.println("País 1 insertado correctamente.");
        }
        if (dao.add(p2)) {
            System.out.println("País 2 insertado correctamente.");
        }
        
        System.out.println("\n--- Lista de Países Inicial ---");
        List<paises> listaInicial = dao.list();
        for (paises p : listaInicial) {
            System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | Población: " + p.getPoblacion());
        }
        
        System.out.println("\n--- Actualizando País con ID 1 ---");
        p1.setNombre("Jamaica Actualizado");
        p1.setPoblacion(47000000L);
        
        if (dao.update(p1)) {
            System.out.println("País actualizado en la base de datos.");
        } else {
            System.out.println("Error al actualizar el país.");
        }
        
        System.out.println("\n--- Lista después de Actualizar ---");
        List<paises> listaPostUpdate = dao.list();
        for (paises p : listaPostUpdate) {
            System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | Población: " + p.getPoblacion());
        }
        
        System.out.println("\n--- Eliminando País con ID 2 ---");
        int idEliminar = 2;
        if (dao.delete(idEliminar)) {
            System.out.println("País con ID " + idEliminar + " eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el país.");
        }
        
        System.out.println("\n--- Lista de Países Final ---");
        List<paises> listaFinal = dao.list();
        for (paises p : listaFinal) {
            System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | Población: " + p.getPoblacion());
        }
    }
}
