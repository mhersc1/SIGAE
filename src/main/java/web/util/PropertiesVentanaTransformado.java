package web.util;


public class PropertiesVentanaTransformado extends PropertiesGUI{	
	private boolean transformado;
	private String 	caracter;
	private Integer posicion;//0:Izquierda 1:Derecha
	
	public PropertiesVentanaTransformado() {
		// TODO Auto-generated constructor stub
	}
	
	public PropertiesVentanaTransformado(boolean render, boolean deshabilitado) {
		super(render, deshabilitado);
		// TODO Auto-generated constructor stub
	}
	public PropertiesVentanaTransformado(boolean render, boolean deshabilitado,
			boolean transformado, String caracter, Integer posicion) {
		super(render, deshabilitado);
		this.transformado = transformado;
		this.caracter = caracter;
		this.posicion = posicion;
	}
	
	public Integer getPosicion() {
		return posicion;
	}
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
	public String getCaracter() {
		return caracter;
	}
	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public boolean isTransformado() {
		return transformado;
	}

	public void setTransformado(boolean transformado) {
		this.transformado = transformado;
	}	
}
