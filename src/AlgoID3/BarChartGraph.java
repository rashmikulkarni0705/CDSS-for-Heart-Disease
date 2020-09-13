package AlgoID3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFrame;

import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.ui.RefineryUtilities;

public class BarChartGraph extends JFrame {

    String title = "";
    public String yaxislabel = "";
    public String xaxislable = "";

    public BarChartGraph(String title, String yaxislabel,
            String xaxislable, ArrayList al, ArrayList series,
            ArrayList xlable) {

        super(title);
        this.title = title;
        this.yaxislabel = yaxislabel;
        this.xaxislable = xaxislable;

        final CategoryDataset dataset = createDataset(al, series, xlable);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
        pack();

    }

    /**
     * Creates a sample dataset.
     *
     * @return The dataset.
     */
    private CategoryDataset createDataset(ArrayList al, ArrayList series, ArrayList xlable) {

        // r
        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < al.size(); i++) {
            ArrayList al1 = (ArrayList) al.get(i);
            for (int j = 0; j < al1.size(); j++) {
                dataset.addValue((Double) al1.get(j), (String) xlable.get(i), (String) series.get(j));
            }
        }

        return dataset;

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset a dataset.
     *
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart3D(
                title, // chart title
                // domain axis label
                xaxislable, // range axis label
                yaxislabel,
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
//        final StandardLegend legend = (StandardLegend) chart.getLegend();
        //      legend.setDisplaySeriesShapes(true);
        //    legend.setShapeScaleX(1.5);
        //  legend.setShapeScaleY(1.5);
        //legend.setDisplaySeriesLines(true);
        chart.setBackgroundPaint(Color.white);
//
//        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
//        plot.setBackgroundPaint(Color.lightGray);
//        plot.setRangeGridlinePaint(Color.white);
//
//        // customise the range axis...
//        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        //rangeAxis.setTickUnit(new Numb);
//        rangeAxis.setAutoRangeIncludesZero(true);

        // ****************************************************************************
        // * JFREECHART DEVELOPER GUIDE                                               *
        // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
        // * to purchase from Object Refinery Limited:                                *
        // *                                                                          *
        // * http://www.object-refinery.com/jfreechart/guide.html                     *
        // *                                                                          *
        // * Sales are used to provide funding for the JFreeChart project - please    *
        // * support us so that we can continue developing free software.             *
        // ****************************************************************************
        // customise the renderer...
//        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
////        renderer.setDrawShapes(true);
//
//        renderer.setSeriesStroke(
//                0, new BasicStroke(
//                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
//                        1.0f, new float[]{10.0f, 6.0f}, 0.0f));
//        renderer.setSeriesStroke(
//                1, new BasicStroke(
//                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
//                        1.0f, new float[]{6.0f, 6.0f}, 0.0f));
//        renderer.setSeriesStroke(
//                2, new BasicStroke(
//                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
//                        1.0f, new float[]{2.0f, 6.0f}, 0.0f));
        // axis.setTickUnit(new NumberTickUnit(67);
        // OPTIONAL CUSTOMISATION COMPLETED.
        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0));
        final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        return chart;
     
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(final String[] args) {
        ArrayList xtable = new ArrayList();

        ArrayList series = new ArrayList();

        ArrayList<ArrayList> al = new ArrayList();

        try {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream("test.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                StringTokenizer st = new StringTokenizer(strLine, ",");
                String keyword = "";
                String pre = "";
                String xseris = "";
                if (st.countTokens() >= 3) {
                    xseris = st.nextToken();
                    pre = st.nextToken();
                    keyword = st.nextToken();
                    if (xtable.indexOf(keyword) == -1) {
                        xtable.add(keyword);
                    }
                    if (series.indexOf(xseris) == -1) {
                        series.add(xseris);
                    }
                    if (xtable.indexOf(keyword) >= al.size()) {
                        al.add(new ArrayList());
                    }
                    al.get(xtable.indexOf(keyword)).add(new Double(pre));
                }
                System.out.println(strLine);
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        BarChartGraph demo = new BarChartGraph("Accurecy", "Dimension", "%", al, series, xtable);

        demo.pack();

        demo.setVisible(
                true);
        //    new BarChartGraph("a", null, args, args).show();
    }
}
