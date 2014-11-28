package web.util;

public class UsarPlantilla {
	private String nombre;//el nombre de la plantilla
	private String tipoEtiqueta; // header , detail o footer.
	private int  posicion; //me indica si es 1 , 2 y 3. cualquier etiqueta.
	private String campo; // nombre de la tabla que jala
	private int tamanio;//la cantidad de veces que haran
	private String tipoDato;//si sera numerico o alfanumerico
	private String cifrado;//si o no
	private String transformado;// si o no
	private String caracter;//sera como valor # , $ @ *
	private String posiciontrans;//posicion que va rellenar en el caracter
	private String orden;//sera el orden de la agregada
	
	
	
	
	
	public UsarPlantilla() {
		super();
	}
	public UsarPlantilla(String nombre, String tipoEtiqueta, int posicion,
			String campo, int tamanio, String tipoDato, String cifrado,
			String transformado, String caracter, String posiciontrans,
			String orden) {
		super();
		this.nombre = nombre;
		this.tipoEtiqueta = tipoEtiqueta;
		this.posicion = posicion;
		this.campo = campo;
		this.tamanio = tamanio;
		this.tipoDato = tipoDato;
		this.cifrado = cifrado;
		this.transformado = transformado;
		this.caracter = caracter;
		this.posiciontrans = posiciontrans;
		this.orden = orden;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoEtiqueta() {
		return tipoEtiqueta;
	}
	public void setTipoEtiqueta(String tipoEtiqueta) {
		this.tipoEtiqueta = tipoEtiqueta;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	public String getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	public String getCifrado() {
		return cifrado;
	}
	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}
	public String getTransformado() {
		return transformado;
	}
	public void setTransformado(String transformado) {
		this.transformado = transformado;
	}
	public String getCaracter() {
		return caracter;
	}
	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}
	public String getPosiciontrans() {
		return posiciontrans;
	}
	public void setPosiciontrans(String posiciontrans) {
		this.posiciontrans = posiciontrans;
	}
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	
	



}
