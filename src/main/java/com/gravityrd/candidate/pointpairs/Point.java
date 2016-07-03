package com.gravityrd.candidate.pointpairs;

import java.util.stream.IntStream;

/**
 * Represents a d-dimensional point.
 */
public class Point {
    
    private final int index;
    private final double[] coords;
    
    public Point(int index, double[] coords) {
        this.index = index;
        this.coords = coords;
    }
    
    public int getDimension() {
        return coords.length;
    }
    
    /**
     * @return the line number of the point in the input file
     */
    public int getIndex() {
        return index;
    }
    
    /**
     * @return the Euclidean distance of the two points
     */
    public double distance(Point other) {
        double sum = IntStream.range(0, coords.length)
            .mapToDouble(i -> this.coords[i] - other.coords[i])
            .map(dif -> dif * dif)
            .reduce(0, Double::sum);
        return Math.sqrt(sum);

    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double coord : coords) {
            sb.append(coord);
            sb.append('\t');
        }
        return sb.toString();
    }
}
