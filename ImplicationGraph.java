import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Chandan Singh
 *
 */
public class ImplicationGraph {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);) {
			int testCaseCount = sc.nextInt();
			sc.nextLine();
			
			if(testCaseCount == 0) {System.exit(0);} ;

			for (int caseCount = 0; caseCount < testCaseCount; caseCount++) {
				String nextLine = sc.nextLine();
				String[] numbers = nextLine.split(" ");
				int stmtCount = Integer.valueOf(numbers[0]);
				int implicationsCount = Integer.valueOf(numbers[1]);
				if(implicationsCount == 0)
				{
					System.out.println(stmtCount);
					continue;
				}
				else
				{
					final Map<Integer, Integer> inDegree = new HashMap<>(stmtCount);
					final Map<Integer, Integer> outDegree = new HashMap<>(stmtCount);
					initializeDegrees(inDegree, outDegree,stmtCount);
					for(int implication = 0; implication < implicationsCount ; implication++)
					{
						String graphInfoLine = sc.nextLine();
						String[] implicationStatement = graphInfoLine.split(" ");
						int fromVertex = Integer.valueOf(implicationStatement[0]);
						int toVertex = Integer.valueOf(implicationStatement[1]);
						outDegree.put(fromVertex, (outDegree.get(fromVertex)+1));
						inDegree.put(toVertex, (inDegree.get(toVertex)+1));
					}
					long additionalImplicationsReqd = findAdditionalImplications(outDegree,inDegree);
					System.out.println(additionalImplicationsReqd);
				}
			}
		}
	}

	private static long findAdditionalImplications(Map<Integer, Integer> outDegree, Map<Integer, Integer> inDegree) {
		long vertexWithZeroOutDegree = findKeysWithZeroCount(outDegree);
		long vertexWithZeroInDegree = findKeysWithZeroCount(inDegree);
		
		return Math.max(vertexWithZeroInDegree,vertexWithZeroOutDegree);
	}

	private static long findKeysWithZeroCount(Map<Integer, Integer> graphMap) {

		return graphMap.values().stream().filter(v -> v.equals(0)).count();
		
	}

	private static void initializeDegrees(Map<Integer, Integer> inDegree, Map<Integer, Integer> outDegree, int statmentCount) {
		for(int vertex= 1; vertex <= statmentCount; vertex++)
		{
			inDegree.put(vertex, 0);
			outDegree.put(vertex, 0);
		}
	}
}
