package com.engine.bot;

import com.engine.action.Action;
import com.engine.action.AttackAction;
import com.engine.action.MoveAction;
import com.engine.core.Board;
import com.engine.core.Tile;
import com.engine.type.TileDirection;
import com.engine.type.TileState;

public class TestFindAttackBot extends Bot {

	public TestFindAttackBot()
	{
		setHealth(100);
	}
	
	@Override
	public Action getNextAction() {
		Tile t = getTile();
		TileDirection d = t.getClosestBot();
		TileState state = t.getTileStateByDirection(d);
		System.out.println(state);
		if(state != TileState.EMPTY && state == TileState.FILLED)
		{
			return attackBot(t, t.board, t.getTileByDirection(d));
		}
		else
		{
			return getNothingAction(t, t.board, t.getClosestBot());
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
	
	public Action attackBot(Tile tile, Board b, Tile enemy)
	{
		AttackAction action = new AttackAction();
		action.attackingTile = tile;
		action.recievingTile = enemy;
		action.board = b;
		return action;
	}
}
