package AOC22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day09 extends AOC22
{
	public Day09()
	{
		super("09");
	}

	protected void solve(List<String> input)
	{
		Set<Point> s1Visited = new HashSet<>();
		Set<Point> s2Visited = new HashSet<>();
		List<Point> snake1 = new ArrayList<>();
		List<Point> snake2 = new ArrayList<>();
		for(int i = 0; i < 2; i++)
			snake1.add(new Point(0, 0));
		for(int i = 0; i < 10; i++)
			snake2.add(new Point(0, 0));
		s1Visited.add(snake1.get(snake1.size() - 1));
		s2Visited.add(snake2.get(snake2.size() - 1));

		for(String s : input)
		{
			String[] parts = s.split(" ");
			Direction dir = switch(parts[0])
					{
						case "U" -> Direction.UP;
						case "D" -> Direction.DOWN;
						case "L" -> Direction.LEFT;
						default -> Direction.RIGHT;
					};
			for(int i = 0; i < Integer.parseInt(parts[1]); i++)
			{
				moveSnake(dir, snake1, s1Visited);
				moveSnake(dir, snake2, s2Visited);
			}
		}
		printAnswer(s1Visited.size());
		printAnswer(s2Visited.size());
	}



	private void moveSnake(Direction dir, List<Point> snake, Set<Point> visited)
	{
		Point head = snake.get(0);
		head = dir.movePointInDir(head);
		snake.set(0, head);
		for(int j = 1; j < snake.size(); j++)
		{
			head = snake.get(j - 1);
			Point tail = snake.get(j);
			int rowDif = Math.abs(head.row() - tail.row());
			int colDir = Math.abs(head.col() - tail.col());
			if(rowDif > colDir)
			{
				if(head.row() - tail.row() > 1)
					tail = new Point(tail.row() + 1, head.col());
				if(tail.row() - head.row() > 1)
					tail = new Point(tail.row() - 1, head.col());
			}
			else if(rowDif < colDir)
			{
				if(head.col() - tail.col() > 1)
					tail = new Point(head.row(), tail.col() + 1);
				if(tail.col() - head.col() > 1)
					tail = new Point(head.row(), tail.col() - 1);
			}
			else if(rowDif > 1)
			{
				if(head.row() - tail.row() > 1)
					tail = new Point(tail.row() + 1, tail.col());
				if(tail.row() - head.row() > 1)
					tail = new Point(tail.row() - 1, tail.col());
				if(head.col() - tail.col() > 1)
					tail = new Point(tail.row(), tail.col() + 1);
				if(tail.col() - head.col() > 1)
					tail = new Point(tail.row(), tail.col() - 1);
			}

			snake.set(j, tail);
			if(j == snake.size() - 1)
				visited.add(tail);
		}
	}

	private enum Direction
	{
		UP,
		DOWN,
		LEFT,
		RIGHT;

		public Point movePointInDir(Point p)
		{
			 switch(this)
					{
						case UP :
							return new Point(p.row() - 1, p.col());
						case DOWN :
							return new Point(p.row() + 1, p.col());
						case LEFT :
							return new Point(p.row(), p.col() - 1);
						case RIGHT :
							return new Point(p.row(), p.col() + 1);
					}
			 return null;
		}
	}
}


