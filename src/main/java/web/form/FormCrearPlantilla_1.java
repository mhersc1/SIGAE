package web.form;

import java.util.ArrayList;
import java.util.List;

import web.util.PropertiesCheckBox;
import web.util.PropertiesGUI;
import web.util.PropertiesSpinner;


public class FormCrearPlantilla_1 extends PropertiesGUI{

//3:Header, Detail y Footer 
private List<PropertiesCheckBox> checkboxs;
//2: Header, Footer
private List<PropertiesSpinner> spinners;

private boolean buttonSiguiente;

public FormCrearPlantilla_1(boolean render, boolean deshabilitado) {
	super(render, deshabilitado);
	// TODO Auto-generated constructor stub
	setCheckboxs(new ArrayList<PropertiesCheckBox>(){{
		add(new PropertiesCheckBox(true, false, false));//Header
		add(new PropertiesCheckBox(true, false, false));//Detail
		add(new PropertiesCheckBox(true, true , false));//Footer
	}});	
	setSpinners(new ArrayList<PropertiesSpinner>(){{
		add(new PropertiesSpinner(true, true));//Header
		add(new PropertiesSpinner(true, true));//Footer
	}});	
	setButtonSiguiente(true);	
}

public FormCrearPlantilla_1(boolean render, boolean habilitado,
		List<PropertiesCheckBox> checkboxs,
		List<PropertiesSpinner> combos, boolean buttonSiguiente) {
	super(render, habilitado);
	this.checkboxs = checkboxs;
	this.spinners = combos;
	this.buttonSiguiente = buttonSiguiente;
}

public List<PropertiesCheckBox> getCheckboxs() {
	return checkboxs;
}

public void setCheckboxs(List<PropertiesCheckBox> checkboxs) {
	this.checkboxs = checkboxs;
}

public List<PropertiesSpinner> getSpinners() {
	return spinners;
}

public void setSpinners(List<PropertiesSpinner> spinners) {
	this.spinners = spinners;
}

public boolean isButtonSiguiente() {
	return buttonSiguiente;
}

public void setButtonSiguiente(boolean buttonSiguiente) {
	this.buttonSiguiente = buttonSiguiente;
}
public void actionEventCheckBoxHeader(){
		getCheckboxs().set(2, new PropertiesCheckBox(true, !getCheckboxs().get(0).isMarcado(), false));//Checkbox Footer	
		getSpinners().set(0, new PropertiesSpinner(true, !getCheckboxs().get(0).isMarcado(),1));//Combo Header
		getSpinners().set(1, new PropertiesSpinner(true, !getCheckboxs().get(2).isMarcado(),1));
		setButtonSiguiente(!(getCheckboxs().get(0).isMarcado()||getCheckboxs().get(1).isMarcado()));
}
public void actionEventCheckBoxDetail(){
	setButtonSiguiente(!(getCheckboxs().get(0).isMarcado()||getCheckboxs().get(1).isMarcado()));	
}
public void actionEventCheckBoxFooter(){	
	getSpinners().get(1).setRender(true);
	getSpinners().get(1).setDeshabilitado(!getCheckboxs().get(2).isMarcado());
}

public void actionEventSpinnerHeader(){//Update Spinner Footer change value Footer
	getSpinners().get(1).setCantidad(getSpinners().get(0).getCantidad());
}
}
