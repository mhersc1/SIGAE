package web.util;
// Generated 27/11/2014 02:27:56 AM by Hibernate Tools 3.4.0.CR1

/**
 * Query generated by hbm2java
 */
public class Query{

	private String textoQuery;
	private String descripcion;
	private String nombre;

	public Query() {
		
	}
	
	public Query(String textoQuery, String descripcion, String nombre) {
		this.textoQuery = textoQuery;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	public String getTextoQuery() {
		return this.textoQuery;
	}

	public void setTextoQuery(String textoQuery) {
		this.textoQuery = textoQuery;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
