/**
 * @author Santiago Sued
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road-1");
		  graph.addRoad(town[1], town[3], 4, "Road-2");
		  graph.addRoad(town[1], town[5], 6, "Road-3");
		  graph.addRoad(town[3], town[7], 1, "Road-4");
		  graph.addRoad(town[3], town[8], 2, "Road-5");
		  graph.addRoad(town[4], town[8], 3, "Road-6");
		  graph.addRoad(town[6], town[9], 3, "Road-7");
		  graph.addRoad(town[9], town[10], 4, "Road-8");
		  graph.addRoad(town[8], town[10], 2, "Road-9");
		  graph.addRoad(town[5], town[10], 5, "Road-10");
		  graph.addRoad(town[10], town[11], 3, "Road-11");
		  graph.addRoad(town[2], town[11], 6, "Road-12");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road-12", roads.get(3));
		graph.addRoad(town[4], town[11], 1,"Road-13");
		roads = graph.allRoads();
		assertEquals("Road-12", roads.get(3));
		assertEquals("Road-13", roads.get(4));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road-12", graph.getRoad(town[2], town[11]));
		assertEquals("Road-4", graph.getRoad(town[3], town[7]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_12"));
		graph.addTown("Town_12");
		assertEquals(true, graph.containsTown("Town_12"));
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_12"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[11]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[5]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road-1", roads.get(0));
		assertEquals("Road-10", roads.get(1));
		assertEquals("Road-11", roads.get(2));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[11]));
		graph.deleteRoadConnection(town[2], town[11], "Road-12");
		assertEquals(false, graph.containsRoadConnection(town[2], town[11]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		graph.deleteTown(town[2]);
		assertEquals(false, graph.containsTown("Town_2"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_10", roads.get(1));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[11]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road-1 to Town_2 2 mi",path.get(0).trim());
		  assertEquals("Town_2 via Road-12 to Town_11 6 mi",path.get(1).trim());
	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = graph.getPath(town[1],town[10]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road-2 to Town_3 4 mi",path.get(0).trim());
		  assertEquals("Town_3 via Road-5 to Town_8 2 mi",path.get(1).trim());
	}
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = graph.getPath(town[1],town[6]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road-2 to Town_3 4 mi",path.get(0).trim());
		  assertEquals("Town_3 via Road-5 to Town_8 2 mi",path.get(1).trim());
	}

}