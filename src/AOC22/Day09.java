package AOC22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day09 extends AOC22{

	public HashSet<Point> visited;
	Point head;
	Point tail;
	
	protected Day09() {
		super("09");
	}

	@Override
	protected void solve(List<String> values) {
		visited = new HashSet<Point>();
		head = new Point(0,0);
		tail = new Point(0,0);
		visited.add(new Point(0,0));
		
		for(String val : values) {
			String[] parts = val.split(" ");
			int n = Integer.valueOf(parts[1]);
			int i = 0;
			follow(n,i,parts[0].charAt(0));
		}
		printAnswer(Integer.toString(visited.size()));
	}
	
	private void follow(int n, int i, char dir) {
		while (i < n) {
			if(dir == 'U') { head.incX(); }
			else if(dir == 'D') { head.decX(); }
			else if(dir == 'R') { head.incY(); }
			else { head.decY(); }
					
			if(adjacent(head, tail)) {
				i++;
				continue;
			}
			if(head.x == tail.x)
				if(head.y > tail.y)
					tail.incY();
				else
					tail.decY();
			else if (head.y == tail.y)
				if(head.x > tail.x)
					tail.incX();
				else
					tail.decX();
			else if(head.y > tail.y){
				if(head.x > tail.x) {
					tail.incX();
					tail.incY();
				}
				else {
					tail.decX();
					tail.incY();
				}
			}
			else if(head.y < tail.y){
				if(head.x > tail.x) {
					tail.incX();
					tail.decY();
				}
				else {
					tail.decX();
					tail.decY();
				}
			}		
			i++;
			visited.add(new Point(tail.x,tail.y));
		}	
	}
	
	private boolean adjacent(Point head, Point tail) {	
		return (head.x == tail.x || head.x == tail.x + 1 || head.x == tail.x - 1) &&
				(head.y == tail.y - 1 || head.y == tail.y + 1 || head.y == tail.y);
	}

	private class Point{
		
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void incX() {
			this.x ++;
		}

		public void incY() {
			this.y ++;
		}
		public void decX() {
			this.x --;
		}

		public void decY() {
			this.y --;
		}
		
		@Override
		public boolean equals(Object obj) {
			return (obj instanceof Point && ((Point) obj).x == this.x && ((Point) obj).y == this.y); 
		}
		
		@Override
		public int hashCode() {
			return x*x + y*y;
		}
	}

}
