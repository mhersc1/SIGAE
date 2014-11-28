package test;

import org.hibernate.HibernateException;
import org.junit.Test;

import dao.impl.CaracteristicasDAOImpl;

public class CaracteristicasDAOTest {

	@Test
	public void test() {
		try {
			CaracteristicasDAOImpl home =new CaracteristicasDAOImpl();
			
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
