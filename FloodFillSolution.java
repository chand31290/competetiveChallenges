package com.chandan.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillSolution
{
	public static void main(String[] args)
	{
		int[][] image = {{0,0,0},{0,1,1}};//{{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(Arrays.deepToString(floodFill(image , 1, 1, 1)));
	}

	private static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
	{
		class CoOrdinates
		{
			int row;
			int column;

			public CoOrdinates(int row, int column)
			{
				this.row = row;
				this.column = column;
			}
		}

		Queue<CoOrdinates> fourPointNeighbours = new LinkedList<>();

		int initialColor = image[sr][sc];
		
		if(initialColor == newColor) return image;
		
		image[sr][sc] = newColor;

		fourPointNeighbours.add(new CoOrdinates(sr, sc));
		
		int count = 0;

		while (!fourPointNeighbours.isEmpty())
		{
			count++;
			
			CoOrdinates currentCoOrdinates = fourPointNeighbours.poll();

			int row = currentCoOrdinates.row;
			int column = currentCoOrdinates.column;

			if (row - 1 >= 0 && image[row - 1][column] == initialColor)
			{
				image[row - 1][column] = newColor;
				fourPointNeighbours.add(new CoOrdinates(row - 1, column));
			}
			if (column - 1 >= 0 && image[row][column - 1] == initialColor)
			{
				image[row][column - 1] = newColor;
				fourPointNeighbours.add(new CoOrdinates(row, column - 1));
			}
			if (row + 1 < image.length && image[row + 1][column] == initialColor)
			{
				image[row + 1][column] = newColor;
				fourPointNeighbours.add(new CoOrdinates(row + 1, column));
			}
			if (column + 1 < image[0].length && image[row][column + 1] == initialColor)
			{
				image[row][column + 1] = newColor;
				fourPointNeighbours.add(new CoOrdinates(row, column + 1));
			}

		}
		
		System.out.println(count);

		return image;
	}
}
