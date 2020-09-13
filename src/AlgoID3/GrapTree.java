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
public class GrapTree {

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
        System.out.println(str.indexOf("C"));

        s1 = str.substring(str.indexOf("C"));
        return s1;
    }

    public void crateNode1(GraphNode n) {
        GraphNode l[] = new GraphNode[st.length];
        for (int j = 3; j < st.length - 4; j++) {
            l[j] = new GraphNode(getName(st[j]));
        }
        for (int j = 3; j < st.length - 4; j++) {
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

    public DelegateForest buildTree1(String str,int j) {
        String[] s1 = str.split("ExtendedSubtree");
        //for (int j = 1; j < 2; j++) {
            str = s1[j];
            System.out.println(str);
            st = str.split("\n");
            GraphNode n = new GraphNode("root");
            i = 0;
            System.out.println(str);
            crateNode1(n);
            init();
            printTree1(0, n, "root");
        //}
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
        String str = "C12 = T6\n"
                + "|   C11 = T0\n"
                + "|   |   C8 = T0: C0 (5.0)\n"
                + "|   |   C8 = T1: C2 (3.0/1.0)\n"
                + "|   C11 = T3: C2 (2.0/1.0)\n"
                + "|   C11 = T2\n"
                + "|   |   C0 = H: C1 (2.0/1.0)\n"
                + "|   |   C0 = L: C2 (0.0)\n"
                + "|   |   C0 = N: C2 (2.0/1.0)\n"
                + "|   |   C0 = VL: C2 (0.0)\n"
                + "|   |   C0 = VH: C2 (0.0)\n"
                + "|   C11 = T1\n"
                + "|   |   C2 = T1: C2 (0.0)\n"
                + "|   |   C2 = T4: C1 (2.0)\n"
                + "|   |   C2 = T3: C2 (2.0)\n"
                + "|   |   C2 = T2: C2 (0.0)\n"
                + "C12 = T3\n"
                + "|   C11 = T0: C0 (117.0/13.0)\n"
                + "|   C11 = T3\n"
                + "|   |   C0 = H: C2 (3.0/1.0)\n"
                + "|   |   C0 = L: C2 (0.0)\n"
                + "|   |   C0 = N: C0 (2.0/1.0)\n"
                + "|   |   C0 = VL: C2 (0.0)\n"
                + "|   |   C0 = VH: C4 (1.0)\n"
                + "|   C11 = T2\n"
                + "|   |   C6 = T2: C3 (5.0/1.0)\n"
                + "|   |   C6 = T0: C0 (9.0/3.0)\n"
                + "|   |   C6 = T1: C0 (0.0)\n"
                + "|   C11 = T1\n"
                + "|   |   C9 = T2: C3 (1.0)\n"
                + "|   |   C9 = T1\n"
                + "|   |   |   C10 = T3: C0 (0.0)\n"
                + "|   |   |   C10 = T2: C1 (3.0)\n"
                + "|   |   |   C10 = T1: C0 (3.0)\n"
                + "|   |   C9 = T3: C4 (1.0)\n"
                + "|   |   C9 = T0\n"
                + "|   |   |   C1 = T1\n"
                + "|   |   |   |   C7 = N\n"
                + "|   |   |   |   |   C3 = N: C0 (2.0)\n"
                + "|   |   |   |   |   C3 = H: C0 (1.0)\n"
                + "|   |   |   |   |   C3 = L: C2 (3.0/1.0)\n"
                + "|   |   |   |   |   C3 = VH: C0 (0.0)\n"
                + "|   |   |   |   C7 = L: C3 (1.0)\n"
                + "|   |   |   |   C7 = H: C1 (2.0)\n"
                + "|   |   |   |   C7 = VH: C0 (0.0)\n"
                + "|   |   |   |   C7 = VL: C0 (0.0)\n"
                + "|   |   |   C1 = T0: C0 (12.0/1.0)\n"
                + "|   |   C9 = T6: C0 (0.0)\n"
                + "|   |   C9 = T4: C0 (0.0)\n"
                + "|   |   C9 = T5: C0 (0.0)\n"
                + "C12 = T7\n"
                + "|   C2 = T1: C0 (8.0/3.0)\n"
                + "|   C2 = T4\n"
                + "|   |   C9 = T2\n"
                + "|   |   |   C0 = H: C2 (3.0/2.0)\n"
                + "|   |   |   C0 = L: C3 (2.0)\n"
                + "|   |   |   C0 = N\n"
                + "|   |   |   |   C11 = T0: C4 (1.0)\n"
                + "|   |   |   |   C11 = T3: C1 (1.0)\n"
                + "|   |   |   |   C11 = T2: C3 (4.0/2.0)\n"
                + "|   |   |   |   C11 = T1\n"
                + "|   |   |   |   |   C7 = N: C3 (3.0/1.0)\n"
                + "|   |   |   |   |   C7 = L: C1 (2.0)\n"
                + "|   |   |   |   |   C7 = H: C1 (0.0)\n"
                + "|   |   |   |   |   C7 = VH: C1 (0.0)\n"
                + "|   |   |   |   |   C7 = VL: C1 (0.0)\n"
                + "|   |   |   C0 = VL: C3 (0.0)\n"
                + "|   |   |   C0 = VH: C3 (0.0)\n"
                + "|   |   C9 = T1\n"
                + "|   |   |   C8 = T0\n"
                + "|   |   |   |   C11 = T0: C3 (1.0)\n"
                + "|   |   |   |   C11 = T3: C4 (2.0)\n"
                + "|   |   |   |   C11 = T2: C2 (2.0/1.0)\n"
                + "|   |   |   |   C11 = T1: C2 (2.0)\n"
                + "|   |   |   C8 = T1\n"
                + "|   |   |   |   C3 = N: C1 (14.0/7.0)\n"
                + "|   |   |   |   C3 = H: C3 (1.0)\n"
                + "|   |   |   |   C3 = L: C2 (2.0)\n"
                + "|   |   |   |   C3 = VH: C1 (0.0)\n"
                + "|   |   C9 = T3: C2 (7.0/2.0)\n"
                + "|   |   C9 = T0\n"
                + "|   |   |   C3 = N\n"
                + "|   |   |   |   C11 = T0\n"
                + "|   |   |   |   |   C0 = H: C0 (1.0)\n"
                + "|   |   |   |   |   C0 = L: C1 (4.0)\n"
                + "|   |   |   |   |   C0 = N\n"
                + "|   |   |   |   |   |   C6 = T2: C3 (4.0/1.0)\n"
                + "|   |   |   |   |   |   C6 = T0: C0 (3.0/1.0)\n"
                + "|   |   |   |   |   |   C6 = T1: C0 (0.0)\n"
                + "|   |   |   |   |   C0 = VL: C1 (0.0)\n"
                + "|   |   |   |   |   C0 = VH: C1 (0.0)\n"
                + "|   |   |   |   C11 = T3: C3 (1.0)\n"
                + "|   |   |   |   C11 = T2: C3 (3.0/1.0)\n"
                + "|   |   |   |   C11 = T1\n"
                + "|   |   |   |   |   C4 = L: C0 (2.0/1.0)\n"
                + "|   |   |   |   |   C4 = VL: C2 (2.0)\n"
                + "|   |   |   |   |   C4 = N: C2 (0.0)\n"
                + "|   |   |   |   |   C4 = VH: C2 (0.0)\n"
                + "|   |   |   C3 = H: C4 (1.0)\n"
                + "|   |   |   C3 = L: C0 (4.0/2.0)\n"
                + "|   |   |   C3 = VH: C1 (0.0)\n"
                + "|   |   C9 = T6: C3 (1.0)\n"
                + "|   |   C9 = T4\n"
                + "|   |   |   C0 = H: C2 (2.0/1.0)\n"
                + "|   |   |   C0 = L: C3 (0.0)\n"
                + "|   |   |   C0 = N: C3 (2.0)\n"
                + "|   |   |   C0 = VL: C3 (0.0)\n"
                + "|   |   |   C0 = VH: C3 (0.0)\n"
                + "|   |   C9 = T5: C3 (1.0)\n"
                + "|   C2 = T3\n"
                + "|   |   C9 = T2\n"
                + "|   |   |   C6 = T2: C2 (2.0/1.0)\n"
                + "|   |   |   C6 = T0: C3 (2.0)\n"
                + "|   |   |   C6 = T1: C3 (0.0)\n"
                + "|   |   C9 = T1\n"
                + "|   |   |   C8 = T0: C0 (5.0/1.0)\n"
                + "|   |   |   C8 = T1: C1 (2.0/1.0)\n"
                + "|   |   C9 = T3: C3 (1.0)\n"
                + "|   |   C9 = T0: C0 (10.0/3.0)\n"
                + "|   |   C9 = T6: C0 (0.0)\n"
                + "|   |   C9 = T4: C0 (0.0)\n"
                + "|   |   C9 = T5: C0 (0.0)\n"
                + "|   C2 = T2\n"
                + "|   |   C9 = T2: C0 (0.0)\n"
                + "|   |   C9 = T1: C1 (2.0/1.0)\n"
                + "|   |   C9 = T3: C0 (0.0)\n"
                + "|   |   C9 = T0: C0 (7.0/2.0)\n"
                + "|   |   C9 = T6: C0 (0.0)\n"
                + "|   |   C9 = T4: C0 (0.0)\n"
                + "|   |   C9 = T5: C0 (0.0)\n"
                + "C12 = T0: C0 (2.0/1.0)\n"
                + "";
        GrapTree gt = new GrapTree();
        gt.buildTree(str);
    }
}
