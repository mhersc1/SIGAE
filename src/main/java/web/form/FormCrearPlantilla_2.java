package web.form;

import java.util.ArrayList;
import java.util.List;

import web.util.PropertiesGUI;
import web.util.PropertiesOneMenu;

public class FormCrearPlantilla_2 extends PropertiesGUI{
	private List<PropertiesOneMenu> combos;
	
	public FormCrearPlantilla_2(boolean render, boolean habilitado) {
		super(render, habilitado);
		// TODO Auto-generated constructor stub
		setCombos(new ArrayList<PropertiesOneMenu>(){{
			add(new PropertiesOneMenu(true, false));//Combo Grupal
			add(new PropertiesOneMenu(true, true));//Combo Campos

		}});			
	}

	public List<PropertiesOneMenu> getCombos() {
		return combos;
	}

	public void setCombos(List<PropertiesOneMenu> combos) {
		this.combos = combos;
	}
	
	
}
