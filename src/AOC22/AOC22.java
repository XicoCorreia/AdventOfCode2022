package AOC22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AOC22 {
	
	private String day;
	private int part = 1;
	protected AOC22(String day) {
		this.day = day;
		
		File input = new File("res/day" + this.day + ".txt");
		//File input = new File("res/test.txt");	
		
		if(!input.exists()) {
			System.err.println("File doesn't exist!");
			return;
		}
		
		BufferedReader br;
		try 
		{
			br = new BufferedReader(new FileReader(input));	
			
		} catch(FileNotFoundException e) 
		{
			System.err.println("File not found!");
			return;
		}
		
		List<String> values = new ArrayList<String>();
		try 
		{
			String line;
			while((line = br.readLine()) != null) { values.add(line);}
			br.close();
			
		} catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		solve(values);
	}
	
	protected abstract void solve(List<String> values);
	
	protected void printAnswer(String answer) {
		System.out.println("The answer for part " + part + " of day " + day + " is " + answer);
		part++;
	}
	
	protected void printAnswer(int answer) {
		System.out.println("The answer for part " + part + " of day " + day + " is " + answer);
		part++;
	}
	

}