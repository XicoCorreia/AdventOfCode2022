package AOC22;

import java.util.List;
import java.util.stream.IntStream;

public class Day04 extends AOC22{

	protected Day04() {
		super("04");

	}

	@Override
	protected void solve(List<String> values) {
		String answer1 = part1(values);
		printAnswer(answer1);
		
		String answer2 = part2(values);
		printAnswer(answer2);
		
	}

	private String part1(List<String> values) {
		int count = 0;
		
		for (String val : values) {
			String[] pair = val.split("[-,]");
			
			if (Integer.valueOf(pair[0]) <= Integer.valueOf(pair[2]) && 
					Integer.valueOf(pair[1]) >= Integer.valueOf(pair[3])) {
				count += 1;
			}
			else if (Integer.valueOf(pair[2]) <= Integer.valueOf(pair[0]) && 
						Integer.valueOf(pair[3]) >= Integer.valueOf(pair[1])) {
				count += 1;
			}
		}
		return Integer.toString(count);
	}

	private String part2(List<String> values) {
		int count = 0;
		
		for (String val : values) {
			String[] pair = val.split("[,-]");	
			List<Integer> first = IntStream.rangeClosed(Integer.valueOf(pair[0]), 
																Integer.valueOf(pair[1])).boxed().toList();
			List<Integer> second = IntStream.rangeClosed(Integer.valueOf(pair[2]), 
																Integer.valueOf(pair[3])).boxed().toList();
			for(int i : first) {
				if (second.contains(i)) {
					count += 1;
					break; 
				}
			}
		}
		return Integer.toString(count);
	}
}
