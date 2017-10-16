package ca.ubc.ece.cpen221.mp3.graph;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyListGraph implements Graph {
    public void addVertex(Vertex v){


    }

    /**
     * Adds an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph
     */
    public void addEdge(Vertex v1, Vertex v2){

    }

    /**
     * Check if there is an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph Postcondition: return
     * true iff an edge from v1 connects to v2
     */
    public boolean edgeExists(Vertex v1, Vertex v2){
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
        return new ArrayList<Vertex>();
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
        return new ArrayList<Vertex>();
    }

    /**
     * Get all vertices in the graph.
     *
     * Postcondition: returns a list containing all vertices in the graph. This
     * method should return a list of size 0 iff the graph has no vertices.
     */
    public List<Vertex> getVertices(){
        return new ArrayList<Vertex>();
    }
}
