package com.engine.bot;

import com.engine.action.Action;
import com.engine.action.MoveAction;
import com.engine.core.Board;
import com.engine.core.Tile;
import com.engine.type.TileDirection;
import com.engine.type.TileState;

public class TestFindBot extends Bot {

	public TestFindBot()
	{
		setHealth(100);
	}
	
	@Override
	public Action getNextAction() {
		Tile t = getTile();
		//System.out.println(t.board.getAngle(p1, p2)
		TileDirection d = t.getClosestBot();
		if(t.getTileStateByDirection(d) != TileState.FILLED)
		{
			return getNothingAction(t, t.board, t.getClosestBot());
		}
		else
		{
			return getNothingAction(t, t.board, TileDirection.NO_MOVE);
		}
		
	}
	
	public Action getNothingAction(Tile t, Board b, TileDirection direction)
	{
		MoveAction action = new MoveAction();
		action.tile = t;
		action.board = b;
		action.direction = direction;
		return action;
	}
}
