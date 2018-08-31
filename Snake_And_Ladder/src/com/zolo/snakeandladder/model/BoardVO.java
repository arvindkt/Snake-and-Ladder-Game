package com.zolo.snakeandladder.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class BoardVO.
 */
public class BoardVO {

	/** The board size. */
	private int boardSize ;
	
	/** The map snake pointers. */
	private Map<Integer,Integer> mapSnakePointers = new HashMap<Integer,Integer>();
	
	/** The map ladder pointers. */
	private Map<Integer,Integer> mapLadderPointers = new HashMap<Integer,Integer>();
	
	/**
	 * Gets the board size.
	 *
	 * @return the board size
	 */
	public int getBoardSize() {
		return boardSize;
	}
	
	/**
	 * Sets the board size.
	 *
	 * @param boardSize the new board size
	 */
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	/**
	 * Gets the map snake pointers.
	 *
	 * @return the map snake pointers
	 */
	public Map<Integer, Integer> getMapSnakePointers() {
		return mapSnakePointers;
	}
	
	/**
	 * Sets the map snake pointers.
	 *
	 * @param mapSnakePointers the map snake pointers
	 */
	public void setMapSnakePointers(Map<Integer, Integer> mapSnakePointers) {
		this.mapSnakePointers = mapSnakePointers;
	}
	
	/**
	 * Gets the map ladder pointers.
	 *
	 * @return the map ladder pointers
	 */
	public Map<Integer, Integer> getMapLadderPointers() {
		return mapLadderPointers;
	}
	
	/**
	 * Sets the map ladder pointers.
	 *
	 * @param mapLadderPointers the map ladder pointers
	 */
	public void setMapLadderPointers(Map<Integer, Integer> mapLadderPointers) {
		this.mapLadderPointers = mapLadderPointers;
	}
	
	
}
