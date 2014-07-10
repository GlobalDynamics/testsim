package com.engine.bot;

import com.engine.action.Action;
import com.engine.action.MoveAction;
import com.engine.core.Board;
import com.engine.core.Tile;
import com.engine.type.TileDirection;
import com.engine.type.TileState;

public class TestBot extends Bot {
	
	
	public TestBot()
	{
		setHealth(100);
	}

	@Override
	public Action getNextAction() {
		Tile t = getTile();
		int length = t.board.boardLength;
		int width = t.board.boardWidth;
		
		if(t.inTopLeftCorner() || (t.getLeft() == TileState.X_START && t.getBottom() == TileState.EMPTY))
		{
			return directionCheck(TileDirection.DOWN, t.board, t);
		}
		else if(t.inBottomLeftCorner() || (t.getLeft() == TileState.EMPTY && t.getBottom() == TileState.Y_END && t.getRight() == TileState.EMPTY))
		{
			return directionCheck(TileDirection.RIGHT, t.board, t);
		}
		else if(t.inBottomRightCorner()||(t.getRight() == TileState.X_END && t.getTop() == TileState.EMPTY))
		{
			return directionCheck(TileDirection.UP, t.board, t);
		}
		else if(t.inTopRightCorner() ||(t.getTop() == TileState.Y_START && t.getLeft() == TileState.EMPTY))
		{
			return directionCheck(TileDirection.LEFT, t.board, t);
		}
		
		
		
		
		return getMoveAction(TileDirection.UP, t.board, t); 
		
//		if((t.getLeft() == TileState.X_START && t.getBottom() != TileState.Y_END)
//				|| (t.getLeft() == TileState.X_START && t.getTop() == TileState.Y_START))
//		{
//			return getMoveAction(TileDirection.DOWN, t.board, t);
//			
//		}
//		else if((t.getLeft() == TileState.X_START && t.getBottom() == TileState.Y_END)
//				|| (t.getRight() != TileState.X_END && t.getBottom() == TileState.Y_END))
//		{
//			return getMoveAction(TileDirection.RIGHT, t.board, t);
//			
//		}
//		else if((t.getRight() == TileState.X_END && t.getBottom() == TileState.Y_END)
//				|| (t.getRight() == TileState.X_END && t.getTop() != TileState.Y_START))
//		{
//			return getMoveAction(TileDirection.UP, t.board, t);
//			
//		}
//		else if((t.getRight() == TileState.X_END && t.getTop() == TileState.Y_START)
//				|| (t.getLeft() != TileState.X_START && t.getTop() == TileState.Y_START))
//		{
//			return getMoveAction(TileDirection.LEFT, t.board, t);
//			
//		}
	}
	
	private Action getMoveAction(TileDirection direction, Board board, Tile tile)
	{
		MoveAction action = new MoveAction();
		action.board = board;
		action.tile = tile;
		action.direction = direction;
		return action;
		
	}
	
	private Action directionCheck(TileDirection direction, Board board, Tile tile)
	{
		TileState state = tile.getTileStateByDirection(direction);
		if(state == TileState.EMPTY)
		{
			return getMoveAction(direction, board, tile);
		}
		return getMoveAction(TileDirection.NO_MOVE, board, tile);
	}
	
	
}
