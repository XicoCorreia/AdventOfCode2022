import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("day3.txt"));
		String line;
		List<String> values = new ArrayList<String>();
		while((line = br.readLine()) != null) { values.add(line); }
		HashMap<Character, Integer> m = new HashMap<Character, Integer> ();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (int i = 0; i < alphabet.length; i++) {
			m.put(alphabet[i], i+1);
		}
		part1(values, m);
		part2(values, m);
	}

	private static void part2(List<String> values, HashMap<Character, Integer> m) {
		int count = 0;
		int size = 0;
		String[] group = new String[3];
		while(size < values.size()) {
			for (int i = 0; i < group.length; i++) {
				size += 1;
				group[i] = values.get(size-1);
				System.out.println(group[i]);
			}
		for (int i = 0; i < group[0].length(); i++) {
			char c = group[0].charAt(i);
			if(group[1].indexOf(c) != -1 && group[2].indexOf(c) != -1) {
				count += m.get(c);
				break;
			}
		}

			
		}


		System.out.println(count);
		
	}

	private static void part1(List<String> values, HashMap<Character, Integer> m) {
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
		System.out.println(count);
		
	}
}
