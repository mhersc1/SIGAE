package test;

import org.junit.Test;

import dao.impl.PlantillaDAOImpl;
import dao.inf.PlantillaDAO;

public class PlantillaDAOImplTest {

	@Test
	public void test() {
		PlantillaDAO plantillaDAO= new PlantillaDAOImpl();
		System.out.println("The last" +plantillaDAO.lastId());
	}

}
