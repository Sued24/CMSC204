import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GradeBookTest {

	private GradeBook g1 , g2;
	
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g1.addScore(50);
		g1.addScore(75);
		g2.addScore(46);
		g2.addScore(79);
		g2.addScore(0);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}
	
	@Test
	void testaddScore() {
		assertTrue(g1.toString().equals("50.0 75.0 0.0 0.0 0.0 "));
		assertTrue(g2.toString().equals("46.0 79.0 0.0 0.0 0.0 "));
	}

	@Test
	void testSum() {
		assertEquals(125, g1.sum(), .0001);
		assertEquals(125, g2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(50, g1.minimum(), .001);
		assertEquals(0, g2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(75, g1.finalScore(), .001);
		assertEquals(125, g2.finalScore(), 001);
	}
}
