package com.chandan.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindJudge
{
	public static void main(String[] args)
	{
		int[][] testArray = {{}};
		
		System.out.println(findJudge(4, testArray));
	}

	public static int findJudge(int N, int[][] trust)
	{
		
		if(trust.length ==0 ) return 1;
		
		Map<Integer, Integer> countForCitizenTrusts = new HashMap<>(N);
		
		Set<Integer> trustingCitizens = new HashSet<Integer>(N);
		
		int judgeTrustCountThreshold = N -1;
		
		int judgeId = -1;
		
		for (int i = 0; i < trust.length; i++)
		{
			countForCitizenTrusts.put(trust[i][1], countForCitizenTrusts.getOrDefault(trust[i][1], 0) + 1);
			trustingCitizens.add(trust[i][0]);
		}
		
		for(Map.Entry<Integer, Integer> countEntry : countForCitizenTrusts.entrySet())
		{
			if(countEntry.getValue() == judgeTrustCountThreshold && !trustingCitizens.contains(countEntry.getKey()))
			{
				judgeId = countEntry.getKey();
				break;
			}
		}
		
		
		return judgeId;
	}
}
