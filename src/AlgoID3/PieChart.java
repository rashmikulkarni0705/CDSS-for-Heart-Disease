package AlgoID3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JDialog;

import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import org.jfree.util.Rotation;

public class PieChart extends JDialog {

    public PieChart(final String title, ArrayList xval, ArrayList yval) {
        String chartData = "";
        StringTokenizer st1 = null;
        // create a dataset...

        final DefaultPieDataset data = new DefaultPieDataset();


        for (int i = 0; i < xval.size(); i++) {

            data.setValue(xval.get(i).toString(), (Double) yval.get(i));

        }

        // create the chart...
        final JFreeChart chart = ChartFactory.createPieChart3D(
                title, // chart title
                data, // data
                true, // include legend
                true,
                false);

        chart.setBackgroundPaint(Color.yellow);
        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.ANTICLOCKWISE);

        plot.setForegroundAlpha(0.5f);
        // plot.setInteriorGap(0.33);
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

        final Rotator rotator = new Rotator(plot);
        rotator.start();
        pack();

    }

    public static void main(final String[] args) {
        //al.add(20,30);
    }
}

class Rotator extends Timer implements ActionListener {

    /** The plot. */
    private PiePlot3D plot;
    /** The angle. */
    private int angle = 270;

    Rotator(final PiePlot3D plot) {
        super(100, null);
        this.plot = plot;
        addActionListener(this);
    }

    public void actionPerformed(final ActionEvent event) {
        this.plot.setStartAngle(this.angle);
        this.angle = this.angle + 1;
        if (this.angle == 360) {
            this.angle = 0;
        }
    }
}
