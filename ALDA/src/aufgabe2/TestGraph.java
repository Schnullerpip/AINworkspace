package aufgabe2;

public class TestGraph {
    public static void main(final String[] args) {
        Graph<Integer> g = new AdjacencyListUndirectedGraph<>();
        for (int i = 0; i < 6; ++i) {
            g.addVertex(i);
        }
        g.addEdge(0, 1);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        System.out.println(g.addEdge(5, 4));
        System.out.printf("Anzahl Edges: %d%n", g.getNumberOfEdges());
        System.out.printf("Anzahl Edges: %d%n", g.getEdgeList().size());
        System.out.println("------------------");
        for (Integer i : GraphTraversion.depthFirstSearch(g, 1)) {
            System.out.println(i);
        }
        System.out.println("-------------------");
        for (Integer i : GraphTraversion.breadthFirstSearch(g, 1)) {
            System.out.println(i);
        }
         
         
        DirectedGraph<Integer> top = new AdjacencyListDirectedGraph<>();
        for (int i = 1; i < 8; ++i) {
            top.addVertex(i);
        }
         
        top.addEdge(1, 3);
        top.addEdge(2, 3);
        top.addEdge(3, 4);
        top.addEdge(3, 5);
        top.addEdge(4, 6);
        top.addEdge(5, 6);
        top.addEdge(6, 7);
         
        System.out.println("-------------------");
        for (Integer i : GraphTraversion.topologicalSort(top)) {
            System.out.println(i);
        }
        
        DirectedGraph<String> anziehGraph = new AdjacencyListDirectedGraph<>();
        anziehGraph.addVertex("Strümpfe"); //
        anziehGraph.addVertex("Schuhe");	//
        anziehGraph.addVertex("Hose");		//
        anziehGraph.addVertex("Unterhose"); //
        anziehGraph.addVertex("Unterhemd");//
        anziehGraph.addVertex("Hemd");		//
        anziehGraph.addVertex("Gürtel");	//
        anziehGraph.addVertex("Pullover"); //
        anziehGraph.addVertex("Mantel");
        anziehGraph.addVertex("Schal");
        anziehGraph.addVertex("Handschuhe");
        anziehGraph.addVertex("Mütze");
        
        anziehGraph.addEdge("Unterhemd", "Hemd");
        anziehGraph.addEdge("Unterhose", "Hose");
        anziehGraph.addEdge("Strümpfe", "Schuhe");
        anziehGraph.addEdge("Hemd", "Hose");
        anziehGraph.addEdge("Hose", "Schuhe");
        anziehGraph.addEdge("Hose", "Gürtel");
        anziehGraph.addEdge("Hose", "Pullover");
        anziehGraph.addEdge("Pullover", "Schal");
        anziehGraph.addEdge("Pullover", "Mütze");
        anziehGraph.addEdge("Schal", "Mantel");
        anziehGraph.addEdge("Mantel", "Handschuhe");
        
        for(String s : GraphTraversion.topologicalSort(anziehGraph)){
        	System.out.println(s);
        }
        
    }
}