package ca.ubc.ece.cpen221.mp3.graph;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyListGraph implements Graph {

    private List<LinkedList<Vertex>> adjList;
    private List<Vertex> vertexList;

    public AdjacencyListGraph(){
        this.adjList = new ArrayList<LinkedList<Vertex>>();
        this.vertexList = new ArrayList<>();
    }

    //////INTERFACE METHODS//////////////////////////////////////////////////////////////////////
    /**
     * Adds a vertex to the graph.
     *
     * Precondition: v is not already a vertex in the graph
     */

    public void addVertex(Vertex v){
        //needs to add a vertex to the list of vertices, and a linkedlist representing the vertex to the adjList.
        this.vertexList.add(v);

        //adding to adjacency list
        this.adjList.add(new LinkedList<Vertex>());

    }

    /**
     * Adds an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph
     */
    public void addEdge(Vertex v1, Vertex v2){
        //needs to add v1 to v2's list.
        int v2Index = vertexList.indexOf(v2);
        this.adjList.get(v2Index).add(v1);
    }

    /**
     * Check if there is an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph Postcondition: return
     * true iff an edge from v1 connects to v2
     */
    public boolean edgeExists(Vertex v1, Vertex v2){
        //needs to check the list of vertices connected to v2 (the list corresponding to v2 in the adjList)
        int v2Index = vertexList.indexOf(v2);
        for(Vertex v : adjList.get(v2Index)){
            if(v.equals(v1)) return true;
        }
        return false;
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
        //search every list for v, get list of the vertices whose corresponding lists contained v

        neighbours.removeAll(Collections.singleton(null));
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
        //this should just be the list corresponding to v

        neighbours.removeAll(Collections.singleton(null));
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
