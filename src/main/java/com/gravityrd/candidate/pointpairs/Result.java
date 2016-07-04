package com.gravityrd.candidate.pointpairs;

/**
 * Contains the result of a calculation: a pair of points 
 *  and their distance.
 */
public class Result {
    
    private Point  p1, p2;
    private double delta;

    public Result(Point p1, Point p2, double delta) {
        this.p1 = p1;
        this.p2 = p2;
        this.delta = delta;
    }
    
    public Result(Point p1, Point p2) {
        this(p1, p2, p1.distance(p2));
    }
    
    /**
     * @return true iff the two Results refer to the same line numbers.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Result)) {
            return false;
        }
        return (p1.getIndex()==((Result)obj).p1.getIndex()
             && p2.getIndex()==((Result)obj).p2.getIndex());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(p1);
        sb.append('\n');
        sb.append(p2);
        return sb.toString();
    }
    
    public int getNp1() {
        return p1.getIndex();
    }
    
    public int getNp2() {
        return p2.getIndex();
    }
    
    public Point getP1() {
        return p1;
    }
    
    public Point getP2() {
        return p2;
    }
    
    public double getDelta() {
        return delta;
    }

}
