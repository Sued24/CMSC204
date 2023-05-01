
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * 
 * @author Santiago Sued
 *
 */
public class Town_STUDENT_Test {
	Town buenosAires,Cordoba;

	@Before
	public void setUp() throws Exception {
		buenosAires=new Town("oldbuenosAires");
		Cordoba=new Town("maaber");
	}

	@After
	public void tearDown() throws Exception {
		buenosAires=Cordoba=null;
	}


	@Test
	public void testCompareTo() {
		assertTrue(0==buenosAires.compareTo(buenosAires));
		assertTrue(0<buenosAires.compareTo(Cordoba));
	}

	@Test
	public void testEqualsTown() {
		assertTrue(buenosAires.equals(new Town("oldbuenosAires")));
		assertTrue(!buenosAires.equals(Cordoba));
	}

	@Test
	public void testGetName() {
		assertEquals("oldbuenosAires",buenosAires.getName());
		assertEquals("maaber",Cordoba.getName());
	}

	@Test
	public void testToString() {
		assertEquals("oldbuenosAires",buenosAires.toString());
		assertEquals("maaber",Cordoba.toString());
	}

}