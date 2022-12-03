import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("day1.txt"));
		String line;
		List<String> values = new ArrayList<String>();
		while((line = br.readLine()) != null) { values.add(line); }
		part1(values);
		br.close();
	}

	private static void part1(List<String> values) {
		long top3[] = {0, 0, 0};
		long count = 0;
		for (String v : values) {
			if(v.equals("")) {
				if(count > top3[0]) {
					top3[2] = top3[1];
					top3[1] = top3[0];
					top3[0] = count;
				}
				else if(count > top3[1]) {
					top3[2] = top3[1];
					top3[1] = count;
				}
				else if(count > top3[2]) {
					top3[2] = count;
				}
				count = 0;	
			}
			else {
				int val = Integer.valueOf(v);
				count += val;
			}
		}
		System.out.println(top3[0] + " " + top3[1] + " " + top3[2]);
		System.out.println(top3[0] + top3[1] + top3[2]);
		
	}
}
