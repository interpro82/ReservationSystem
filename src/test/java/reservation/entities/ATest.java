package reservation.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

public abstract class ATest<T> {

	protected EntityManager manager;

	@Before
	public void setUp() {
		manager = FactoryHolder.getInstance().getFactory().createEntityManager();
	}

	@After
	public void tearDown() {
		manager.close();
	}

	@AfterClass
	public static void closeFactory() {
		FactoryHolder.getInstance().getFactory().close();
	}

	protected void save(T entity) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
	}

	protected void delete(T entity) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(entity);
		transaction.commit();
	}

}
