package web.util;

public class PropertiesSpinner extends PropertiesGUI{
	private Integer cantidad;

	public PropertiesSpinner(boolean render, boolean deshabilitado) {
		super(render, deshabilitado);
		// TODO Auto-generated constructor stub
		
	}
	public PropertiesSpinner(boolean render, boolean deshabilitado, Integer cantidad) {
		super(render, deshabilitado);
		// TODO Auto-generated constructor stub
		this.cantidad=cantidad;		
	}
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


}
