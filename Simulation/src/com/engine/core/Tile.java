package com.engine.core;

import com.engine.type.TileType;

public class Tile {
	
	public int positionX;
	public int positionY;
	public TileType tileType;
	
	public Tile(int positionX, int positionY)
	{
		this.positionX = positionX;
		this.positionY = positionY;
	}
	public Tile(int positionX, int positionY, TileType tileType)
	{
		this.positionX = positionX;
		this.positionY = positionY;
		this.tileType = tileType;
	}

}
