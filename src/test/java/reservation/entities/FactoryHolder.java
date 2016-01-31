package reservation.entities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryHolder {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("reservation_system");

	private static FactoryHolder instance = new FactoryHolder();

	private FactoryHolder() {
	}

	public static FactoryHolder getInstance() {
		return instance;
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

}
