package model;
// Generated 27/11/2014 02:27:56 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Plantilla generated by hbm2java
 */
public class Plantilla implements java.io.Serializable {

	private int idPlantilla;
	private String nombre;
	private String direccion;
	private String query;
	private Set etiquetas = new HashSet(0);

	public Plantilla() {
	}

	public Plantilla(int idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public Plantilla(int idPlantilla, String nombre, String direccion,
			String query, Set etiquetas) {
		this.idPlantilla = idPlantilla;
		this.nombre = nombre;
		this.direccion = direccion;
		this.query = query;
		this.etiquetas = etiquetas;
	}

	public int getIdPlantilla() {
		return this.idPlantilla;
	}

	public void setIdPlantilla(int idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Set getEtiquetas() {
		return this.etiquetas;
	}

	public void setEtiquetas(Set etiquetas) {
		this.etiquetas = etiquetas;
	}

}