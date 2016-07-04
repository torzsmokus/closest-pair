/*
 * MinDistCalculator.java
 * 1.1-SNAPSHOT
 * 
 */

package com.gravityrd.candidate.pointpairs;

import java.util.List;

/**
 * Base class for closest pair calculators
 */
public abstract class MinDistCalculator {
    
    protected List<Point> points;
    protected int dim;
    
    protected void init(List<Point> points) {
        if (points.size() < 2) {
            throw new IllegalArgumentException("too few points");
        }
        dim = points.get(0).getDimension();
        for (Point p : points) {
            if (p.getDimension() != dim) {
                throw new IllegalArgumentException("dimension mismatch");
            }
        }
        this.points = points;
    }
        
    /**
     * @returns a Result containing the closest Point pair and their distance
     */
    public abstract Result getMinDistPair();
    
}
