package com.gravityrd.candidate.pointpairs;

/**
 * Contains the result of a calculation: a pair of points with line numbers
 *  and their distance.
 */
public class Result {
    
    private int    np1, np2;
    private Point  p1, p2;
    private double delta;

    public Result(int np1, Point p1, int np2, Point p2, double delta) {
        this.np1 = np1;
        this.p1 = p1;
        this.np2 = np2;
        this.p2 = p2;
        this.delta = delta;
    }
    
    public Result(int np1, Point p1, int np2, Point p2) {
        this(np1, p1, np2, p2, p1.distance(p2));
    }
    
    /**
     * @return true iff the two Results refer to the same line numbers.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Result)) {
            return false;
        }
        return (np1==((Result)obj).np1 && np2==((Result)obj).np2);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(np1);
        sb.append(':');
        sb.append(p1);
        sb.append('\n');
        sb.append(np2);
        sb.append(':');
        sb.append(p2);
        return sb.toString();
    }
    
    public int getNp1() {
        return np1;
    }
    
    public int getNp2() {
        return np2;
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
