package com.gravityrd.candidate.pointpairs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class PointPairsMinDist {

    public static void main(String[] args) {
        ArrayList<Point> points = readPointsFromFile("points.tsv");
        MinDistCalculator calc = new NaiveMinDistCalculator();
        calc.init(points);
        System.out.println(calc.getMinDistPair());
    }

    static ArrayList<Point> readPointsFromFile(String fileName) {
        ArrayList<Point> points = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                PointPairsMinDist.class.getClassLoader()
                .getResourceAsStream(fileName)));
        AtomicInteger index = new AtomicInteger(0);
        reader.lines().map(line -> Stream.of(line.split("\t")))
                .map(s -> s.mapToDouble(Double::valueOf))
                .map(s -> s.toArray())
                .forEachOrdered(coords -> points.add(
                new Point(index.incrementAndGet(), coords)));
        System.err.format("%d lines read\n", index.get()); //FIXME debug
        return points;
    }

}
