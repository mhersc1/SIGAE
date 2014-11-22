package web.util;

public class PropertiesGUI{
	private boolean render;
	private boolean deshabilitado; 
	
	public PropertiesGUI(boolean render, boolean deshabilitado) {
		super();
		this.setRender(render);
		this.setDeshabilitado(deshabilitado);
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

	public boolean isDeshabilitado() {
		return deshabilitado;
	}

	public void setDeshabilitado(boolean deshabilitado) {
		this.deshabilitado = deshabilitado;
	}	
}
