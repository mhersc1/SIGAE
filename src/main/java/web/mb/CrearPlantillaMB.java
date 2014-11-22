package web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import web.form.FormCrearPlantilla_1;
import web.form.FormCrearPlantilla_2;
import web.form.RowTemplate;
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
private String query;
private Properties props;

//Filas Seleccionadas
private RowTemplate selectedRow;

@ManagedProperty(value="#{msg}")
private MessageView message;
@PostConstruct
private void init(){	
	/**
	 * Init Formulario Panel.
	 */	
	form1=new FormCrearPlantilla_1(true,false);
	//1er parametro Form 2--> button Aceptar Dialog SQL 
	form2=new FormCrearPlantilla_2(false,false);	
	this.setRows(new ArrayList<RowTemplate>());
	setQuery("");
	props=Util.getProperties("parametros.properties");
}
public FormCrearPlantilla_1 getForm1() {
	return form1;
}
public void setForm1(FormCrearPlantilla_1 form1) {
	this.form1 = form1;
}
public boolean validarConsultaSQL(){
	if(query.equals("sql")){		
		message.showMessage(1);
		form2.setRender(true);
		return true;	
	}else{		
		form2.setRender(false);
		message.showMessage(2);
		return false;
	}	
}

public void eventButtonContinuar(){	
	cargarItemsComboGrupal();
	//Limpia la tabla luego de presionar el button "Siguiente"
	//del dialogo.
	rows=new ArrayList<RowTemplate>();
}

private void cargarItemsComboGrupal(){//Combo Grupal
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
			PropertiesVentanaTransformado(true, true, false, "*", 0);
	String item=form2.getCombos().get(0).getItemSel();
	String label=form2.getCombos().get(1).getItemSel();
	
	if (!label.equalsIgnoreCase("") && !item.equalsIgnoreCase("")) {
		RowTemplate row = new RowTemplate(1, item, label, 4, 0, false, propVT);
		rows.add(row);
	}	
}
public void agregarFA(){
	
}
public void eliminarFila(){//Antes eliminarFA
	rows.remove(selectedRow);
	selectedRow=null;
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
}
