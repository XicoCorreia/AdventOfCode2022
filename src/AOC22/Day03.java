package AOC22;

import java.util.HashMap;
import java.util.List;

public class Day03 extends AOC22{
	
	private HashMap<Character, Integer> m;

	public Day03() {
		super("03");
	}
	
	@Override
	protected void solve(List<String> values) {
		
		m = new HashMap<Character, Integer> ();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (int i = 0; i < alphabet.length; i++) {
			m.put(alphabet[i], i+1);
		}
		
		String answerPart1 = solvePart1(values);
		printAnswer(answerPart1);
		
		String answerPart2 = solvePart2(values);
		printAnswer(answerPart2);
	}
	


	private String solvePart2(List<String> values) {
		int count = 0;
		int size = 0;
		String[] group = new String[3];
		while(size < values.size()) {
			for (int i = 0; i < group.length; i++) {
				size += 1;
				group[i] = values.get(size-1);
			}
			for (int i = 0; i < group[0].length(); i++) {
				char c = group[0].charAt(i);
				if(group[1].indexOf(c) != -1 && group[2].indexOf(c) != -1) {
					count += m.get(c);
					break;
				}
			}
			
		}
		return Integer.toString(count);
		
	}

	private String solvePart1(List<String> values) {
		int count = 0;
		for(String val : values) {
			int size = val.length();
			String compartment1 = val.substring(0, Math.round(size/2));
			String compartment2 = val.substring(Math.round(size/2), size);
			
			for (int i = 0; i < compartment1.length(); i++) {
				char c = compartment1.charAt(i);
				if (compartment2.indexOf(c) != -1) {
					count += m.get(c);
					break;
				}
			}
			
		}
		return Integer.toString(count);
		
	}
}
