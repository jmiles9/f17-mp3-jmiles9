import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AdjMatrixTest {

    @Test
    public void test0(){
        AdjacencyMatrixGraph graph1 = new AdjacencyMatrixGraph();

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");

        graph1.addVertex(v1);
        graph1.addVertex(v2);

        graph1.addEdge(v1, v2);

        assertTrue(graph1.edgeExists(v1, v2));
    }

    @Test
    public void test1(){
        AdjacencyMatrixGraph graph1 = new AdjacencyMatrixGraph();

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");

        graph1.addVertex(v1);
        graph1.addVertex(v2);

        graph1.addEdge(v1, v2);

        assertFalse(graph1.edgeExists(v2, v1));
    }

    @Test
    public void test2(){
        AdjacencyMatrixGraph graph1 = new AdjacencyMatrixGraph();

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        graph1.addVertex(v1);
        graph1.addVertex(v2);
        graph1.addVertex(v3);
        graph1.addVertex(v4);
        graph1.addVertex(v5);

        graph1.addEdge(v1, v2);
        graph1.addEdge(v1, v4);
        graph1.addEdge(v5, v2);
        graph1.addEdge(v4, v3);

        List<Vertex> neighbours = new ArrayList<>();
        neighbours.add(v2);
        neighbours.add(v4);

        assertEquals(neighbours, graph1.getDownstreamNeighbors(v1));
    }

    @Test
    public void test3(){
        AdjacencyMatrixGraph graph1 = new AdjacencyMatrixGraph();

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        graph1.addVertex(v1);
        graph1.addVertex(v2);
        graph1.addVertex(v3);
        graph1.addVertex(v4);
        graph1.addVertex(v5);

        graph1.addEdge(v1, v2);
        graph1.addEdge(v1, v4);
        graph1.addEdge(v5, v2);
        graph1.addEdge(v4, v3);

        List<Vertex> neighbours = new ArrayList<>();
        neighbours.add(v1);
        neighbours.add(v5);

        assertEquals(neighbours, graph1.getUpstreamNeighbors(v2));
    }

    @Test
    public void test4(){
        AdjacencyMatrixGraph graph1 = new AdjacencyMatrixGraph();

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        graph1.addVertex(v1);
        graph1.addVertex(v2);
        graph1.addVertex(v3);
        graph1.addVertex(v4);
        graph1.addVertex(v5);

        List<Vertex> vertices = new ArrayList<>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);

        assertEquals(vertices, graph1.getVertices());
    }

}
