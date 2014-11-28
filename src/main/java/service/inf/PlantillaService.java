package service.inf;

import java.util.List;
import java.util.Map;

import model.Plantilla;
import web.form.RowTemplate;

public interface PlantillaService {

	public boolean save(String query,Map<String,Integer> etiquetas,List<RowTemplate> rowsTemplate);
	public boolean update(Plantilla plantilla);
	
}
