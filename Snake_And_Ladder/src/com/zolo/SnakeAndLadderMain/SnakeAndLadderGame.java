package com.zolo.SnakeAndLadderMain;

import java.util.ArrayList;
import java.util.List;

import com.zolo.snakeandladder.CreateGame;
import com.zolo.snakeandladder.PlayGame;
import com.zolo.snakeandladder.model.BoardVO;
import com.zolo.snakeandladder.model.Users;
/**
 * The Class SnakeAndLadderGame.
 */
public class SnakeAndLadderGame extends Thread{

	/** The pit stops. */
	int[][] pitStops = CreateGame.createGame();

	/** The obj board vo. */
	BoardVO	objBoardVO = CreateGame.createBoard(pitStops);

	/** The obj list user. */
	static List<Users> objListUser = new ArrayList<Users>();


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		//Creating the users 
		int usersCount = 2;
		SnakeAndLadderGame objSnakeAndLadder = new SnakeAndLadderGame();
		for(int i = 0;i<usersCount;i++){
			Users objectUsers = new Users();
			objectUsers.setUserName("User"+i);
			objectUsers.setCurrPosition(0);
			objectUsers.setPrevPosition(0);
			objListUser.add(objectUsers);
		}

		//Playing the Snake and Ladder Game
		objSnakeAndLadder.start();
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){

		PlayGame objPlayGame = new PlayGame(objListUser,objBoardVO,2,pitStops);
		objPlayGame.playGame();

	}




}
