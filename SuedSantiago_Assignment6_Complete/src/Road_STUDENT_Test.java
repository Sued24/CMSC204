import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Santiago Sued
 *
 */
 class Road_STUDENT_Test {
	Road r1;
	Road r2;
	Town buenosAires;
	Town cordoba;
	Town rosario;
	Town marDelPlata;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("set up");
		buenosAires = new Town("Town_1");
		cordoba = new Town("Town_2");
		rosario = new Town("Town_3");
		marDelPlata = new Town("Town_4");
		r1 = new Road(buenosAires, cordoba, 400, "International Line");
		r2 = new Road(rosario, marDelPlata, "Highway");
	}

	@After
	public void tearDown() throws Exception {
		buenosAires = null;
		cordoba = null;
		rosario = null;
		marDelPlata = null;
		r1 = null;
		r2 = null;
	}	
	
	@Test
	public void testContains() {
		assertEquals(true, r1.contains(buenosAires));
		assertEquals(false, r2.contains(buenosAires));
	}
	
	@Test
	public void testGetName() {
		assertEquals("International Line", r1.getName());
	}
	
	@Test
	public void testGetDestination() {
		assertEquals(cordoba, r1.getDestination());
	}
	
	@Test
	public void testGetSource() {
		assertEquals(buenosAires, r1.getSource());
	}
	
	@Test
	public void testGetWeight() {
		assertEquals(400, r1.getWeight());
		assertEquals(1, r2.getWeight());
	}
	
	@Test
	public void testToString() {
		assertEquals("Town_3 to Town_4 via Highway", r2.toString());
	}

}