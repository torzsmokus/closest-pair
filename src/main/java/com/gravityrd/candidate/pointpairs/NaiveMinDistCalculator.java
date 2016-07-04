package com.gravityrd.candidate.pointpairs;


/**
 * Naïve closest point pair calculator (comparing each possible pair)
 */
public class NaiveMinDistCalculator extends MinDistCalculator {

    @Override
    public Result getMinDistPair() {
        Point minp1 = null;
        Point minp2 = null;
        double delta = Double.MAX_VALUE;
        for (int i = 0; i < points.size()-1; i++) {
            for (int j = i+1; j< points.size(); j++) {
                Point p1 = points.get(i);
                Point p2 = points.get(j);
                double dist = p1.distance(points.get(j));
                if (dist < delta) {
                    minp1 = p1;
                    minp2 = p2;
                    delta = dist;
                }
            }
        }
        return new Result(minp1, minp2, delta);
    }
}
