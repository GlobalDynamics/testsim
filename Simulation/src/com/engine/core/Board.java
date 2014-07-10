package com.engine.core;

import java.util.ArrayList;
import java.util.List;

import com.engine.action.Action;
import com.engine.bot.TestBot;
import com.engine.bot.TestFindAttackBot;
import com.engine.type.TileDirection;
import com.engine.type.TileState;
import com.engine.type.TileTurn;
import com.engine.type.TileType;
import com.engine.util.Util;

public class Board {
	public int boardLength = 20;
	public int boardWidth = 20;
	
	public List<Tile> blueList = new ArrayList<Tile>();
	public List<Tile> redList = new ArrayList<Tile>();
	
	public TileTurn nextTurn = TileTurn.BLUE;
	
	
	public Board(int boardWidth, int boardLength)
	{
		this.boardLength = boardLength;
		this.boardWidth = boardWidth;
		generateTiles();
	}
	
	public void performNextTurn()
	{
		if(nextTurn == TileTurn.BLUE)
		{
			for(Tile tile : blueList)
			{
				Action action = tile.getNextAction();
				action.performAction();
			}
			nextTurn = TileTurn.RED;
		}
		else if(nextTurn == TileTurn.RED)
		{
			for(Tile tile : redList)
			{
				Action action = tile.getNextAction();
				action.performAction();
			}
			nextTurn = TileTurn.BLUE;
		}
	}
	
	public void attackTile(Tile attackingTile, Tile recievingTile)
	{
		
		recievingTile.bot.decrementHealth(Util.randomInteger(0, 15));
		if(recievingTile.bot.getHealth() <= 0)
		{
			
		}
	}
	
	
	
	public Tile getTile(int x, int y, TileType type)
	{
		List<Tile> list;
		if(type == TileType.BLUE)
		{
			list = redList;
		}
		else
		{
			list = blueList;
		}
		for(Tile tile : list)
		{
			if(tile.positionX == x && tile.positionY == y)
			{
				return tile;
			}
		}
		return null;
	}
	
	
	public void moveTile(TileDirection direction, Tile tile)
	{
		if(direction == TileDirection.UP)
		{
			tile.positionY = tile.positionY -1;
		}
		else if(direction == TileDirection.DOWN)
		{
			tile.positionY = tile.positionY +1;
		}
		else if(direction == TileDirection.RIGHT)
		{
			tile.positionX = tile.positionX +1;
		}
		else if(direction == TileDirection.LEFT)
		{
			tile.positionX = tile.positionX -1;
		}
	}
	
	
	public TileState checkTile(int x, int y)
	{

		TileState yState = checkY(y);
		TileState xState = checkX(x);
		
		if(yState == TileState.Y_START && xState == TileState.X_START)
		{
			return TileState.TOP_LEFT_CORNER;
		}
		else if(yState == TileState.Y_START && xState == TileState.X_END)
		{
			return TileState.TOP_RIGHT_CORNER;
		}
		else if(yState == TileState.Y_END && xState == TileState.X_START)
		{
			return TileState.BOTTOM_LEFT_CORNER;
		}
		else if(yState == TileState.Y_END && xState == TileState.X_END)
		{
			return TileState.BOTTOM_RIGHT_CORNER;
		}
		else if(yState == TileState.Y_END && xState == TileState.NOTEND)
		{
			return TileState.Y_END;
		}
		else if(yState == TileState.Y_START && xState == TileState.NOTEND)
		{
			return TileState.Y_START;
		}
		
		else if(xState == TileState.X_END && yState == TileState.NOTEND)
		{
			return TileState.X_END;
		}
		else if(xState == TileState.X_START && yState == TileState.NOTEND)
		{
			return TileState.X_START;
		}
		
		
		for(Tile tile : blueList)
		{
			if(tile.positionX == x && tile.positionY == y)
			{
				return TileState.FILLED;
			}
		}
		for(Tile tile : redList)
		{
			if(tile.positionX == x && tile.positionY == y)
			{
				return TileState.FILLED;
			}
		}
		return TileState.EMPTY;
		
	}
	
	public TileState checkY(int y)
	{
		if(y > boardLength-1)
		{
			return TileState.Y_END;
		}
		else if(y < 0)
		{
			return TileState.Y_START;
		}
		return TileState.NOTEND;
	}
	
	public TileState checkX(int x)
	{
		if(x < 0)
		{
			return TileState.X_START;
		}
		else if(x > boardWidth-1)
		{
			return TileState.X_END;
		}
		return TileState.NOTEND;
	}
	
	public TileDirection findClosestBot(Tile tile)
	{
		DirectionsCalculator calc = new DirectionsCalculator();
		if(tile.tileType == TileType.BLUE)
		{
			return calc.getClosestBot(tile, redList);
		}
		else
		{
			return calc.getClosestBot(tile, blueList);
		}
		
	}
	
	
	public void incrementTest()
	{
		blueList.get(0).positionX = blueList.get(0).positionX +1;
	}
	
	public void generateTiles()
	{
		for(int i=0;i<1;i++)
		{
			Tile t = new Tile(0, 0, TileType.BLUE);
			TestBot b = new TestBot();
			b.setTile(t);
			t.bot = b;
			t.board = this;
			blueList.add(t);
		}
		for(int i=0;i<4;i++)
		{
			Tile t = new Tile(Util.randomInteger(5, 49),Util.randomInteger(2, 49), TileType.RED);
			TestFindAttackBot b = new TestFindAttackBot();
			b.setTile(t);
			t.bot = b;
			t.board = this;
			redList.add(t);
		}
	}
}
