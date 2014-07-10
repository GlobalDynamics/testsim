package com.engine.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.engine.type.TileDirection;

public class DirectionsCalculator {
	
	public TileDirection getClosestBot(Tile tile, List<Tile> enemyList)
	{
		Tile closestBot = caluclateClosestBotDistance(tile, enemyList);
		double angle = normalizeAngle(getAngle(tile, closestBot));
		System.out.println(angle);
		return getDirectionFromAngle(angle);
	}
	
	private TileDirection getDirectionFromAngle(double angle)
	{
		if((angle > 0 && angle <=45) || (angle >315 && angle <=360))
		{
			return TileDirection.RIGHT;
		}
		else if((angle >45 && angle <=90) || (angle >90 && angle <=135))
		{
			return TileDirection.UP;
		}
		else if((angle >135 && angle <=180) || (angle >180 && angle <=225))
		{
			return TileDirection.LEFT;
		}
		else if((angle >225 && angle <=270) || (angle >270 && angle <=315))
		{
			return TileDirection.DOWN;
		}
		else
		{
			return TileDirection.NO_MOVE;
		}
	}
	
    private double normalizeAngle(double angle)
    {
    	if(isPositive(angle))
    	{
    		return angle;
    	}
    	else
    	{
    		return 360 + angle;
    	}
    }

	
    public double getAngle(Tile p1, Tile p2)
    {
        double xDiff = p2.positionX - p1.positionX;
        double yDiff =  p1.positionY - p2.positionY;
        return Math.toDegrees(Math.atan2(yDiff, xDiff));
    }
	
	public Tile caluclateClosestBotDistance(Tile tile, List<Tile> botList)
	{
		Map<Double, Tile> distanceList = new HashMap<Double, Tile>();
		for(Tile t: botList)
		{
			double x1 = tile.positionX;
			double x2 = t.positionX;
			double y1 = tile.positionY;
			double y2 = t.positionY;
			distanceList.put(Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)), t);
		}
		TreeMap<Double, Tile> sortedDistances = new TreeMap<Double, Tile>(distanceList);
		return sortedDistances.firstEntry().getValue();
	}
	
	 public boolean isPositive(double f) {
	        if (f != f) throw new IllegalArgumentException("NaN");
	        if (f == 0) return false;
	        f *= Double.POSITIVE_INFINITY;
	        if (f == Double.POSITIVE_INFINITY) return true;
	        if (f == Double.NEGATIVE_INFINITY) return false;

	        //this should never be reached, but I've been wrong before...
	        throw new IllegalArgumentException("Unfathomed double");
	    }
}
