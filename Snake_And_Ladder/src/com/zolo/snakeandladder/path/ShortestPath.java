package com.zolo.snakeandladder.path;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Class ShortestPath.
 */
public class ShortestPath {
	
		/**
		 * The Class QueueEntry.
		 */
		
		static class QueueEntry 
		{
			
			/** The vertex. */
			int vertex;
			
			/** Distance of this vertex from source */
			int dist;	
			
			/** The path. */
			String path;
		}

		/**
		 * Gets the min dice throws.
		 *
		 * @param move the move
		 * @param n the n
		 * @return the min dice throws
		 */
		static String getMinDiceThrows(int move[], int n) 
		{
			int visited[] = new int[n];
			Queue<QueueEntry> queue = new LinkedList<QueueEntry>();
			QueueEntry queueEntry = new QueueEntry();
			queueEntry.vertex = 0;
			queueEntry.dist = 0;
			queueEntry.path="1";
			// Mark the node 0 as visited and enqueue it.
			visited[0] = 1;
			queue.add(queueEntry);

			// Do a BFS starting from vertex at index 0
			while (!queue.isEmpty()) 
			{
				queueEntry = queue.remove();
				int v = queueEntry.vertex;
				if (v == n - 1) {
				    break;
				}
				for (int j = v + 1; j <= (v + 6) && j < n; ++j) 
				{
					if (visited[j] == 0)
					{
						QueueEntry objQueueEntry  = new QueueEntry();
						objQueueEntry.dist = (queueEntry.dist + 1);
						objQueueEntry.path = queueEntry.path +"-"+j;
						visited[j] = 1;
						if (move[j] != -1)
							objQueueEntry.vertex = move[j];
						else
							objQueueEntry.vertex = j;
						queue.add(objQueueEntry);
					}
				}
			}
			return queueEntry.path;
		}
		
		/**
		 * Find shortest path.
		 *
		 * @param pitStop the pit stop
		 * @return the string
		 */
		public  String findShortestPath(int[][] pitStop){
			int N = 100;
			int moves[] = new int[N];
			for (int i = 0; i < N; i++)
				moves[i] = -1;
			for(int i = 0;i<pitStop.length;i++){
				moves[pitStop[i][1]] = pitStop[i][0];
				moves[pitStop[i][2]]=pitStop[i][3];
			}
			String shortestPath = getMinDiceThrows(moves,N);
			return shortestPath;
		}
	}


