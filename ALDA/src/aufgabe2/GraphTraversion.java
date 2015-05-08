package aufgabe2;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GraphTraversion<V> {

	public static <V> List<V> breadthFirstSearch(Graph<V> g, V v) {
		Deque<V> stack = new LinkedList<>();
		List<V> besucht = new LinkedList<>();

		stack.push(v);

		while (!stack.isEmpty()) {
			V tmp = stack.pop();
			if (besucht.contains(tmp))
				continue;
			besucht.add(tmp);

			@SuppressWarnings("unused")
			List<V> tmpList = g.getAdjacentVertexList(v);
			for (V w : g.getAdjacentVertexList(tmp)) {
				if (!stack.contains(w))
					stack.push(w);
			}
		}
		return besucht;
	}

	public static <V> List<V> depthFirstSearch(Graph<V> g, V v) {
		List<V> besucht = new LinkedList<>();
		depthVisit(v, g, besucht);
		return besucht;
	}

	public static <V> void depthVisit(V v, Graph<V> g, List<V> besucht) {
		for (V vertex : g.getAdjacentVertexList(v)) {
			if (!besucht.contains(vertex)) {
				besucht.add(vertex);
				depthVisit(vertex, g, besucht);
			}
		}
	}

	public static <V> List<V> topologicalSort(DirectedGraph<V> g) {
		List<V> sorted = new LinkedList<>();
        HashMap<V, Integer> inDegree = new HashMap<>();
        LinkedList<V> queue = new LinkedList<>();
         
        for (V v : g.getVertexList()) {
            int i = g.getInDegree(v);
            inDegree.put(v, i);
            if (i == 0) {
                queue.add(v);
            }
        }
         
        while(!queue.isEmpty()) {
            V v = queue.remove();            
            sorted.add(v);
            for (V successor : g.getSuccessorVertexList(v)) {
                int i = inDegree.get(successor) - 1;
                inDegree.put(successor, i);
                if (i == 0) {
                    queue.add(successor);
                }
            }
        }
         
        if (sorted.size() != g.getNumberOfVertexes()) {
            return null; // g ist zyklisch
        }
        return sorted;
	}
}
