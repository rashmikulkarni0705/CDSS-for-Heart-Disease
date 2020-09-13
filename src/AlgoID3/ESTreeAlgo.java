package AlgoID3;

 
import static AlgoID3.ID3Algo.data;
import static AlgoID3.ID3Algo.dmax;
import static AlgoID3.ID3Algo.flag;
import static AlgoID3.ID3Algo.nbc;
import static AlgoID3.ID3Algo.testInst;
import static AlgoID3.ID3Algo.type;
import ConfusionMatrix.CF;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import tutorials.TutorialData;
import weka.classifiers.Classifier;
import weka.classifiers.trees.ExtendedSubtree;
 
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

public class ESTreeAlgo {

    public static Classifier nbc = null;
    public static boolean flag[];
    public static double dmax[];
    public static String type[] = new String[]{"VL", "L", "N", "H", "VH"};

    public static void convertRange(String file) {
        try {
            CSVLoader dv = new CSVLoader();
            dv.setSource(new File(file));
            Instances data = dv.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);
            dmax = new double[data.numAttributes() - 1];

            for (int i = 0; i < data.numAttributes() - 1; i++) {
                for (int j = 0; j < data.numInstances(); j++) {
                    if (dmax[i] < data.instance(j).value(i)) {
                        dmax[i] = data.instance(j).value(i);
                    }
                }
            }
            flag = new boolean[data.numAttributes() - 1];
            for (int i = 0; i < data.numAttributes() - 1; i++) {
                if (dmax[i] > 10) {
                    dmax[i] = dmax[i] / 5;
                    flag[i] = true;
                }
            }

            FileWriter fr = new FileWriter("id3.csv");
            for (int i = 0; i < data.numInstances(); i++) {
                if (i == 0) {
                    for (int j = 0; j < data.numAttributes(); j++) {
                        if (j < data.numAttributes() - 1) {
                            fr.write("C" + j + ",");
                        } else {
                            fr.write("C" + j + "\n");
                        }
                    }
                }
                System.out.print("\n" + (i + 1) + ":");
                for (int j = 0; j < data.numAttributes() - 1; j++) {
                    if (!flag[j]) {
                        fr.write("T" + (int) data.instance(i).value(j) + ",");
                    } else {

                        fr.write(type[(int) (data.instance(i).value(j) / dmax[j]) - 1] + ",");
                    }
                    System.out.print(data.instance(i).value(j) + ",");

                }
                System.out.print(((int) data.instance(i).classValue()) + ",");
                //  62.0,0.0,4.0,140.0,268.0,0.0,2.0,160.0,0.0,3.6,3.0,2.0,3.0,
                fr.write("L" + ((int) data.instance(i).classValue()) + "\n");
            }
            fr.close();
        } catch (Exception ex) {
            Logger.getLogger(ESTreeAlgo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String datastr = "";
    public static Instances data = null;
    public static int[][] cfm;

    public static void train(String file, int classindex) {
        try {
            convertRange(file);
            file = "id3.csv";
            CSVLoader dv = new CSVLoader();
            dv.setSource(new File(file));
            data = dv.getDataSet();
            System.out.println(data.numAttributes());
            data.setClassIndex(data.numAttributes() - 1);
            //  Dataset data = FileHandler.loadDataset(new File(file), classindex, ",");
            //data.classValue
//            for (int i = 0; i < data.numInstances(); i++) {
//                System.out.println(data.instance(i));
//            }

            try {
                nbc = new ExtendedSubtree();

                nbc.buildClassifier(data);//Classifier(data);

                datastr = nbc.toString();
                datastr = datastr.substring(datastr.indexOf("RandomTree"));
                datastr = datastr.replaceAll("RandomTree", "ExtendedSubtree");
                //     System.out.println(nbc.toString());

            } catch (Exception ex) {
                Logger.getLogger(ESTreeAlgo.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    public static String testInst(double values[]) {
//        FileWriter fr = null;
//        try {
//            fr = new FileWriter(new File("test.txt"));
//            for (int i = 0; i < values.length ; i++) {
//                fr.write("C" + i + ",");
//            }
//            fr.write("13\n");
//            for (int i = 0; i < values.length; i++) {
//                if (!flag[i]) {
//                    fr.write("T" + (int) values[i]);
//                } else {
//                    fr.write(type[(int) (values[i] / dmax[i]) - 1]);
//                }
//                //if (values.length - 1 != i) {
//                    fr.write(",");
//               // }
//            }
//               fr.write("L3\n");
//            fr.close();
//
//            CSVLoader dv = new CSVLoader();
//            dv.setSource(new File("test.txt"));
//            Instances data = dv.getDataSet();
//            data.setClassIndex(data.numAttributes() - 1);
//
//            Object predictedClassValue = null;
//            try {
//                System.out.println(data.instance(0));
//                predictedClassValue = nbc.classifyInstance(data.instance(0));
//                System.out.println(predictedClassValue);
//            } catch (Exception ex) {
//                Logger.getLogger(ESTreeAlgo.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return ESTreeAlgo.data.classAttribute().value((int) Double.parseDouble(predictedClassValue.toString()));
//        } catch (IOException ex) {
//            Logger.getLogger(ESTreeAlgo.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                fr.close();
//            } catch (IOException ex) {
//                Logger.getLogger(ESTreeAlgo.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return "";
//    }
    
    public static String testInst(double values[]) {
    //    FileWriter fr = null;
        try {
//             fr.write("13\n");
            String[] val = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                if (!flag[i]) {
                    val[i] = "T" + String.valueOf((int) values[i]);
                    //  fr.write("T" + (int) values[i]);
                } else {
                    val[i] = type[(int) (values[i] / dmax[i]) - 1];
                    //  fr.write(type[(int) (values[i] / dmax[i]) - 1]);
                }
             }
           for (int i = 0; i < values.length; i++) {
                data.instance(0).setValue(i, val[i]);
            }
            Object predictedClassValue = null;
            try {
      //          System.out.println(data.instance(0));
                predictedClassValue = nbc.classifyInstance(data.instance(0));
        //        System.out.println(predictedClassValue);
            } catch (Exception ex) {
                Logger.getLogger(ID3Algo.class.getName()).log(Level.SEVERE, null, ex);
            }
            return ESTreeAlgo.data.classAttribute().value((int) Double.parseDouble(predictedClassValue.toString()));
        } catch (Exception ex) {
            Logger.getLogger(ID3Algo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
        }
        return "";
    }
 public static int correct = 0, wrong = 0;
    public static CF cf;
   public static void testfile() {
        try {
            CSVLoader dv = new CSVLoader();
            dv.setSource(new File("processed.cleveland.data"));
            Instances data = dv.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);
            for (int i = 0; i < data.numInstances(); i++) {
                double d[] = new double[13];
                for (int j = 0; j < data.numAttributes() - 1; j++) {
                    d[j] = data.instance(i).value(j);
                }
                System.out.println((i + 1) + ":" + data.instance(i) + ":" + testInst(d)
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(ID3Algo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void test(String file, int classindex) {
        try {
            CSVLoader dv = new CSVLoader();
            dv.setSource(new File(file));
            Instances data = dv.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);

            /* Counters for correct and wrong predictions. */
            correct = 0;
            wrong = 0;
            ArrayList<Integer> al1 = new ArrayList();
            for (int i = 0; i < data.numInstances(); i++) {
                Instance inst = data.instance(i);
                int realClassValue = (int) inst.classValue();
                if (al1.indexOf(realClassValue) == -1) {
                    al1.add(realClassValue);
                }
            }
            cfm = new int[al1.size()][al1.size()];

//new Instance ()
            /* Classify all instances and check with the correct class values */
            for (int i = 0; i < data.numInstances(); i++) {
                //eb.filter(inst);

                Instance inst = data.instance(i);
                Object predictedClassValue = nbc.classifyInstance(inst);
                Object realClassValue = inst.classValue();
                System.out.println((i + 1) + ":" + inst + ":" + predictedClassValue + ":"
                        + data.classAttribute().value((int) Double.parseDouble(realClassValue.toString()))
                );
                int realclass = (int) inst.classValue();
                int predictclass = (int) nbc.classifyInstance(inst);
                cfm[realclass][predictclass] += 1;

                System.out.println();
                if (predictedClassValue.equals(realClassValue)) {
                    correct++;
                } else {
                    wrong++;

                }

            }
            cf = new CF(cfm);
            cf.calculateCF();
            cf.accuracy_AVG = ((correct) / (double) (correct + wrong) * 100);
            cf.print();
//            System.out.println("correct " + correct);
//            System.out.println("incorrect " + wrong);
//            System.out.println("Accurecy :" + ((correct) / (double) (correct + wrong) * 100) + "%");
        } catch (Exception ex) {
            ex.printStackTrace();
            //Logger.getLogger(InstencelNaiveBayes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public static void main(String[] args) throws Exception {

//         CSVLoader dv = new CSVLoader();
//            dv.setSource(new File("test.txt"));
//            Instances data = dv.getDataSet();
//            data.setClassIndex(data.numAttributes() - 1);
        train("processed.cleveland.data", 13);
        test("id3.csv", 13);
        testfile();
        //  System.out.println(testInst(new double[]{62.0, 0.0, 4.0, 140.0, 268.0, 0.0, 2.0, 160.0, 0.0, 3.6, 3.0, 2.0, 3.0}));
//        /* Load a data set */
//        Dataset data = FileHandler.loadDataset(new File("db.csv"), 8, ",");
//        /* Discretize through EqualWidtBinning */
////		EqualWidthBinning eb = new EqualWidthBinning(20);
////		System.out.println("Start discretisation");
////		eb.build(data);
////		Dataset ddata = data.copy();
////		eb.filter(ddata);
//
//        boolean useLaplace = true;
//        boolean useLogs = true;
//        Classifier nbc = new NaiveBayesClassifier(useLaplace, useLogs, false);
//        nbc.buildClassifier(data);
//
//        Dataset dataForClassification = FileHandler.loadDataset(new File("db.csv"), 8, ",");
//
//        /* Counters for correct and wrong predictions. */
//        int correct = 0, wrong = 0;
//
//        /* Classify all instances and check with the correct class values */
//        for (Instance inst : dataForClassification) {
//            //eb.filter(inst);
//            Object predictedClassValue = nbc.classify(inst);
//            Object realClassValue = inst.classValue();
//            if (predictedClassValue.equals(realClassValue)) {
//                correct++;
//            } else {
//                wrong++;
//
//            }
//
//        }
//        System.out.println("correct " + correct);
//        System.out.println("incorrect " + wrong);

    }
}
