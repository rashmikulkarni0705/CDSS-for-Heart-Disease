/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoID3;

import edu.uci.ics.jung.graph.DelegateForest;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.apache.commons.collections15.Factory;

/**
 *
 * @author vision soft
 */
public class GrapTree1 {

    public String st[];
    public int i;

    public int count(String str) {
        int cnt;
        StringTokenizer st = new StringTokenizer(str, "|");
        cnt = st.countTokens();
        if (str.indexOf("|") == -1) {
            cnt = 0;
        }
        return cnt;
    }

    public String getName(String str) {
        String s1 = "";

        s1 = str.substring(str.lastIndexOf("|") == -1 ? 0 : str.lastIndexOf("|") + 1).toString();
        return s1;
    }

    public void crateNode1(GraphNode n) {
        GraphNode l[] = new GraphNode[st.length];
        for (int j = 0; j < st.length  ; j++) {
            l[j] = new GraphNode(getName(st[j]));
        }
        for (int j = 0; j < st.length  ; j++) {
            int cnt = count(st[j]);
            if (cnt == 0) {
                n.node.add(l[j]);
                l[j].parent = n;
            } else {

                for (int k = j - 1; k >= 0; k--) {
                    int cnt1 = count(st[k]);
                    if (cnt1 < cnt) {
                        l[j].parent = l[k];
                        l[k].node.add(l[j]);
                        break;
                    }
                }
            }

        }
        System.out.println(n);
    }

    public DelegateForest buildTree(String str) {
        st = str.split("\n");
        GraphNode n = new GraphNode("root");
        i = 0;
        System.out.println(str);
        crateNode1(n);
        init();
        printTree1(0, n, "root");
        return graph;
    }
    Factory<Integer> edgeFactory = new Factory<Integer>() {

        int i = 0;

        public Integer create() {
            return i++;
        }
    };
    public Hashtable gname = new Hashtable();
    int gcnt = 0;
    public DelegateForest graph = new DelegateForest<String, String>();

    public void init() {
        graph = new DelegateForest<String, String>();
        gcnt = 0;
        gname = new Hashtable();

    }

    public void printTree1(int level, GraphNode root, String name) {

        if (level == 0) {
            //  for (int i = 0; i < Item.size(); i++) {
            graph.addVertex(String.valueOf(gcnt));
            gname.put(String.valueOf(gcnt), root.name);
            name = String.valueOf(gcnt);
        }

        if (root.node.size() > 0) {
            int l = level + 1;
            for (int j = 0; j < root.node.size(); j++) {
                gcnt++;
                gname.put(String.valueOf(gcnt), root.node.get(j).name);
                graph.addEdge(edgeFactory.create(), name, String.valueOf(gcnt));
                printTree1(l, root.node.get(j), String.valueOf(gcnt));
            }

        }

    }

    public static void main(String[] args) {
        String str = "OS\n"
                + "|   Windows\n"
                + "|   |   7\n"
                + "|   |   8\n"
                + "|   Linux\n"
                + "|   MAC\n"
                + "|   |   2\n"
                + "|   |   3\n"
                + "|   |   4(2.0/1.0)\n"
                + "";
        GrapTree1 gt = new GrapTree1();
        gt.buildTree(str);
    }
}
