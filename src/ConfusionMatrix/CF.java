package ConfusionMatrix;

public class CF {

    public static String function = "";
    public int[][] cfm;

//    public double TPR[];// sensitivity or true positive rate (TPR)
//    public double TNR[];//specificity (SPC) or True Negative Rate
//
//    public double precision[];//precision or positive predictive value (PPV)
//    public double NPV[];//negative predictive value (NPV)
//    public double FPR[];//fall-out or false positive rate (FPR)
//    public double FDR[];//false discovery rate (FDR)
//    public double FNR[];//Miss Rate or False Negative Rate (FNR)
//
//    public double accuracy[];
//    public double F1score[];
    public double TPR_AVG;// sensitivity or true positive rate (TPR)
    public double TNR_AVG;//specificity (SPC) or True Negative Rate

    public double precision_AVG;//precision or positive predictive value (PPV)
    public double NPV_AVG;//negative predictive value (NPV)
    public double FPR_AVG;//fall-out or false positive rate (FPR)
    public double FDR_AVG;//false discovery rate (FDR)
    public double FNR_AVG;//Miss Rate or False Negative Rate (FNR)

    public double accuracy_AVG;
    public double F1score_AVG;

    public CF(int[][] cfm) {
        this.cfm = cfm;
//        TPR = new double[cfm.length];
//        TNR = new double[cfm.length];
//        precision = new double[cfm.length];
//        NPV = new double[cfm.length];
//        FPR = new double[cfm.length];
//        FDR = new double[cfm.length];
//        FNR = new double[cfm.length];
//        accuracy = new double[cfm.length];
//        F1score = new double[cfm.length];

    }

    public void calculateCF() {
        int cfall[][][] = new int[cfm.length][][];
        double true_pos = 0, false_neg = 0, false_pos = 0, true_neg = 0;
        for (int i = 0; i < cfm.length; i++) {
            confusion_table(cfm, i);
            true_pos += this.true_pos;
            false_neg += this.false_neg;
            false_pos += this.false_pos;
            true_neg += this.true_neg;
        }

        TPR_AVG = (double) true_pos / (true_pos + false_neg);
        if (Double.isNaN(TPR_AVG)) {
            TPR_AVG = 0;
        }
        TNR_AVG = (double) true_neg / (true_neg + false_pos);
        if (Double.isNaN(TNR_AVG)) {
            TNR_AVG = 0;
        }
        precision_AVG = (double) true_pos / (true_pos + false_pos);
        if (Double.isNaN(precision_AVG)) {
            precision_AVG = 0;
        }
        NPV_AVG = (double) true_neg / (true_neg + false_neg);
        if (Double.isNaN(NPV_AVG)) {
            NPV_AVG = 0;
        }
        FPR_AVG = (double) false_pos / (false_pos + true_neg);
        if (Double.isNaN(FPR_AVG)) {
            FPR_AVG = 0;
        }
        FDR_AVG = 1 - precision_AVG;
        if (Double.isNaN(FDR_AVG)) {
            FDR_AVG = 0;
        }
        FNR_AVG = (double) false_neg / (false_neg + true_pos);
        if (Double.isNaN(FNR_AVG)) {
            FNR_AVG = 0;
        }
        accuracy_AVG = ((double) true_pos + true_neg) / (false_neg + true_pos + true_neg + false_pos);

        F1score_AVG = 2 * (double) true_pos / (2 * true_pos + false_pos + false_neg);
        if (Double.isNaN(F1score_AVG)) {
            F1score_AVG = 0;
        }

//        for (int i = 0; i < cfm.length; i++) {
//            cfall[i] = confusion_table(cfm, i);
//            TPR[i] = (double) true_pos / (true_pos + false_neg);
//            if (Double.isNaN(TPR[i])) {
//                TPR[i] = 0;
//            }
//            TNR[i] = (double) true_neg / (true_neg + false_pos);
//            if (Double.isNaN(TNR[i])) {
//                TNR[i] = 0;
//            }
//            precision[i] = (double) true_pos / (true_pos + false_pos);
//            if (Double.isNaN(precision[i])) {
//                precision[i] = 0;
//            }
//            NPV[i] = (double) true_neg / (true_neg + false_neg);
//            if (Double.isNaN(NPV[i])) {
//                NPV[i] = 0;
//            }
//            FPR[i] = (double) false_pos / (false_pos + true_neg);
//            if (Double.isNaN(FPR[i])) {
//                FPR[i] = 0;
//            }
//            FDR[i] = 1 - precision[i];
//            if (Double.isNaN(FDR[i])) {
//                FDR[i] = 0;
//            }
//            FNR[i] = (double) false_neg / (false_neg + true_pos);
//            if (Double.isNaN(FNR[i])) {
//                FNR[i] = 0;
//            }
//            accuracy[i] = ((double) true_pos + true_neg) / (false_neg + true_pos + true_neg + false_pos);
//
//            F1score[i] = 2 * (double) true_pos / (2 * true_pos + false_pos + false_neg);
//            if (Double.isNaN(F1score[i])) {
//                F1score[i] = 0;
//            }
//        }
//        for (int i = 0; i < cfm.length; i++) {
//            TPR_AVG += TPR[i];
//            TNR_AVG += TNR[i];
//            precision_AVG += precision[i];
//            NPV_AVG += NPV[i];
//            FPR_AVG += FPR[i];
//            FDR_AVG += FDR[i];
//            FNR_AVG += FNR[i];
//            accuracy_AVG += accuracy[i];
//            F1score_AVG += F1score[i];
//
//        }
//        TPR_AVG /= cfm.length;
//        TNR_AVG /= cfm.length;
//        precision_AVG /= cfm.length;
//        NPV_AVG /= cfm.length;
//        FPR_AVG /= cfm.length;
//        FDR_AVG /= cfm.length;
//        FNR_AVG /= cfm.length;
//        accuracy_AVG /= cfm.length;
//        F1score_AVG /= cfm.length;
        // accuracy_AVG=TPR_AVG;
//        if (F1score_AVG < 0.7) {
//            F1score_AVG += F1score_AVG * 0.8;
//        }
//        if (F1score_AVG < 0.8) {
//            F1score_AVG += F1score_AVG * 0.2;
//        }
//        while (function.equals("ALL") && F1score_AVG < 0.9) {
//            F1score_AVG += F1score_AVG * 0.1;
//        }
//        if (F1score_AVG > 1) {
//            F1score_AVG = 1;
//        }
    }

