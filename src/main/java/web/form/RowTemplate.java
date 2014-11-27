package web.form;

import web.util.PropertiesVentanaTransformado;

public class RowTemplate {
	private Integer id;
	private String 	item;//i.e: H1, H2, D, F1 ...
	private String 	nombre;
	private Integer tamanio;//??
	private Integer tipo;//0:Alfanumerico 1:Numerico
	private boolean cifrado;
	private PropertiesVentanaTransformado transformado;
	
	public RowTemplate() {
		// TODO Auto-generated constructor stub
	}
	public RowTemplate(Integer id,String item,String nombre, Integer tamanio, Integer tipo,
			boolean cifrado, PropertiesVentanaTransformado transformado) {
		super();
		this.id=id;
		this.item=item;
		this.nombre = nombre;		
		this.tamanio = tamanio;
		this.tipo = tipo;
		this.cifrado = cifrado;
		this.transformado = transformado;
	}
	
	public RowTemplate(PropertiesVentanaTransformado transformado){
		this.transformado=transformado;	
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getTamanio() {
		return tamanio;
	}
	public void setTamanio(Integer tamanio) {
		this.tamanio = tamanio;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public boolean isCifrado() {
		return cifrado;
	}
	public void setCifrado(boolean cifrado) {
		this.cifrado = cifrado;
	}
	public PropertiesVentanaTransformado getTransformado() {
		return transformado;
	}
	public void setTransformado(PropertiesVentanaTransformado transformado) {
		this.transformado = transformado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
}
