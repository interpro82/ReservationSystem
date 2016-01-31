package reservation.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.PersistenceException;

import org.junit.Before;
import org.junit.Test;

public class ReservationTest extends ATest<Reservation> {

	private Reservation reservation;
	private User user;
	private Car car;
	private Date startDate;
	private Date endDate;

	@Before
	public void crateReservation() {
		user = new User("user");
		car = new Car("car", new CarSpecification("cool"));
		startDate = new Date();
		endDate = new Date(startDate.getTime() + 1000 * 60 * 60 * 24);
		reservation = new Reservation(startDate, endDate, user, car);
	}

	@Test
	public void testEquals() {
		save(reservation);
		Reservation reservation2 = new Reservation(startDate, endDate, user, car);
		assertEquals(reservation, reservation2);
		delete(reservation);
	}

	@Test
	public void testHash() {
		save(reservation);
		Reservation reservation2 = new Reservation(startDate, endDate, user, car);
		Set<Reservation> set = new HashSet<>();
		set.add(reservation);
		set.add(reservation2);
		assertTrue(set.size() == 1);
		delete(reservation);
	}

	@Test(expected = PersistenceException.class)
	public void testNullNamePersistance() {
		Reservation blank = new Reservation(startDate, endDate, user, null);
		save(blank);

	}

	@Test(expected = NullPointerException.class)
	public void testNullDatesPersistance() {
		Reservation blank = new Reservation(null, null, user, car);
		save(blank);
	}

	@Test(expected = RuntimeException.class)
	public void testWrongDatesReservation() {
		@SuppressWarnings("unused")
		Reservation blank = new Reservation(endDate, startDate, user, car);
	}

}
