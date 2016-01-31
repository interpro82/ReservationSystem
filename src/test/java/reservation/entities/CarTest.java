package reservation.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.PersistenceException;

import org.junit.Before;
import org.junit.Test;

public class CarTest extends ATest<Car> {

	private Car car;
	private CarSpecification carSpecs;

	@Before
	public void createCar() {
		carSpecs = new CarSpecification("cool");
		car = new Car("CAR", carSpecs);
	}

	@Test
	public void testEquals() {
		save(car);
		Car car2 = new Car("CAR", carSpecs);
		assertEquals(car, car2);
		delete(car);
	}

	@Test
	public void testHash() {
		save(car);
		Car car2 = new Car("CAR", carSpecs);
		Set<Car> set = new HashSet<>();
		set.add(car);
		set.add(car2);
		assertTrue(set.size() == 1);
		delete(car);
	}

	@Test(expected = PersistenceException.class)
	public void testNullNamePersistance() {
		Car blank = new Car(null, carSpecs);
		save(blank);

	}

	@Test(expected = PersistenceException.class)
	public void testNullSpecsPersistance() {
		Car blank = new Car("BLANK", null);
		save(blank);

	}

}
