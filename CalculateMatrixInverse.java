import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Chandan Singh
 *
 */
public class CalculateMatrixInverse {
	public static int caseCount = 0;
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			List<Integer> inputNumbers = new ArrayList<>();
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				if (!nextLine.isEmpty()) {
					String[] numbers = nextLine.split(" ");
					int a = Integer.valueOf(numbers[0]);
					int b = Integer.valueOf(numbers[1]);
					inputNumbers.add(a);
					inputNumbers.add(b);
				} else {
					caseCount++;
					calculateInverse(inputNumbers);
					inputNumbers.clear();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void calculateInverse(List<Integer> inputNumbers) {
		Integer[][] matrix = getMatrix(inputNumbers);
		int determinant = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);

		int temp = matrix[0][0];
		matrix[0][0] = matrix[1][1];
		matrix[1][1] = temp;

		matrix[0][1] = -matrix[0][1];
		matrix[1][0] = -matrix[1][0];

		System.out.println("Case " + caseCount + ":");
		for (int row = 0; row < 2; row++) {
			for (int column = 0; column < 2; column++)
			{
				System.out.print((matrix[row][column] / determinant) + " ");
			}
			System.out.println();
		}
	}

	private static Integer[][] getMatrix(List<Integer> inputNumbers) {
		Integer[][] matrix = new Integer[2][2];
		matrix[0][0] = inputNumbers.get(0);
		matrix[0][1] = inputNumbers.get(1);
		matrix[1][0] = inputNumbers.get(2);
		matrix[1][1] = inputNumbers.get(3);
		return matrix;
	}
}
