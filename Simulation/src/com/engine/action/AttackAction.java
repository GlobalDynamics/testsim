package com.engine.action;

import com.engine.core.Board;
import com.engine.core.Tile;

public class AttackAction implements Action {

	public Tile attackingTile;
	public Tile recievingTile;
	public Board board;
	
	@Override
	public void performAction() {
		board.attackTile(attackingTile, recievingTile);
	}
}
