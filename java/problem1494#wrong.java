import java.io.*;
import java.util.LinkedList;


/**
 * @link http://acm.timus.ru/problem.aspx?space=1&num=1494
 * @author rubaka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        new Main().run();
    }

    StreamTokenizer in;
    PrintWriter out;

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    String nextString() throws IOException {
        in.nextToken();
        return (String) in.sval;
    }

    void run() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(
                System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }


    void solve() throws IOException {
        int reads = nextInt();
        Mono m = new Mono();
        for (int i = 0; i < reads; i++) {
            int elem = nextInt();
            m.pushElem(elem);
        }
     //   System.out.println(m.container);
        if (m.isProof()) {
            System.out.println("Not a proof");
        } else {
            System.out.println("Cheater");
        }
        return;


    }

}

class Mono {
    public LinkedList<Integer> container = new LinkedList<Integer>();

    public void pushElem(Integer elem) {

        if (container.isEmpty()) {
            container.add(elem);
        } else if (Math.abs(container.getLast() - elem) == 1) {
            container.removeLast();
        } else {
            container.add(elem);
        }
    }

    public boolean isProof() {
        return (container.isEmpty() || container.getLast()==1);
    }
