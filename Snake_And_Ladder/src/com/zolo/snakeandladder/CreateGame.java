package com.zolo.snakeandladder;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import com.zolo.snakeandladder.model.BoardVO;

/**
 * The Class CreateGame.
 */
public class CreateGame {
	
	/**
	 * Creates the game pitstops from input text
	 *
	 * @return the int[][] pitStops
	 */
	public static int[][] createGame(){
		
		System.out.println("****** Snake and Ladder Game ******");
		System.out.println("Reading input from text file");
		BufferedReader bufferedReader = null;
		int N = 0 ;
		int[][] pitStops =null;

		//Reading input from text file
		try {
			bufferedReader = new BufferedReader(new FileReader("input/input.txt"));
		} catch (FileNotFoundException e1) {
			System.out.println("Input file is not found " + e1.getMessage());
		}    
		try {
			String inputLine ; 
			int count = 0, i =0;
			while((inputLine =bufferedReader.readLine())!= null){  
				if(count ==0){
					N = Integer.parseInt(inputLine);
					count++;
					pitStops = new int[N][N];
				}else {
					String[] values = inputLine.split(" ");
					for(int j = 0;j<values.length;j++){
						pitStops[i][j] = Integer.parseInt(values[j]);
					}
					i++;
				}
			}
		} catch (IOException e) {
			System.out.println("Error while reading the input file " + e.getMessage());
		}  
		return pitStops;
	}

	
	/**
	 * Creates the Snake and Ladder board.
	 *
	 * @param pitStop the pit stop
	 * @return the board vo
	 */
	public static BoardVO createBoard(int[][] pitStop){
		Map<Integer,Integer> mapSnakePointers = new HashMap<Integer,Integer>();
		Map<Integer,Integer> mapLadderPointers = new HashMap<Integer,Integer>();
		BoardVO objCreateBoard = new BoardVO();
		for(int i = 0;i<pitStop.length;i++){
			mapSnakePointers.put(pitStop[i][1],pitStop[i][0]);
			mapLadderPointers.put(pitStop[i][2],pitStop[i][3]);
		}

		objCreateBoard.setBoardSize(100);
		objCreateBoard.setMapSnakePointers(mapSnakePointers);
		objCreateBoard.setMapLadderPointers(mapLadderPointers);
		return objCreateBoard;
	}


}