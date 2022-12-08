package AOC22;

import java.util.ArrayList;
import java.util.List;

public class Day08 extends AOC22{

	protected Day08() {
		super("08");
	}

	@Override
	protected void solve(List<String> values) {
		List<char[]> trees = new ArrayList<char[]>();
		for(String val : values) {
			trees.add(val.toCharArray());
		}
		
		//Part 1
		int answer = 0;
		
		for (int i = 0; i < trees.size(); i++) {
			for (int j = 0; j < trees.get(i).length; j++) {
				//Check sides
				if(i == 0 || i == trees.size()-1 || j == 0 || j == trees.get(i).length - 1) {
					answer ++;
					continue;
				}
				int tree = Character.getNumericValue(trees.get(i)[j]);
				boolean visible = true;
				
				//Down
				for (int n = i + 1; n < trees.size() && visible; n++) {
					visible = tree <= Character.getNumericValue(trees.get(n)[j]) ? false : true;
				}
				if(visible) {
					answer++;
					continue;
				}
				visible = true;
				
				//Up
				for (int n = i - 1; n >= 0 && visible; n--) {
					visible = tree <= Character.getNumericValue(trees.get(n)[j]) ? false : true;
				}
				if(visible) {
					answer++;
					continue;
				}
				visible = true;
				
				//Right
				for (int n = j + 1; n < trees.get(i).length && visible; n++) {
					visible = tree <= Character.getNumericValue(trees.get(i)[n]) ? false : true;
				}
				if(visible) {
					answer++;
					continue;
				}
				visible = true;
				
				//Left
				for (int n = j - 1; n >= 0 && visible;n--) {
					visible = tree <= Character.getNumericValue(trees.get(i)[n]) ? false : true;
				}
				if(visible) {
					answer++;
					continue;
				}
			}
		}
		
		printAnswer(Integer.toString(answer));
		
		//Part 2
		int answer2 = 0;
		
		for (int i = 0; i < trees.size(); i++) {
			for (int j = 0; j < trees.get(i).length; j++) {
				int tree = Character.getNumericValue(trees.get(i)[j]);
				int total = 0;
				int[] viewDist = {0,0,0,0};


				//Down
				for (int n = i + 1; n < trees.size(); n++) {
					if(tree > Character.getNumericValue(trees.get(n)[j])) {
						viewDist[0]++;
					}
					else {
						viewDist[0]++;
						break;
					}
				}
				
				//Up
				for (int n = i - 1; n >= 0; n--) {
					if(tree > Character.getNumericValue(trees.get(n)[j])) {
						viewDist[1]++;
					}
					else {
						viewDist[1]++;
						break;
					}
				}

				//Right
				for (int n = j + 1; n < trees.get(i).length ; n++) {
					if(tree > Character.getNumericValue(trees.get(i)[n])) {
						viewDist[2]++;
					}
					else {
						viewDist[2]++;
						break;
					}
				}
				
				//Left
				for (int n = j - 1; n >= 0; n--) {
					if(tree > Character.getNumericValue(trees.get(i)[n])) {
						viewDist[3]++;
					}
					else {
						viewDist[3]++;
						break;
					}
				}
				
				total = viewDist[0] * viewDist[1] * viewDist[2] * viewDist[3];	
				answer2 = total > answer2 ? total : answer2;		
			}
		}
		printAnswer(Integer.toString(answer2));
	}

}
