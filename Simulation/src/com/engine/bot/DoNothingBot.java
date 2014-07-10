package com.engine.bot;

import com.engine.action.Action;
import com.engine.action.MoveAction;
import com.engine.core.Tile;
import com.engine.type.TileDirection;

public class DoNothingBot extends Bot {
	
	
	public DoNothingBot()
	{
		setHealth(100);
	}
	
	@Override
	public Action getNextAction() {
		Tile t = getTile();
		MoveAction action = new MoveAction();
		action.tile = t;
		action.board = t.board;
		action.direction = TileDirection.NO_MOVE;
		return action;
	}
}
