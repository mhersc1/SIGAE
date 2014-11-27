package web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;

import web.form.FormCrearPlantilla_1;
import web.form.FormCrearPlantilla_2;
import web.form.RowTemplate;
import web.util.PropertiesGUI;
import web.util.PropertiesOneMenu;
import web.util.PropertiesVentanaTransformado;
import web.util.Util;

@ManagedBean(name="cpMB")
@ViewScoped
public class CrearPlantillaMB implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private FormCrearPlantilla_1 form1;
private FormCrearPlantilla_2 form2;
private List<RowTemplate> rows;

/**
 * Query's 
 */
private String query;
/**
 * Properties File
 */
private Properties props;
private RowTemplate selectedRow;//Selection Table

//Seleccionados
private RowTemplate rowsel;
private PropertiesGUI fa;//Funcion Adicional
@ManagedProperty(value="#{msg}")
private MessageView message;
@PostConstruct
private void init(){	
	/**
	 * Init Formulario Panel.
	 */	
	form1=new FormCrearPlantilla_1(true,false);
	//1er parametro Form 2--> button Aceptar Dialog SQL 
	form2=new FormCrearPlantilla_2(false,true);
	this.setRows(new ArrayList<RowTemplate>());
	setSelectedRow(new RowTemplate());	
	setQuery("");
	setFa(new PropertiesGUI(true,true));
	setRowsel(new RowTemplate(new PropertiesVentanaTransformado(true,true)));	
	props=Util.getProperties("parametros.properties");
}
public void ontTabChange(TabChangeEvent event){
	if(event.getTab().getId().equals("tab2")){
		cargarItemsComboGrupal();	
	}
}
/**
 * 
 * @param opcion
 * 1:Consulta SQL General
 * 2:Consulta SQL Group By
 */
public void validarConsultaSQL(int opcion){
	if(query.equals("sql")){		
		message.showMessage(1);
		if (opcion==1) {
			form2.setRender(true);
			form2.setDeshabilitado(false);
		}else if(opcion==2){
			fa.setRender(true);
			fa.setDeshabilitado(false);			
		}
	}else{
		message.showMessage(2);
		if (opcion==1) {
			form2.setRender(false);
			form2.setDeshabilitado(true);
		}else if(opcion==2){
			fa.setRender(false);
			fa.setDeshabilitado(true);
		}
	}	
}


public void listenerCaracterValido(){
	if(!rowsel.getTransformado().getCaracter().equals("")){
		rowsel.getTransformado().setDeshabilitado(false);
	}else{
		rowsel.getTransformado().setDeshabilitado(true);
		message.showMessage(5);
	}
}

public void actionOneMenuVT(RowTemplate row){
	RowTemplate raw=row;
	System.out.println("Size: "+rows.size());
	System.out.println("Id: "+row.getId());
	System.out.println("Caracter : "+raw.getTransformado().getCaracter());
	System.out.println("Posicion :"+raw.getTransformado().getPosicion());
	setRowsel(raw);
}

public void actionButtonSaveVT(){	
	this.rows.set(getRowsel().getId(), getRowsel());	
}

public  void actionButtonViewVT(RowTemplate row){
	RowTemplate raw=row;
	System.out.println("Size: "+rows.size());
	System.out.println("Fila View:"+row.getId());
	System.out.println("Caracter : "+raw.getTransformado().getCaracter());
	System.out.println("Posicion :"+raw.getTransformado().getPosicion());
	this.setRowsel(raw);
}

public void listenerButtonContinuar(){	
	cargarItemsComboGrupal();
	//Limpia la tabla luego de presionar el button "Siguiente"
	//del dialogo.
	form2.setDeshabilitado(false);		
}


