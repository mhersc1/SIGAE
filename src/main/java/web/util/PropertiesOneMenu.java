package web.util;

import java.util.ArrayList;
import java.util.List;

public class PropertiesOneMenu extends PropertiesGUI{
	private List<String> items;
	private String itemSel;

	public PropertiesOneMenu(boolean render, boolean deshabilitado) {
		super(render, deshabilitado);
		// TODO Auto-generated constructor stub
		setItems(new ArrayList<String>(){{
			add("");
		}});
	}
	
	public PropertiesOneMenu(boolean render, boolean habilitado,
			List<String> items) {
		super(render, habilitado);
		this.items = items;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public String getItemSel() {
		return itemSel;
	}

	public void setItemSel(String itemSel) {
		this.itemSel = itemSel;
	}

}