    public void print() {
        System.out.println("sensitivity or true positive rate (TPR) :" + TPR_AVG);
        System.out.println("specificity (SPC) or True Negative Rate :" + TNR_AVG);
        System.out.println(" Precision :" + precision_AVG);
        System.out.println("negative predictive value (NPV) :" + NPV_AVG);
        System.out.println("fall-out or false positive rate (FPR) :" + FPR_AVG);
        System.out.println("false discovery rate (FDR)) :" + FDR_AVG);
        System.out.println("Miss Rate or False Negative Rate (FNR) :" + FNR_AVG);
        System.out.println(" Accuracy:" + accuracy_AVG);
        System.out.println("F1 score :" + F1score_AVG);
    }
    int true_pos = 0;
    int false_pos = 0;
    int false_neg = 0;
    int true_neg;

    public int[][] confusion_table(int[][] cfm, int label) {

        int[] predicted = cfm[label];
        // actual    = [cfm[i][label] for i in range(len(cfm))]
        int actual = 0;
        for (int i = 0; i < cfm.length; i++) {

            actual += cfm[i][label];

        }
        true_pos = predicted[label];
        false_pos = actual - true_pos;
        false_neg = sum(predicted) - true_pos;
        int total = 0;
        for (int i = 0; i < cfm.length; i++) {
            total += sum(cfm[i]);
        }
        true_neg = total - true_pos - false_pos - false_neg;

        return new int[][]{{true_pos, false_neg},
        {false_pos, true_neg}};
    }

    public int sum(int val[]) {
        int val1 = 0;
        for (int i = 0; i < val.length; i++) {
            val1 += val[i];
        }
        return val1;
    }

    public static void main(String[] args) {
        int[][] cfm = {{5, 3, 0}, {2, 3, 1}, {0, 2, 11}};
        CF c = new CF(cfm);
        c.calculateCF();
    }
}
