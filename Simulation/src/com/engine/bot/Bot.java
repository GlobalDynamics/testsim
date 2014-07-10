package com.engine.bot;

import com.engine.action.Action;
import com.engine.core.Tile;

public class Bot {
	private int health = 100;
	private int stealthTurns = 0;
	private int teleportLength = 0;
	private int suicideArea = 1;
	
	//abilities
	private boolean hasStealth = false;
	private boolean hasTeleport = false;
	private boolean hasSuicide = true;
	
	private double probabilityOfAttack = .50;
	private double probabilityOfMove = .50;
	
	
	//status
	private boolean stealthActive = false;
	private Tile tile;


	public int getHealth() {
		return health;
	}
	
	public Action getNextAction()
	{
		return null;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getStealthTurns() {
		return stealthTurns;
	}


	public void setStealthTurns(int stealthTurns) {
		this.stealthTurns = stealthTurns;
	}


	public int getTeleportLength() {
		return teleportLength;
	}


	public void setTeleportLength(int teleportLength) {
		this.teleportLength = teleportLength;
	}


	public int getSuicideArea() {
		return suicideArea;
	}


	public void setSuicideArea(int suicideArea) {
		this.suicideArea = suicideArea;
	}


	public boolean hasStealth() {
		return hasStealth;
	}


	public void setHasStealth(boolean hasStealth) {
		this.hasStealth = hasStealth;
	}


	public boolean isHasTeleport() {
		return hasTeleport;
	}


	public void hasTeleport(boolean hasTeleport) {
		this.hasTeleport = hasTeleport;
	}


	public boolean hasSuicide() {
		return hasSuicide;
	}


	public void setHasSuicide(boolean hasSuicide) {
		this.hasSuicide = hasSuicide;
	}


	public double getProbabilityOfAttack() {
		return probabilityOfAttack;
	}


	public void setProbabilityOfAttack(double probabilityOfAttack) {
		this.probabilityOfAttack = probabilityOfAttack;
	}


	public double getProbabilityOfMove() {
		return probabilityOfMove;
	}


	public void setProbabilityOfMove(double probabilityOfMove) {
		this.probabilityOfMove = probabilityOfMove;
	}


	public boolean isStealthActive() {
		return stealthActive;
	}


	public void setStealthActive(boolean stealthActive) {
		this.stealthActive = stealthActive;
	}


	public Tile getTile() {
		return tile;
	}


	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	public void decrementHealth(int amount)
	{
		this.health = this.health - amount;
	}
}
