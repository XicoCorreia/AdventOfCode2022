package AOC22;

import java.util.ArrayList;
import java.util.List;

public class Day07 extends AOC22{

	protected Day07() {
		super("07");
	}

	@Override
	protected void solve(List<String> values) {
		//Part 1
		
		Folder root = new Folder();
		root.name = "/";
		Folder currentFolder = root;
		boolean first = true;
		
		for(String val : values) {
			if(first) {
				first = false;
				continue;
			}
			String[] parts = val.split(" ");
			
			if(parts[0].equals("$")) {
				if(parts[1].equals("cd")) {
					if(parts[2].equals("..")) {
						currentFolder = currentFolder.parent;
					}
					else if(parts[2].equals("/")) {
						currentFolder = root;
					}
					else {
						for(Node n : currentFolder.contents) {
							if(n.name.equals(parts[2]) && n instanceof Folder) {
								currentFolder = (Folder)n;
							}
						}
					}
				}
			}
			else if (parts[0].equals("dir")) {
				Folder newFolder = new Folder();
				newFolder.name = parts[1];
				newFolder.parent = currentFolder;
				currentFolder.contents.add(newFolder);
			}
			else {
				File file = new File();
				file.name = parts[1];
				file.parent = currentFolder;
				file.size = Integer.parseInt(parts[0]);
				currentFolder.contents.add(file);
			}
			
		}
		long answer = 0;
		List<Folder> folders = root.getSubFolders();
		
		while(folders.size() > 0) {
			Folder f = folders.remove(0);
			folders.addAll(f.getSubFolders());
			long size = f.getSize();
			if(size <= 100000)
				answer += size;
		}
		printAnswer(Long.toString(answer));
		
		//Part 2
		long availableSpace = 70000000 - root.getSize();
		long spaceToDelete = 30000000 - availableSpace;
		
		long answer2 = Integer.MAX_VALUE;
		folders.clear();
		folders = root.getSubFolders();
		
		while(folders.size() > 0) {
			Folder f = folders.remove(0);
			folders.addAll(f.getSubFolders());
			long size = f.getSize();
			if(spaceToDelete <= size && size < answer2)
				answer2 = size;
		}
		printAnswer(Long.toString(answer2));
	}
	
	public static abstract class Node
	{
		public Folder parent;
		public String name;

		public abstract long getSize();
	}
	
	public static class File extends Node{
		public long size;

		public long getSize() {
			return size;
		}
	}
	public static class Folder extends Node{
		List<Node> contents = new ArrayList<Node>();
		
		public List<Folder> getSubFolders() {
			List<Folder> folders = new ArrayList<>();
			for(Node n : contents)
				if(n instanceof Folder)
					folders.add((Folder) n);
			return folders;
		}
		
		public long getSize() {
			long size = 0;
			for(Node n : contents) {
				size += n.getSize();
			}
			return size;
		}
		
	}
}
