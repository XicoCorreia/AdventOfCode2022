package AOC22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day10 extends AOC22 {
	
	public Day10() {
		super("10");
	}
	
	private static List<Integer> checkpoints = Arrays.asList(20, 60, 100, 140, 180, 220);
	private static char[][] matrix = new char[6][40];
	private static List<Integer> checkpointsValuesIntegers = new ArrayList<Integer>();;
	private static int cycle = 1;
	private static int cycle2 = 1;
	private static int X = 1;
	private static int X2 = 1;
	private static int row = 1;
	private static int col = 1;
	
	@Override
	protected void solve(List<String> values) {
		for(String val : values) {
			if(row == 6 && col == 40)
				break;
			switch (val.split(" ")[0]) {
				case "noop": {
					incCycle();
					paintCycle();
					break;
				}
				case "addx":{
					int n = Integer.valueOf(val.split(" ")[1]);
					incCycle();
					incCycle();
					X += n;
					paintCycle();
					paintCycle();
					X2 += n;
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + val.split(" ")[0] );
			}
		}
		
		printAnswer(checkpointsValuesIntegers.stream().mapToInt(i -> i).sum());
		printAnswer(": ");
		for (int j = 0; j < matrix.length; j++) {
			for (int j2 = 0; j2 < matrix[j].length; j2++) {
				System.out.print(matrix[j][j2]);
			}
			System.out.println();
		}
	}

	private void paintCycle() {
		if(cycle2 == X2 || cycle2 == X2+1 || cycle2 == X2+2) {
			matrix[row-1][col-1] = '#';
		}
		else {
			matrix[row-1][col-1] = '.';
		}
		if(row == 6 && col == 40)
			return;
		else if(cycle2 == 40) {
			col = 1;
			row++;
			cycle2 = 0;
		} 
		else {
			col++;
		}
		cycle2++;

	}

	private void incCycle() {
		if(checkpoints.contains(cycle)) {
			checkpointsValuesIntegers.add(cycle * X);
		}
		cycle +=1;
	}
}
