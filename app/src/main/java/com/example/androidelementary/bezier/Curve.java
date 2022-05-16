package com.example.androidelementary.bezier;


import java.util.List;

/**
 * Created by ypp on 2022/4/21
 */
public abstract class Curve {

    protected Point[] mControlPoints;

    protected Point[] mTempPoints;

    public Curve(Point... points) {
        setControlPoints(points);
    }

    public Curve(List<Point> points) {
        setControlPoints(points);
    }

    public void setControlPoints(Point... points) {
        mControlPoints = points;
    }

    public void setControlPoints(List<Point> points) {
        mControlPoints = new Point[points.size()];
        mTempPoints = new Point[points.size()];
        points.toArray(mControlPoints);
    }

    public abstract Point getPathPoint(float t);
}
