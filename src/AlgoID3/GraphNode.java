/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoID3;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author vision soft
 */
public class GraphNode {

    String name;
    ArrayList<GraphNode> node = new ArrayList();
    GraphNode parent;

    public GraphNode(String name) {
        this.name = name;
    }

    public GraphNode(String name, GraphNode parent) {
        this.name = name;
        this.parent = parent;
    }

   


}
