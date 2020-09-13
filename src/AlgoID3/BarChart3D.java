package AlgoID3;

import java.util.ArrayList;
import javax.swing.JDialog;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart3D extends JDialog {

    public BarChart3D(final String title, ArrayList xval, ArrayList yval,String series) {


        final CategoryDataset dataset = createDataset(xval, yval, series);
        final JFreeChart chart = createChart(dataset);

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        pack();

    }

    private CategoryDataset createDataset(ArrayList xval, ArrayList yval, String series) {

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < xval.size(); i++) {

            dataset.addValue((Double) yval.get(i), series, xval.get(i).toString());


        }

        return dataset;

    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createBarChart3D(
                "3D Bar Chart ", // chart title
                "Category", // domain axis label
                "Patient", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
                );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0));
        final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        return chart;

    }

    public static void main(final String[] args) {
        //al.add(20,30);
        //BarChart3D obj = new BarChart3D("bar", al, "xy");
        //obj.show();

    }
}
