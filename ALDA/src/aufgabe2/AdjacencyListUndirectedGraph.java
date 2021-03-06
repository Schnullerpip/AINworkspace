package aufgabe2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class AdjacencyListUndirectedGraph<V> implements UndirectedGraph<V> {

	HashMap<V, HashMap<V, Double>> adjacencyList = new HashMap<V, HashMap<V, Double>>();

	@Override
	public boolean addVertex(V v) {
		if (adjacencyList.containsKey(v)) {
			return false;
		}
		adjacencyList.put(v, new HashMap<V, Double>());
		return true;
	}

	@Override
	public boolean addEdge(V v, V w) {
		return addEdge(v, w, 1.0);
	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		if(!containsVertex(v))
			throw new IllegalArgumentException("v nicht vorhanden!");
		if(!containsVertex(w))
			throw new IllegalArgumentException("w nicht vorhanden!");
		if(v.equals(w))
			throw new IllegalArgumentException("v und w zeigen auf den selben Knoten!");
		if(containsEdge(v, w))
			return false;
		
		adjacencyList.get(v).put(w, weight);
		adjacencyList.get(w).put(v, weight);
		return true;
	}

	@Override
	public boolean containsVertex(V v) {
		if (adjacencyList.containsKey(v))
			return true;
		return false;
	}

	@Override
	public boolean containsEdge(V v, V w) {
		return adjacencyList.get(v).containsKey(w);
	}

	@Override
	public double getWeight(V v, V w) {
		if(!containsVertex(v))
			throw new IllegalArgumentException("v nicht vorhanden!");
		if(!containsVertex(w))
			throw new IllegalArgumentException("w nicht vorhanden!");
		
		return adjacencyList.get(v).get(w).doubleValue();
	}

	@Override
	public int getNumberOfVertexes() {
		return adjacencyList.size();
	}

	@Override
	public int getNumberOfEdges() {
		int count = 0;
		for(HashMap<V, Double> tmp : adjacencyList.values())
			count += tmp.size();
		return count/2; //Da ungerichtet muss durch zwei geteilt werden ansonsten wird jede Kante doppelt gezählt
	}

	@Override
	public List<V> getVertexList() {
		return new LinkedList<>(adjacencyList.keySet());
	}

	@Override
	public List<Edge<V>> getEdgeList() {
		List<Edge<V>> edges = new LinkedList<Edge<V>>();
		for(Entry<V, HashMap<V, Double>> tmp : adjacencyList.entrySet()){
			for(V node : tmp.getValue().keySet()){
				Edge<V> newEntry = new Edge<V>(tmp.getKey(), node);
				if(!edges.contains(newEntry))
					edges.add(newEntry);
			}
		}
		return edges;
	}

	@Override
	public List<V> getAdjacentVertexList(V v) {
		if(!containsVertex(v))
			throw new IllegalArgumentException("v nivht vorhanden");
		return new LinkedList<V>(adjacencyList.get(v).keySet());
	}

	@Override
	public List<Edge<V>> getIncidentEdgeList(V v) {
		if(!containsVertex(v))
			throw new IllegalArgumentException("v nivht vorhanden");
		LinkedList<Edge<V>> result = new LinkedList<Edge<V>>();
        for (Entry<V, Double> entry : adjacencyList.get(v).entrySet()) {
            result.add(new Edge<V>(v, entry.getKey(), entry.getValue()));
        }
        return result;
	}

	@Override
	public int getDegree(V v) {
		return adjacencyList.get(v).size();
	}

}
