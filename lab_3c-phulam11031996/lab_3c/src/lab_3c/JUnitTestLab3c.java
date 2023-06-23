package lab_3c;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class JUnitTestLab3c {

	@Test
	void testIsAvailableFalse() {
	    Database databaseMock = Mockito.mock(Database.class);
	    when(databaseMock.isAvailable()).thenReturn(false);

	    Service service = new Service(databaseMock);
	    boolean res = service.query("testing");
	    assertEquals(false, res);
	}

	@Test
	void testIsAvailableTrue() {
	    Database databaseMock1 = Mockito.mock(Database.class);
	    when(databaseMock1.isAvailable()).thenReturn(true);

	    Service service = new Service(databaseMock1);
	    boolean res = service.query("testing");
	    assertEquals(true, res);
	}

	@Test
	void testGetDatabaseID10() {
	    Database databaseMock = Mockito.mock(Database.class);
	    when(databaseMock.getUniqueId()).thenReturn(10);

	    Service service = new Service(databaseMock);
	    String res = service.getDatabaseID();
	    assertEquals("Using database with id: 10", res);
	}

	@Test
	void testGetDatabaseID32() {
	    Database databaseMock = Mockito.mock(Database.class);
	    when(databaseMock.getUniqueId()).thenReturn(32);

	    Service service = new Service(databaseMock);
	    String res = service.getDatabaseID();
	    assertEquals("Using database with id: 32", res);
	}

}
