package reservation.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.PersistenceException;

import org.junit.Before;
import org.junit.Test;

public class UserTest extends ATest<User> {

	private User user;

	@Before
	public void createUser() {
		user = new User("name");
	}

	@Test
	public void testEquals() {
		save(user);
		User user2 = new User("name");
		assertEquals(user, user2);
	}

	@Test
	public void testHash() {
		save(user);
		User user2 = new User("name");
		Set<User> set = new HashSet<>();
		set.add(user);
		set.add(user2);
		assertTrue(set.size() == 1);
	}

	@Test(expected = PersistenceException.class)
	public void testNullNamePersistance() {
		User blank = new User(null);
		save(blank);
	}

}
