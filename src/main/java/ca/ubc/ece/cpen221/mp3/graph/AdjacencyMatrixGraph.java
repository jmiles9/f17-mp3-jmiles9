package ca.ubc.ece.cpen221.mp3.graph;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

    private List<Vertex> vertexList;
    private List<List<Integer>> adjMatrix;
    private int size; //??


    ///////CONSTRUCTOR////////
    public AdjacencyMatrixGraph(){
        this.vertexList = new ArrayList<>();
        this.adjMatrix = new ArrayList<>();
    }

    //////INTERFACE METHODS//////////////////////////////////////////////////////////////////////
    /**
     * Adds a vertex to the graph.
     *
     * Precondition: v is not already a vertex in the graph
     */
    public void addVertex(Vertex v){
        //needs to add it to list to associate it with number.
        this.vertexList.add(v);

        //also needs to add column/row to graph... fill with 0s to start
        //add a new list of length(vertexList.size - 1) to end of list, then add a 0 to each list (including newest)
        // - 1 is bc we will add that back in the next for loop
        adjMatrix.add(new ArrayList<Integer>(Collections.nCopies(vertexList.size() - 1, 0)));
        for(List<Integer> col : adjMatrix){
            col.add(0);
        }
    }

    /**
     * Adds an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph
     */
    public void addEdge(Vertex v1, Vertex v2){
        //in matrix, need to add edge from v1 to v2 (directed??
        int v1Index = vertexList.indexOf(v1);
        int v2Index = vertexList.indexOf(v2);

        adjMatrix.get(v2Index).set(v1Index, 1); //check order of vs

        System.out.println(adjMatrix);
    }

    /**
     * Check if there is an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph Postcondition: return
     * true iff an edge from v1 connects to v2
     */
    public boolean edgeExists(Vertex v1, Vertex v2){
        int v1Index = vertexList.indexOf(v1);
        int v2Index = vertexList.indexOf(v2);

        return(adjMatrix.get(v2Index).get(v1Index) == 1);
    }

    /**
     * Get an array containing all downstream vertices adjacent to v.
     *
     * Precondition: v is a vertex in the graph
     *
     * Postcondition: returns a list containing each vertex w such that there is
     * an edge from v to w. The size of the list must be as small as possible
     * (No trailing null elements). This method should return a list of size 0
     * iff v has no downstream neighbors.
     */
    public List<Vertex> getDownstreamNeighbors(Vertex v){
        List<Vertex> neighbours = new ArrayList<>(0);
        //search v column of all other vertices' lists
        int col = vertexList.indexOf(v);
        for(int row = 0; row < vertexList.size(); row ++){
            if(adjMatrix.get(row).get(col) == 1) neighbours.add(vertexList.get(row));
        }

        return neighbours;
    }

    /**
     * Get an array containing all upstream vertices adjacent to v.
     *
     * Precondition: v is a vertex in the graph
     *
     * Postcondition: returns a list containing each vertex u such that there is
     * an edge from u to v. The size of the list must be as small as possible
     * (No trailing null elements). This method should return a list of size 0
     * iff v has no upstream neighbors.
     */
    public List<Vertex> getUpstreamNeighbors(Vertex v){
        List<Vertex> neighbours = new ArrayList<>(0);
        //linear search of list corresponding to v
        int row = vertexList.indexOf(v);
        for(int col = 0; col < vertexList.size(); col ++){
            if(adjMatrix.get(row).get(col) == 1) neighbours.add(vertexList.get(col));
        }

        return neighbours;
    }

    /**
     * Get all vertices in the graph.
     *
     * Postcondition: returns a list containing all vertices in the graph. This
     * method should return a list of size 0 iff the graph has no vertices.
     */
    public List<Vertex> getVertices(){
        List<Vertex> copy = new ArrayList<>();
        copy = vertexList;
        return copy;
    }
}
