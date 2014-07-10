package com.engine.core;

import com.engine.action.Action;
import com.engine.bot.Bot;
import com.engine.type.TileDirection;
import com.engine.type.TileState;
import com.engine.type.TileType;

public class Tile {
	
	public int positionX;
	public int positionY;
	public TileType tileType;
	public Bot bot;
	public Board board;
	
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
	
	public TileDirection getClosestBot()
	{
		return board.findClosestBot(this);
	}
	
	public Action getNextAction()
	{
		return bot.getNextAction();
	}
	
	public Tile getTileByDirection(TileDirection direction)
	{
		if(direction == TileDirection.UP)
		{
			return getTopTile();
		}
		else if(direction == TileDirection.DOWN)
		{
			return getBottomTile();
		}
		else if(direction == TileDirection.LEFT)
		{
			return getLeftTile();
		}
		else if(direction == TileDirection.RIGHT)
		{
			return getRightTile();
		}
		else
		{
			return null;
		}
	}
	
	public TileState getTileStateByDirection(TileDirection direction)
	{
		if(direction == TileDirection.UP)
		{
			return getTop();
		}
		else if(direction == TileDirection.DOWN)
		{
			return getBottom();
		}
		else if(direction == TileDirection.LEFT)
		{
			return getLeft();
		}
		else if(direction == TileDirection.RIGHT)
		{
			return getRight();
		}
		else
		{
			return TileState.FILLED;
		}
	}
	
	public Tile getLeftTile()
	{
		int LEFT_X = this.positionX - 1;
		return board.getTile(LEFT_X, this.positionY, this.tileType);
	}
	
	public Tile getRightTile()
	{
		int RIGHT_X = this.positionX + 1;
		return board.getTile(RIGHT_X, this.positionY, this.tileType);
	}
	public Tile getTopTile()
	{
		int TOP_Y = this.positionY - 1;
		return board.getTile(this.positionX, TOP_Y, this.tileType);
	}
	public Tile getBottomTile()
	{
		int BOTTOM_Y = this.positionY + 1;
		return board.getTile(this.positionX, BOTTOM_Y, this.tileType);
	}
	
	public TileState getLeft()
	{
		int LEFT_X = this.positionX - 1;
		return board.checkTile(LEFT_X, this.positionY);
	}
	public TileState getRight()
	{
		int RIGHT_X = this.positionX + 1;
		return board.checkTile(RIGHT_X, this.positionY);
	}
	public TileState getTop()
	{
		int TOP_Y = this.positionY - 1;
		return board.checkTile(this.positionX, TOP_Y);
	}
	public TileState getBottom()
	{
		int BOTTOM_Y = this.positionY + 1;
		return board.checkTile(this.positionX, BOTTOM_Y);
	}
	
	public TileState getTopLeft()
	{
		int TOP_Y = this.positionY - 1;
		int LEFT_X = this.positionX - 1;
		return board.checkTile(LEFT_X, TOP_Y);
	}
	
	public TileState getTopRight()
	{
		int TOP_Y = this.positionY - 1;
		int RIGHT_X = this.positionX + 1;
		return board.checkTile(RIGHT_X, TOP_Y);
	}
	
	public TileState getBottomLeft()
	{
		int BOTTOM_Y = this.positionY + 1;
		int LEFT_X = this.positionX - 1;
		return board.checkTile(LEFT_X, BOTTOM_Y);
	}
	public TileState getBottomRight()
	{
		int BOTTOM_Y = this.positionY + 1;
		int RIGHT_X = this.positionX + 1;
		return board.checkTile(RIGHT_X, BOTTOM_Y);
	}
	
	public boolean inTopLeftCorner()
	{
		return(this.positionX == 0 && this.positionY == 0);
	}
	public boolean inTopRightCorner()
	{
		return(this.positionX == board.boardWidth -1 && this.positionY == 0);
	}
	public boolean inBottomLeftCorner()
	{
		return(this.positionX == 0 && this.positionY == board.boardLength-1);
	}
	public boolean inBottomRightCorner()
	{
		return(this.positionX == board.boardWidth -1 && this.positionY == board.boardLength-1);
	}

}
