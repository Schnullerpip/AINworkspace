package aufgabe2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class AdjacencyListDirectedGraph<V> implements DirectedGraph<V> {

	HashMap<V, HashMap<V, Double>> predecessors = new HashMap<>();
	HashMap<V, HashMap<V, Double>> successors = new HashMap<>();

	@Override
	public boolean addVertex(V v) {
		if (containsVertex(v))
			return false;
		predecessors.put(v, new HashMap<>());
		successors.put(v, new HashMap<>());
		return false;
	}

	@Override
	public boolean addEdge(V v, V w) {
		return addEdge(v, w, 1.0);
	}

	@Override
	public boolean addEdge(V v, V w, double weight) {
		if (!containsVertex(v))
			throw new IllegalArgumentException("v nicht vorhanden!");
		if (!containsVertex(w))
			throw new IllegalArgumentException("w nicht vorhanden!");
		if (weight <= 0)
			throw new IllegalArgumentException("Gewichtung der Kante ist <= 0!");

		predecessors.get(v).put(w, weight);
		successors.get(w).put(v, weight);

		return false;
	}

	@Override
	public boolean containsVertex(V v) {
		return successors.containsKey(v) || predecessors.containsKey(v);
	}

	@Override
	public boolean containsEdge(V v, V w) {
		return successors.get(v).containsKey(w)
				|| predecessors.get(v).containsKey(w);
	}

	@Override
	public double getWeight(V v, V w) {
		if (containsVertex(v)) {
			if (containsVertex(w)) {
				if (successors.containsKey(v)) {
					return successors.get(v).get(w);
				} else {
					return predecessors.get(v).get(w);
				}
			}
			throw new IllegalArgumentException("w nicht vorhanden!");
		}
		throw new IllegalArgumentException("v nicht vorhanden!");
	}

	@Override
	public int getNumberOfVertexes() {
		return successors.size();
	}

	@Override
	public int getNumberOfEdges() {
		int count = 0;
		for (HashMap<V, Double> map : successors.values()) {
			count += map.size();
		}
		return count;
	}

	@Override
	public List<V> getVertexList() {
		return new LinkedList<V>(successors.keySet());
	}

	@Override
	public List<Edge<V>> getEdgeList() {
		LinkedList<Edge<V>> resultList = new LinkedList<>();
		for (Entry<V, HashMap<V, Double>> entry : successors.entrySet()) {
			for(V node : entry.getValue().keySet()){
				resultList.add(new Edge<V>(entry.getKey(), node));
			}
		}
		return null;
	}

	@Override
	public List<V> getAdjacentVertexList(V v) {
		return new LinkedList<V>(successors.keySet());
	}

	@Override
	public List<Edge<V>> getIncidentEdgeList(V v) {
		if (!containsVertex(v)) {
            throw new IllegalArgumentException("v nicht vorhanden.");
        }
        LinkedList<Edge<V>> result = new LinkedList<>();
        for (Entry<V, Double> entry : successors.get(v).entrySet()) {
            result.add(new Edge<>(v, entry.getKey(), entry.getValue()));
        }
        return result;
	}

	@Override
	public int getInDegree(V v) {
		if(!containsVertex(v))
			throw new IllegalArgumentException("v nicht vorhanden!");
		return predecessors.get(v).size();
	}

	@Override
	public int getOutDegree(V v) {
		if(!containsVertex(v))
			throw new IllegalArgumentException("v nicht vorhanden!");
		return successors.get(v).size();
	}

	@Override
	public List<V> getPredecessorVertexList(V v) {
		if(!containsVertex(v))
			throw new IllegalArgumentException("v nicht vorhanden!");
		return new LinkedList<V>(predecessors.get(v).keySet());
	}

	@Override
	public List<V> getSuccessorVertexList(V v) {
		if(!containsVertex(v))
			throw new IllegalArgumentException("v nicht vorhanden!");
		return new LinkedList<V>(successors.get(v).keySet());
	}

	@Override
	public List<Edge<V>> getOutgoingEdgeList(V v) {
		return getIncidentEdgeList(v);
	}
	@Override
	public List<Edge<V>> getIncomingEdgeList(V v) {
		List<Edge<V>> incomingList = new LinkedList<>();
		for(V node : successors.get(v).keySet()){
			incomingList.add(new Edge<V>(v, node));
		}
		return incomingList;
	}

}
