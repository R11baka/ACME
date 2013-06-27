import java.io.*;
import java.util.*;

/**
 * 
 *  {@link http://acm.timus.ru/problem.aspx?space=1&num=1083}
 * 
 * */

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
        in1 = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }

    void solve() throws IOException {
       
        String[] data = in1.readLine().split(" ");
        int Number=Integer.parseInt(data[0]);
        int k=data[1].length();      
        System.out.println(specFac(Number,k));
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




