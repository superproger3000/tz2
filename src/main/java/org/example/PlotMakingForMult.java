package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import javax.swing.*;

public class PlotMakingForMult {
    public static void main(String[] args) {
        int[] fileSizes = {10, 100, 1000, 10000, 100000, 1000000};
        long[] executionTimes = new long[fileSizes.length];

        for (int i = 0; i < fileSizes.length; i++) {
            try {
                int size = fileSizes[i];
                PrintWriter writer = new PrintWriter(new File("input" + size + ".txt"));
                Random random = new Random();
                for (int j = 0; j < size; j++) {
                    writer.println(random.nextInt(10000));
                }
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < fileSizes.length; i++) {
            int size = fileSizes[i];
            long startTime = System.currentTimeMillis();
            NumberProcessor.mult(NumberProcessor.readNumbersFromFile("input" + size + ".txt"));
            long endTime = System.currentTimeMillis();
            executionTimes[i] = endTime - startTime;
        }
        XYSeries series = new XYSeries("Время выполнения");
        for (int i = 0; i < executionTimes.length; i++) {
            series.add(fileSizes[i], executionTimes[i]);
        }
        XYDataset dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "График зависимости времени от количества чисел",
                "Количество чисел",
                "Время выполнения (мс)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 500));
        JFrame frame = new JFrame("График зависимости времени от количества чисел");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(chartPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
