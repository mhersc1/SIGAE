package web.util;

public class PropertiesSpinner extends PropertiesGUI{
	private Integer cantidad=1;

	public PropertiesSpinner(boolean render, boolean deshabilitado) {
		super(render, deshabilitado);
		// TODO Auto-generated constructor stub
		
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


}
