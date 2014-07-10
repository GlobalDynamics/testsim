package com.engine.grid;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.engine.core.Board;
import com.engine.core.Tile;
import com.engine.type.TileType;

public class GridTest extends TestCase{

	public void testGrid()
	{
		Board b = new Board(50,50);
		generateTiles(b);
		Grid g = new Grid();
		g.b = b;
	}
	
	public Board generateTiles(Board b)
	{
		List<Tile> blueList = new ArrayList<Tile>();
		List<Tile> redList = new ArrayList<Tile>();
		for(int i=0;i<2;i++)
		{
			Tile t = new Tile(3,3, TileType.BLUE);
			blueList.add(t);
		}
		for(int i=0;i<2;i++)
		{
			Tile t = new Tile(3,3, TileType.RED);
			redList.add(t);
		}
		b.blueList = blueList;
		b.redList = redList;
		return b;
	}
}

