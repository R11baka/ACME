import java.io.*;
import java.util.*;

/**
 *
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
    BufferedReader in1;
    PrintWriter out;

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    String nextString() throws IOException {

        in.nextToken();
        return  (String)in.sval;
    }

   int next()throws IOException  {
       return in.nextToken();
   }



    void run() throws IOException {
       // in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in1 = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }

    void solve() throws IOException {
        //String myLine=in1.readLine();
        String[] data = in1.readLine().split(" ");
        int Number=Integer.parseInt(data[0]);
        int k=data[1].length();
      //  System.out.println(Number);
       // System.out.println(Fac);
      //  int k=Fac.length();
        System.out.println(specFac(Number,k));
    }

    int factorial(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }

    }
    int specFac(int i,int k){
        if(k==0) throw new IllegalArgumentException("K must be not  zero");
        int remainder=i%k;
        if(i<=k){
            if(remainder==0) return k;
            else return remainder;
        }      else{
            return i*specFac((i-k),k);
        }

    }
}




