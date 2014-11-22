package web.util;

public class PropertiesCheckBox extends PropertiesGUI{
	private boolean marcado;
	public PropertiesCheckBox(boolean render, boolean deshabilitado, boolean marcado) {
		super(render, deshabilitado);
		// TODO Auto-generated constructor stub
		this.marcado=marcado;
	}
	public boolean isMarcado() {
		return marcado;
	}
	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}
}
