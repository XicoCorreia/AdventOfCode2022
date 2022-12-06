package AOC22;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day06 extends AOC22{

	protected Day06() {
		super("06");
	}

	@Override
	protected void solve(List<String> values) {
		String dataStream = values.get(0);
		Set<Character> allDiff = new HashSet<Character>();
		//Part 1
		for(int i = 0; i < dataStream.length() - 3; i++) {
			allDiff.clear();
			allDiff.add(dataStream.charAt(i));
			for(int j = i+1; j < i+4; j++ ) {
				allDiff.add(dataStream.charAt(j));
			}
			if(allDiff.size() == 4) {
				printAnswer(Integer.toString(i+4));
				break;
			}
		}
		//Part 2
		for(int i = 0; i < dataStream.length() - 13; i++) {
			allDiff.clear();
			allDiff.add(dataStream.charAt(i));
			for(int j = i+1; j < i+14; j++ ) {
				allDiff.add(dataStream.charAt(j));
			}
			if(allDiff.size() == 14) {
				printAnswer(Integer.toString(i+14));
				break;
			}
		}
	}

}
