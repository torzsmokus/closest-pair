package com.gravityrd.candidate.pointpairs;

/**
 * Represents a d-dimensional point.
 */
public class Point {
    
    private double[] coords;
    
    public Point(double[] coords) {
        this.coords = coords;
    }
    
    public int getDimension() {
        return coords.length;
    }
    
    public double distance(Point other) {
        double sum = 0;
        for (int i=0; i<getDimension(); i++) {
            sum += (this.coords[i] - other.coords[i]);
        }
        return Math.pow(sum, 1/getDimension());
    }
}
