package test;

import org.hibernate.HibernateException;
import org.junit.Test;

import dao.CaracteristicasHome;

public class CaracteristicasDAOTest {

	@Test
	public void test() {
		try {
			CaracteristicasHome home =new CaracteristicasHome();
			home.getAll();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