public void cargarItemsComboGrupal(){//Combo Grupal
	//H1,H2,H3,D,F1,F2,F3
	//Se considera solo un detail "D"
	List<String> items=new ArrayList<String>();
	//Headers
	for(int i=1;i<= form1.getSpinners().get(0).getCantidad();i++){
		if (form1.getCheckboxs().get(0).isMarcado()) {
			items.add(props.getProperty("plantilla.header") + i);
		}
	}
	//Detail
	if(form1.getCheckboxs().get(1).isMarcado()){
		items.add(props.getProperty("plantilla.detail"));
	}	
	//Footers
	for(int i=1;i<=form1.getSpinners().get(1).getCantidad();i++){
		if (form1.getCheckboxs().get(2).isMarcado()) {
			items.add(props.getProperty("plantilla.footer") + i);
		}
	}
	//
	form2.getCombos().set(0,new PropertiesOneMenu(true, false, items));
	//Se limpia la tabla convencionalmente ...
	rows=new ArrayList<RowTemplate>();
}

private void cargarCamposCombo(){

	form2.getCombos().set(1,	new PropertiesOneMenu(true, false, new ArrayList<String>(){{add("Color");add("Edad");add("Sexo");}}));
}

public void reconocedorComboGrupal(){
	/**
	 * Reconoce según la etiqueta seleccionada en el combo grupal
	 * y habilita el combo respectivo asi como tambien lo carga.
	 */	
	cargarCamposCombo();	
}

public void reconocedorSubCombo(){
	/**
	 * Reconoce según la etiqueta seleccionada en el combo header
	 * y lo plasma en el datatable
	 */	
	PropertiesVentanaTransformado propVT=new 
			PropertiesVentanaTransformado(true, true, false, "", 2);
	String item=form2.getCombos().get(0).getItemSel();
	String label=form2.getCombos().get(1).getItemSel();
	
	if (!label.equalsIgnoreCase("") && !item.equalsIgnoreCase("")) {
		RowTemplate row = new RowTemplate(rows.size(), item, label, 4, 0, false, propVT);
		rows.add(row);
	}
	for(RowTemplate row:rows){
		System.out.println("Row "+row.getId());
		System.out.println("Caracter"+row.getTransformado().getCaracter());
		System.out.println("Posicion"+row.getTransformado().getPosicion());
		System.out.println();
	}
}
public void agregarFA(){
	
}
public void eliminarFila(){//Antes eliminarFA	

	rows.remove(selectedRow);
	//Al eliminar alguna de las filas se desplazan las filas segun el indice.
	//rowsel indexar a rows
	for(int i=selectedRow.getId();i<rows.size();i++){
		rows.get(i).setId(i);
		System.out.println(rows.get(i).getNombre());
	}	
}

public void validarConfiguracionPlantilla(){
	/**
	 * Notificar el p:message msgConf segun la validez de la configuracion de la plantilla
	 * Pedazo de codigo que se encarga de validar la configuracion en el datatable
	 */
	message.showMessage(3);
}

public String getQuery() {
	return query;
}
public void setQuery(String query) {
	this.query = query;
}
public MessageView getMessage() {
	return message;
}
public void setMessage(MessageView message) {
	this.message = message;
}
public FormCrearPlantilla_2 getForm2() {
	return form2;
}
public void setForm2(FormCrearPlantilla_2 form2) {
	this.form2 = form2;
}
public List<RowTemplate> getRows() {
	return rows;
}
public void setRows(List<RowTemplate> rows) {
	this.rows = rows;
}
public RowTemplate getSelectedRow() {
	return selectedRow;
}
public void setSelectedRow(RowTemplate selectedRow) {
	this.selectedRow = selectedRow;
}

public PropertiesGUI getFa() {
	return fa;
}
public void setFa(PropertiesGUI fa) {
	this.fa = fa;
}

public FormCrearPlantilla_1 getForm1() {
	return form1;
}
public void setForm1(FormCrearPlantilla_1 form1) {
	this.form1 = form1;
}
public RowTemplate getRowsel() {
	return rowsel;
}
public void setRowsel(RowTemplate rowsel) {
	this.rowsel = rowsel;
}
}
