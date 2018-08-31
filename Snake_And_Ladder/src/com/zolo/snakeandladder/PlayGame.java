package com.zolo.snakeandladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.zolo.snakeandladder.model.BoardVO;
import com.zolo.snakeandladder.model.Users;
import com.zolo.snakeandladder.path.ShortestPath;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayGame.
 */
public class PlayGame {
	
	/** The Constant WINNING_POINT. */
	public static final int WINNING_POINT = 100;
	
	/** The pit stops. */
	int[][] pitStops;
	
	/** The obj board vo. */
	BoardVO	objBoardVO ;
	
	
	/** The obj users. */
	List<Users> objListUsers = new ArrayList<Users>();
	
	/** The users count. */
	int usersCount;
	
	/** The player curr position. */
	int playerCurrPosition;
	
	/** The player prev position. */
	int playerPrevPosition;
	
	/**
	 * Instantiates a new play game.
	 *
	 * @param objUsers the obj users
	 * @param objBoardVO the obj boardvo
	 * @param usersCount the users count
	 */
	public PlayGame(List<Users> objUsers,BoardVO objBoardVO,int usersCount,int[][] pitStops){
		this.objListUsers = objUsers;
		this.objBoardVO = objBoardVO;
		this.usersCount = usersCount;
		this.pitStops = pitStops;
	}
	
	/**
	 * Roll dice.
	 *
	 * @return the random number between 1 to 6
	 */
	
	public int rollDice(){
		Random random = new Random();
		return random.nextInt(6) +1;
	}
	
	
	/**
	 * Checks if is the player wins.
	 *
	 * @param playerPosition the player position
	 * @return true, if player is win
	 */
	public boolean isWin(int playerPosition){
		return (WINNING_POINT == playerPosition);
	}
	
	
	/**
	 * Calculate player position value.
	 *
	 * @param positionValue the position value
	 * @param diceValue the dice value
	 * @return the int position
	 */
	public int CalculatePlayerPositionValue(int positionValue, int diceValue){
		positionValue = positionValue + diceValue;
	    if(positionValue > WINNING_POINT)
	    {
	    	positionValue = positionValue - diceValue;
	        return positionValue;
	    }
	      
	    if(null!=objBoardVO.getMapSnakePointers().get(positionValue))
	    {
	    	//System.out.println("Snake");
	        positionValue= objBoardVO.getMapSnakePointers().get(positionValue);
	    }
	      
	    if(null!=objBoardVO.getMapLadderPointers().get(positionValue))
	    {
	    	//System.out.println("Ladder");
	        positionValue= objBoardVO.getMapLadderPointers().get(positionValue);
	    }
	    
	    return positionValue;
	
	}


	/**
	 * Play the snake and ladder  game.
	 */
	public void playGame() {
		System.out.println("**** Playing Game **** ");
		System.out.println("USER   DICE NO.  PREVIOUS STATE  CURRENT STATE");
		boolean isWin = true;
		while(isWin){
			for (int i = 0; i < usersCount ; i++){
				int diceValue = rollDice();
				 
				playerPrevPosition = objListUsers.get(i).getCurrPosition();
				playerCurrPosition  =   CalculatePlayerPositionValue(playerPrevPosition, diceValue);
				objListUsers.get(i).setPrevPosition(playerPrevPosition);
				objListUsers.get(i).setCurrPosition(playerCurrPosition);
				if(objListUsers.get(i).getCurrPosition() == WINNING_POINT){
					isWin = false;
					System.out.println( objListUsers.get(i).getUserName() +"	"+diceValue +"		"+ playerPrevPosition+ "		"+ playerCurrPosition);
					System.out.println(objListUsers.get(i).getUserName() +"  successfully win the Snake and Ladder game" );
					
					//Find the Shortest path
					ShortestPath objShortestPath = new ShortestPath();
					String shortestPath = objShortestPath.findShortestPath(pitStops);
					System.out.println("Shortest path to reach the EndPoint from the StartPoint : " + shortestPath);
					break;
				}
				
				System.out.println( objListUsers.get(i).getUserName() +"	"+diceValue +"		"+ playerPrevPosition+ "		"+ playerCurrPosition);
			}
		}
		
	}
}
