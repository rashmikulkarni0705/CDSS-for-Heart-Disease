/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoID3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import weka.core.*;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;

/**
 * Shows how to generate compatible train/test sets using the Discretize filter.
 *
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class DiscretizeTest {

    protected static Instances load(String filename) throws Exception {

     

        CSVLoader dv = new CSVLoader();
        dv.setSource(new File(filename));
        Instances result = dv.getDataSet();
//        reader = new BufferedReader(new FileReader(filename));
//        result = new Instances(reader);
        result.setClassIndex(result.numAttributes() - 1);
 

        return result;
    }

    protected static void save(Instances data, String filename) throws Exception {
        BufferedWriter writer;

        writer = new BufferedWriter(new FileWriter(filename));
        writer.write(data.toString());
        writer.newLine();
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        Instances inputTrain;
        Instances inputTest;
        Instances outputTrain;
        Instances outputTest;
        Discretize filter;

        // load data (class attribute is assumed to be last attribute)
        inputTrain = load("processed.cleveland.data");
       // inputTest = load(args[1]);

        // setup filter
        filter = new Discretize();
        filter.setInputFormat(inputTrain);

        // apply filter
        outputTrain = Filter.useFilter(inputTrain, filter);
     //   outputTest = Filter.useFilter(inputTest, filter);

        // save output
        save(outputTrain, "ids.txt");
        //     save(outputTest, args[3]);
    }
}
