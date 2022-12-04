package AOC22;

import java.util.List;

public class Day02 extends AOC22{
	
	public Day02() {
		super("02");
	}
	
	@Override
	protected void solve(List<String> values) {
		
		String answerPart1 = solvePart1(values);
		printAnswer(answerPart1);
		
		String answerPart2 = solvePart2(values);
		printAnswer(answerPart2);
		
	}
	
	private static String solvePart1(List<String> values) {
		int score = 0;
		
		for(String val : values) {
			String[] elfVsMe = val.split(" ");
			
			if(elfVsMe[1].equals("X")) {
				score += 1;
				if(elfVsMe[0].equals("A"))
					score += 3;
				else if(elfVsMe[0].equals("C"))
					score += 6;
			}
			else if(elfVsMe[1].equals("Y")) {
				score += 2;
				if(elfVsMe[0].equals("B"))
					score += 3;
				else if(elfVsMe[0].equals("A"))
					score += 6;
			}
			else {
				score += 3;
				if(elfVsMe[0].equals("C"))
					score += 3;
				else if(elfVsMe[0].equals("B"))
					score += 6;
			}	
		}
		return Integer.toString(score);
	}
	
	private static String solvePart2(List<String> values) {
		int score = 0;
		
		for(String val : values) {
			String[] elfVsMe = val.split(" ");
			
			if(elfVsMe[1].equals("X")) {
				if(elfVsMe[0].equals("A"))
					score += 3;
				else if(elfVsMe[0].equals("B"))
					score += 1;
				else
					score += 2;
			}
			else if(elfVsMe[1].equals("Y")) {
				score += 3;
				if(elfVsMe[0].equals("A"))
					score += 1;
				else if(elfVsMe[0].equals("B"))
					score += 2;
				else
					score += 3;
			}
			else {
				score += 6;
				if(elfVsMe[0].equals("A"))
					score += 2;
				else if(elfVsMe[0].equals("B"))
					score += 3;
				else
					score += 1;
			}	
		}
		return Integer.toString(score);
	}


}
