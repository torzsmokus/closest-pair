package com.gravityrd.candidate.pointpairs;

import java.util.ArrayList;
import java.util.Scanner;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the PointPairsMinDist App.
 */
public class PointPairsMinDistTest extends TestCase {

    public PointPairsMinDistTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(PointPairsMinDistTest.class);
    }

    /**
     * Kinda integration test
     */
    public void testNaive() {
            MinDistCalculator calcNaive = new NaiveMinDistCalculator();
            runCalculation(calcNaive);
    }

    public void testDNC() {
            MinDistCalculator calcDNC= new DivNConqMinDistCalculator();
//            runCalculation(calcDNC);
    }
    
    private void runCalculation(MinDistCalculator calc) {
        String[] testfiles = new String[] {
                    "2_8", "4_4", "3_1000", "10_100", "100_100"};
        for (String testfile : testfiles) {
            System.err.println(testfile);
            ArrayList<Point> points = PointPairsMinDist
                    .readPointsFromFile("sample_input_" + testfile + ".tsv");
            calc.init(points);
            Result res = calc.getMinDistPair();
            
            try (Scanner sc = new Scanner(
                    PointPairsMinDistTest.class.getClassLoader() 
                    .getResourceAsStream("sample_output_" + testfile + ".txt")
                    )) {
                int np1 = Integer.valueOf(sc.findInLine("\\d+"));
                sc.nextLine();
                int np2 = Integer.valueOf(sc.findInLine("\\d+"));
                assertEquals(res.getNp1(), np1);
                assertEquals(res.getNp2(), np2);
            }

        }
    }
}
