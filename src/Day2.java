import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("day2.txt"));
		String line;
		List<String> values = new ArrayList<String>();
		while((line = br.readLine()) != null) { values.add(line); }
		part1(values);
		part2(values);
		br.close();
	}

	private static void part1(List<String> values) {
		long score = 0;
		
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
		
		System.out.println(score);
	}
	
	private static void part2(List<String> values) {
		long score = 0;
		
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
		
		System.out.println(score);
	}
}
