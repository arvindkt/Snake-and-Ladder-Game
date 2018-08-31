package com.zolo.Score;

import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class ReachGivenScore.
 */
public class ReachGivenScore {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		System.out.println("*** Program to print number of ways to reach the given score ***");
		Scanner in =  new Scanner(System.in);
		ReachGivenScore object = new ReachGivenScore();
		System.out.print("Enter the Score: \t");
		int score = in.nextInt();
		int[] points ={3,7,21};
		int numberOfWays = object.findAllWays(score,points);
		System.out.println("Number of ways to reach the given score :" +numberOfWays);
	}
	
	/**
	 * Find all ways to reach the score.
	 *
	 * @param score the score
	 * @param points the points
	 * @return the int
	 */
	public int findAllWays(int score,int points[]){
		int numberOfWays[][] = new int[points.length+1][score+1];
		for (int i=0;i<=points.length;i++){
			for (int j = 0; j <=score ; j++) {
				numberOfWays[0][j] =0;
				numberOfWays[i][0]=1;
				if(i>=1&&j>=1){
					if(points[i-1]<=j){
						numberOfWays[i][j] = numberOfWays[i-1][j] + numberOfWays[i][j-points[i-1]];
					}else{
						numberOfWays[i][j] = numberOfWays[i-1][j];
					}
				}
			}
		}
		return (numberOfWays[points.length][score]);
	}

}
