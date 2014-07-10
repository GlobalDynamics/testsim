package com.engine.grid;

import java.awt.Color;
import java.awt.Graphics2D;

import com.engine.core.Tile;
import com.engine.type.TileType;

public class GridPainter {
		public void updateGrid(Graphics2D g2d, StringRectangle cell, Tile t)
		{
	    	//int index = t.getPositionX() + (t.getPositionY() * boardWidth);
	    	if(t.tileType == TileType.BLUE)
	    	{
	    		cell.drawStringRect(g2d, true, Color.BLUE, Color.WHITE);
	    	}
	    	else if(t.tileType == TileType.RED)
	    	{
	    		cell.drawStringRect(g2d, true, Color.RED, Color.WHITE);
	    	}
	    	else if(t.tileType == TileType.YELLOW)
	    	{
	    		cell.drawStringRect(g2d, true, Color.YELLOW, Color.WHITE);
	    	}
	    	else
	    	{
	    		cell.drawStringRect(g2d, true, Color.GRAY, Color.WHITE);
	    	}
	    	
		}
}
