import java.io.*;
import java.util.*;
/**
 * 
 * {@link http://acm.timus.ru/problem.aspx?space=1&num=1100}
 * */
public class Main {

	StreamTokenizer in;
	PrintWriter out;

	public static void main(String[] args) {

		new Main().run();
	}

	public void run() {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(
				System.in)));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		try {
			solve();
		} catch (IOException e) {
			out.println("Input integer");
		} finally {
			out.flush();
			out.close();
		}
	}

	int nextInt() throws IOException {
		in.nextToken();
		return (int) in.nval;
	}

	public void solve() throws IOException {
		int N,commandId,resolveProblem;
		List<CommandStudent> commands=new ArrayList<CommandStudent>();

		N = nextInt();
		
		for (int i = 0; i < N; i++) {
			commandId=nextInt();
			resolveProblem=nextInt();
			commands.add(new CommandStudent(commandId, resolveProblem));
		}
		Collections.sort(commands);
		for(CommandStudent cs:commands){
			out.println(cs);
		}
	

	
	}


	class CommandStudent implements Comparable {
		int commandID;
		int solvedProblems;
		
		public CommandStudent (int ID,int solvedProblems){
			this.commandID=ID;
			this.solvedProblems=solvedProblems;
		}
			
		public String toString() {
			String t;
			t=commandID+" "+solvedProblems;
			return t;
		}

		public int compareTo(Object o) {
			CommandStudent that=(CommandStudent)o;
			return -(this.solvedProblems-that.solvedProblems);
		}

	}
}
