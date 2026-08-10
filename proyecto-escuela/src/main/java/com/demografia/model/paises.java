package com.demografia.model;

public class paises {
    private int id;
    private String nombre;
    private long poblacion;
    private int continenteId;

    public paises(int id, String nombre, long poblacion, int continenteId) {
        this.id = id;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.continenteId = continenteId;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public long getPoblacion() { return poblacion; }
    public int getContinenteId() { return continenteId; }

	public void setPoblacion(long l) {
		// TODO Auto-generated method stub
		
	}

	public void setNombre(String string) {
		// TODO Auto-generated method stub
		
	}


}
