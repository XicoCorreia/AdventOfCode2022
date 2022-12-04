package AOC22;
import java.util.List;

public class Day01 extends AOC22{

	public Day01()  {
		super("01");
	}

	@Override
	protected void solve(List<String> values) {
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
		String answer = Integer.toString((int) (top3[0] + top3[1] + top3[2]));
		printAnswer(answer);
	}		
}
