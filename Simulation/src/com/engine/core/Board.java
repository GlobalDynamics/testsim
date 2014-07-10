package com.engine.core;

import java.util.ArrayList;
import java.util.List;

import com.engine.type.TileType;

public class Board {

	//public Tile[][] boardArray;
	public int boardLength = 20;
	public int boardWidth = 20;
	
	public List<Tile> blueList = new ArrayList<Tile>();
	public List<Tile> redList = new ArrayList<Tile>();
	
	
	public Board(int boardWidth, int boardLength)
	{
		this.boardLength = boardLength;
		this.boardWidth = boardWidth;
		generateTiles();
	}
	
	public void incrementTest()
	{
		blueList.get(0).positionX = blueList.get(0).positionX +1;
	}
	
	public void generateTiles()
	{
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
	}
}
