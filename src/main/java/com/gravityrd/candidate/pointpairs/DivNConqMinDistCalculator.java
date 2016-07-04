/*     
 * NaiveMinDistCalculator.java     
 * 1.1-SNAPSHOT     
 *     / work in progress /
 */
package com.gravityrd.candidate.pointpairs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DivNConqMinDistCalculator extends MinDistCalculator {
    
    @Override
    protected void init(List<Point> points) {
        if (!(points instanceof ArrayList<?>)) {
            points = new ArrayList<>(points);
        }
        super.init(points);
    }

    @Override
    public Result getMinDistPair() {
        points.sort(Comparator.comparing(p -> p.getCoords()[0]));
        return getMinDistPair(points);
    }
    
    private Result getMinDistPair(List<Point> points) {
        int length = points.size();
        if (length < 1) {
            throw new IllegalStateException("should get a List of one or more points!");            
        }
        switch (length) {
            case 1:
                return new Result(null, null, Double.MAX_VALUE);
            case 2:
                return new Result(points.get(0), points.get(1));
            default:
                // DIVIDE
                List<Point> lower = points.subList(0, length/2);
                List<Point> upper = points.subList(length/2, length);
                // CONQUER
                
                // COMBINE
                
                return null; //FIXME
        }
    }
}
