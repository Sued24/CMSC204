import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Graph class holds all of the vertices and edges of a graph. It also includes many methods to work with the graph.
 * 
 * @author Santiago Sued
 */
public class Graph implements GraphInterface<Town,Road>{
	HashSet<Town> townsInGraph = new HashSet<Town>();
	HashSet<Road> roadsInGraph = new HashSet<Road>();
	HashMap<Town, Town> townsMap = new HashMap<Town, Town>();
	HashMap<Town, Integer> weightsInGraph = new HashMap<Town, Integer>();
	
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if(sourceVertex == null || destinationVertex == null)
			return null;
		
		for(Road roadIterator : roadsInGraph)
			if(roadIterator.contains(sourceVertex) && roadIterator.contains(destinationVertex)) {
				return roadIterator;
			}
		return null;
	}

    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road roadToAdd = new Road(sourceVertex, destinationVertex, weight, description);
		try {
			roadsInGraph.add(roadToAdd);
			if (sourceVertex == null || destinationVertex == null)
				throw new NullPointerException();
			if (!townsInGraph.contains(sourceVertex) || !townsInGraph.contains(destinationVertex))
				throw new IllegalArgumentException();
		} 
		catch (Exception e) {
			return null;
		}
		return roadToAdd;
	}

    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) {
		if (v == null)
			throw new NullPointerException();
		if (townsInGraph.contains(v))
			return false;
		else {
			townsInGraph.add(v);
			return true;
		}
	}

	  /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
			return false;
		else {
			for(Road iteratorRoad : roadsInGraph)
				if(iteratorRoad.contains(sourceVertex) && iteratorRoad.contains(destinationVertex))
					return true;
		}
		return false;
	}

    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		/**
		System.out.println("containsVertex was called with town " + v);
		System.out.println("Towns in the graph are: " + townsInGraph);
		if (v == null) {
			System.out.println("vertex is null");
			return false;
		}
		if(townsInGraph.contains(v)) {
			System.out.println(v + " is in graph");
			return true;
		}
		else {
			System.out.println(v + " is not in graph");
			return false;
		}
		*/
		if(v == null)
			return false;
		
		for(Town townIterator : townsInGraph)
			if(townIterator.equals(v))
				return true;
		return false;
	}

    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public HashSet<Road> edgeSet() {
		return new HashSet<Road>(roadsInGraph);
	}

    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public HashSet<Road> edgesOf(Town vertex) {
		HashSet<Road> roadsOf = new HashSet<Road>();
		
		if (vertex == null)
			throw new NullPointerException();
		else if (!containsVertex(vertex))
			throw new IllegalArgumentException();
		for (Road iteratorRoad : roadsInGraph)
			if (iteratorRoad.contains(vertex))
				roadsOf.add(iteratorRoad); // TODO Might cause issue with duplicate roads?
		
		return roadsOf;
	}

    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (sourceVertex == null || destinationVertex == null)
			return null;
		else if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
			return null;
		if (weight < 1)
			return null;
		if (description == null)
			return null;
		for(Road roadIterator : roadsInGraph)
			if(roadIterator.contains(sourceVertex) && roadIterator.contains(destinationVertex) && roadIterator.getWeight() == weight && roadIterator.getName() == description) {
				roadsInGraph.remove(roadIterator);
				return roadIterator;
			}
		return null;
		
	}

    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		if (v == null || v == null)
			return false;
		else if(!containsVertex(v) || !containsVertex(v))
			return false;
		if(townsInGraph.remove(v))
			return true;
		else return false;
	}

    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public HashSet<Town> vertexSet() {
		return townsInGraph;
	}
	
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */ 
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
	    ArrayList<String> shortestPath = new ArrayList<String>();
	    
	    dijkstraShortestPath(sourceVertex);
	    
	    if (!townsMap.containsKey(destinationVertex)) {
	        return shortestPath; // Return empty ArrayList if there's no path
	    }
	    
	    while(!sourceVertex.equals(destinationVertex)) {
	        for(Road roadIterator : roadsInGraph) {
	            if (roadIterator.contains(destinationVertex) && roadIterator.contains(townsMap.get(destinationVertex))) {
	                shortestPath.add(0, townsMap.get(destinationVertex).getName() + " via " + roadIterator.getName() + " to "
	                        + destinationVertex.getName() + " " + roadIterator.getWeight() + " mi");
	            }
	        }
	        destinationVertex = townsMap.get(destinationVertex);
	    }
	    return shortestPath;
	}

    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
	    Set<Town> dijkstraShortestPath = new HashSet<>(townsInGraph);

	    for (Town tempTown : townsInGraph) {
	        weightsInGraph.put(tempTown, Integer.MAX_VALUE);
	    }
	    weightsInGraph.put(sourceVertex, 0); // Set the initial weight of sourceVertex to 0

	    while (!dijkstraShortestPath.isEmpty()) {
	        int min = Integer.MAX_VALUE;
	        Town minVertex = null;

	        for (Town tempTown : weightsInGraph.keySet()) {
	            if (min > weightsInGraph.get(tempTown) && dijkstraShortestPath.contains(tempTown)) {
	                min = weightsInGraph.get(tempTown);
	                minVertex = tempTown;
	            }
	        }

	        // If no vertex found with minimum distance, exit the loop
	        if (minVertex == null) {
	            break;
	        }

	        sourceVertex = minVertex;

	        for (Road rNode : roadsInGraph) {
	            if (rNode.contains(sourceVertex)) {
	                if (!rNode.getDestination().equals(sourceVertex) &&
	                        dijkstraShortestPath.contains(rNode.getDestination())) {
	                    if (weightsInGraph.get(sourceVertex) + rNode.getWeight() < weightsInGraph.get(rNode.getDestination())) {
	                        townsMap.put(rNode.getDestination(), sourceVertex);
	                        weightsInGraph.put(rNode.getDestination(), rNode.getWeight() + weightsInGraph.get(sourceVertex));
	                    }
	                }
	                if (!rNode.getSource().equals(sourceVertex) && dijkstraShortestPath.contains(rNode.getSource())) {
	                    if (weightsInGraph.get(sourceVertex) + rNode.getWeight() < weightsInGraph.get(rNode.getSource())) {
	                        townsMap.put(rNode.getSource(), sourceVertex);
	                        weightsInGraph.put(rNode.getSource(), rNode.getWeight() + weightsInGraph.get(sourceVertex));
	                    }
	                }
	            }
	        }

	        dijkstraShortestPath.remove(sourceVertex);
	    }
	}
}
