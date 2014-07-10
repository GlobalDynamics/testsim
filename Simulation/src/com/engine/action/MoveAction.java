package com.engine.action;

import com.engine.core.Board;
import com.engine.core.Tile;
import com.engine.type.TileDirection;

public class MoveAction implements Action{

	public TileDirection direction;
	public Tile tile;
	public Board board;
	@Override
	public void performAction() {
		board.moveTile(direction, tile);
	}

}
