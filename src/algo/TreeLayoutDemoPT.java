package algo;

/*
 * Copyright (c) 2003, the JUNG Project and the Regents of the University of
 * California All rights reserved.
 * 
 * This software is open-source under the BSD license; see either "license.txt"
 * or http://jung.sourceforge.net/license.txt for a description.
 * 
 */
import AlgoID3.GrapTree;
import AlgoID3.ID3Algo;
import static AlgoID3.ID3Algo.train;
import edu.uci.ics.jung.algorithms.layout.PolarPoint;
import edu.uci.ics.jung.algorithms.layout.RadialTreeLayout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Tree;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.VisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.layout.LayoutTransition;
import edu.uci.ics.jung.visualization.util.Animator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ChainedTransformer;
import org.apache.commons.collections15.functors.ConstantTransformer;

/**
 * Demonsrates TreeLayout and RadialTreeLayout.
 *
 * @author Tom Nelson
 *
 */
@SuppressWarnings("serial")
public class TreeLayoutDemoPT extends JApplet {

    /**
     * the graph
     */
    Forest<String, String> graph;
    Factory<DirectedGraph<String, String>> graphFactory
            = new Factory<DirectedGraph<String, String>>() {

                public DirectedGraph<String, String> create() {
                    return new DirectedSparseMultigraph<String, String>();
                }
            };
    Factory<Tree<String, String>> treeFactory
            = new Factory<Tree<String, String>>() {

                public Tree<String, String> create() {
                    return new DelegateTree<String, String>(graphFactory);
                }
            };
    Factory<Integer> edgeFactory = new Factory<Integer>() {

        int i = 0;

        public Integer create() {
            return i++;
        }
    };
    Factory<String> vertexFactory = new Factory<String>() {

        int i = 0;

        public String create() {
            return "V" + i++;
        }
    };
    /**
     * the visual component and renderer for the graph
     */
    VisualizationViewer<String, String> vv;
    VisualizationServer.Paintable rings;
    String root;
    TreeLayout<String, String> treeLayout;
    RadialTreeLayout<String, String> radialLayout;
    GrapTree c = null;

    public TreeLayoutDemoPT(final GrapTree c) {
        this.c = c;
        // create a simple graph for the demo
        

//        c.train("iris.arff", 4);
//        
        graph = c.graph;
        treeLayout = new TreeLayout<String, String>(graph);
        radialLayout = new RadialTreeLayout<String, String>(graph);
        radialLayout.setSize(new Dimension(600, 600));
        vv = new VisualizationViewer<String, String>(treeLayout, new Dimension(600, 600));
        vv.setBackground(Color.white);
        vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        // add a listener for ToolTips
        vv.setVertexToolTipTransformer(new ToStringLabeller());
        vv.getRenderContext().setArrowFillPaintTransformer(new ConstantTransformer(Color.lightGray));
        vv.getRenderContext().setVertexLabelTransformer(
                // this chains together Transformers so that the html tags
                // are prepended to the toString method output
                new ChainedTransformer<String, String>(new Transformer[]{
                    new ToStringLabeller<String>(),
                    new Transformer<String, String>() {

                        public String transform(String input) {
                            return (String) c.gname.get(input);
                        }
                    }}));

        rings = new Rings();

        Container content = getContentPane();
        final GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
        content.add(panel);

        final DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();

        vv.setGraphMouse(graphMouse);

        JComboBox modeBox = graphMouse.getModeComboBox();
        modeBox.addItemListener(graphMouse.getModeListener());
        graphMouse.setMode(ModalGraphMouse.Mode.TRANSFORMING);

        final ScalingControl scaler = new CrossoverScalingControl();

        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                scaler.scale(vv, 1.1f, vv.getCenter());
            }
        });
        JButton minus = new JButton("-");
        minus.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                scaler.scale(vv, 1 / 1.1f, vv.getCenter());
            }
        });

        JToggleButton radial = new JToggleButton("Radial");
        radial.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    LayoutTransition<String, String> lt
                            = new LayoutTransition<String, String>(vv, treeLayout, radialLayout);
                    Animator animator = new Animator(lt);
                    animator.start();
                    vv.getRenderContext().getMultiLayerTransformer().setToIdentity();
                    vv.addPreRenderPaintable(rings);
                } else {
                    LayoutTransition<String, String> lt
                            = new LayoutTransition<String, String>(vv, radialLayout, treeLayout);
                    Animator animator = new Animator(lt);
                    animator.start();
                    vv.getRenderContext().getMultiLayerTransformer().setToIdentity();
                    vv.removePreRenderPaintable(rings);
                }
                vv.repaint();
            }
        });

        JPanel scaleGrid = new JPanel(new GridLayout(1, 0));
        scaleGrid.setBorder(BorderFactory.createTitledBorder("Zoom"));

        JPanel controls = new JPanel();
        scaleGrid.add(plus);
        scaleGrid.add(minus);
        controls.add(radial);
        controls.add(scaleGrid);
        controls.add(modeBox);

        content.add(controls, BorderLayout.SOUTH);
    }

    class Rings implements VisualizationServer.Paintable {

        Collection<Double> depths;

        public Rings() {
            depths = getDepths();
        }

        private Collection<Double> getDepths() {
            Set<Double> depths = new HashSet<Double>();
            Map<String, PolarPoint> polarLocations = radialLayout.getPolarLocations();
            for (String v : graph.getVertices()) {
                PolarPoint pp = polarLocations.get(v);
                depths.add(pp.getRadius());
            }
            return depths;
        }

        public void paint(Graphics g) {
            g.setColor(Color.lightGray);

            Graphics2D g2d = (Graphics2D) g;
            Point2D center = radialLayout.getCenter();

            Ellipse2D ellipse = new Ellipse2D.Double();
            for (double d : depths) {
                ellipse.setFrameFromDiagonal(center.getX() - d, center.getY() - d,
                        center.getX() + d, center.getY() + d);
                Shape shape = vv.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.LAYOUT).transform(ellipse);
                g2d.draw(shape);
            }
        }

        public boolean useTransform() {
            return true;
        }
    }

    /**
     * a driver for this demo
     */
    public static void main(String[] args) {
        ID3Algo.train("processed.cleveland.data", 13);
       GrapTree c = new GrapTree();
        c.buildTree(ID3Algo.datastr);
        JInternalFrame frame = new JInternalFrame();
        Container content = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        content.add(new TreeLayoutDemoPT(c));
        frame.pack();
        frame.setVisible(true);
    }
}
