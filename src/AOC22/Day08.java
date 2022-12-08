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
		int count = 0;
		for(String val : values) {
			trees.add(val.toCharArray());
		}
		
		for (int i = 0; i < trees.size(); i++) {
			for (int j = 0; j < trees.get(i).length; j++) {
				//Check sides
				if(i == 0 || i == trees.size()-1 || j == 0 || j == trees.get(i).length - 1) {
					count ++;
					continue;
				}
				int tree = Character.getNumericValue(trees.get(i)[j]);
				boolean visible = true;
				
				//Down
				for (int n = i + 1; n < trees.size() && visible; n++) {
					visible = tree <= Character.getNumericValue(trees.get(n)[j]) ? false : true;
				}
				if(visible) {
					count++;
					continue;
				}
				visible = true;
				
				//Up
				for (int n = i - 1; n >= 0 && visible; n--) {
					visible = tree <= Character.getNumericValue(trees.get(n)[j]) ? false : true;
				}
				if(visible) {
					count++;
					continue;
				}
				visible = true;
				//Right
				for (int n = j + 1; n < trees.get(i).length && visible; n++) {
					visible = tree <= Character.getNumericValue(trees.get(i)[n]) ? false : true;
				}
				if(visible) {
					count++;
					continue;
				}
				visible = true;
				//Left
				for (int n = j - 1; n >= 0 && visible;n--) {
					visible = tree <= Character.getNumericValue(trees.get(i)[n]) ? false : true;
				}
				if(visible) {
					count++;
					continue;
				}
			}
		}
		
		printAnswer(Integer.toString(count));
		
		int answer = 0;
		
		for (int i = 0; i < trees.size(); i++) {
			for (int j = 0; j < trees.get(i).length; j++) {
				int c = 0;
				int total = 0;
				int tree = Character.getNumericValue(trees.get(i)[j]);
				//
				//Baixo
				for (int n = i + 1; n < trees.size(); n++) {
					if(tree > Character.getNumericValue(trees.get(n)[j])) {
						c++;
					}
					else {
						c++;
						break;
					}
				}
				total = c;
				c = 0;
				
				//Cima
				for (int n = i - 1; n >= 0; n--) {
					if(tree > Character.getNumericValue(trees.get(n)[j])) {
						c++;
					}
					else {
						c++;
						break;
					}
				}
				
				total *= c;
				c = 0;

				//Direita
				for (int n = j + 1; n < trees.get(i).length ; n++) {
					if(tree > Character.getNumericValue(trees.get(i)[n])) {
						c++;
					}
					else {
						c++;
						break;
					}
				}
				total *= c;
				c = 0;
				for (int n = j - 1; n >= 0; n--) {
					if(tree > Character.getNumericValue(trees.get(i)[n])) {
						c++;
					}
					else {
						c++;
						break;
					}
				}
				total *= c;
				
				if(total > answer) {
					answer = total;
				}		
			}
		}
		printAnswer(Integer.toString(answer));
	}

}
