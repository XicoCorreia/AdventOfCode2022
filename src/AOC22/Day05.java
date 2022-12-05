package AOC22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Day05 extends AOC22{

	protected Day05() {
		super("05");
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void solve(List<String> values) {
		List<Stack<Character>> stacks= new ArrayList<Stack<Character>>();
		
		for (int i = 0; i < 9; i++) {
			stacks.add(new Stack<Character>());
		}
		
		List<String> info = values.subList(0, 8);
		Collections.reverse(info);
		for(String s : info) {
			for(int i = 0; i < (s.length() + 1)/4; i++) {
				if(s.charAt(1 + i * 4) != ' ') {
					stacks.get(i).add(s.charAt(1 + i * 4));
				}
			}
		}
		

		List<Stack<Character>> copyStacks = new ArrayList<Stack<Character>>(); 

		for (int i = 0; i < 9; i++) {
			copyStacks.add((Stack<Character>) stacks.get(i).clone());
		}

		List<String> instructions = values.subList(10, values.size());
		
		
		for(String inst : instructions) {
			String[] parts = inst.split(" ");
			int toMove = Integer.valueOf(parts[1]);
			int from = Integer.valueOf(parts[3]) - 1;
			int to = Integer.valueOf(parts[5]) - 1;
			
			//Part1
			for(int i = 1; i <= toMove; i++) {
				char moving = stacks.get(from).pop();
				stacks.get(to).add(moving);
			}
			
			//Part2
			List<Character> moving = new ArrayList<Character>();
			for(int i = 1; i <= toMove; i++) {
				moving.add(copyStacks.get(from).pop());
			}
			
			Collections.reverse(moving);
			copyStacks.get(to).addAll(moving);
		}
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			sb.append(stacks.get(i).pop());
			sb2.append(copyStacks.get(i).pop());
		}
		printAnswer(sb.toString());
		printAnswer(sb2.toString());
		
	}


}
