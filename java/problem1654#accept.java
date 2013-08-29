import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * @link http://acm.timus.ru/problem.aspx?space=1&num=1654
 * */
public class Main {

	/**
	 * @param args
	 */
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

	String nextString() throws IOException {
		in.nextToken();
		return (String) in.sval;
	}

	public void solve() throws IOException {
		String shifr = nextString();
		char[] arr = shifr.toCharArray();
		Stack<Character> st = new Stack<Character>();

		for (char s : arr) {
			if (st.isEmpty() == false) {
				if(st.peek()==s){
					st.pop();
					
				}
				else{
					st.push(s);
				}
			}
			else {
				st.push(s);
			}
			
		}
		
		for(char c:st){
			out.print(c);
		}
		
		
	}

}
