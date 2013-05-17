import java.io.*;
import java.util.LinkedList;
import java.util.List;


/**
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
      int iterations=nextInt();
        List<Integer> positions=new LinkedList<Integer>();
        for(int i = 0;i<iterations;i++){
            int position=nextInt();
            positions.add(position);
        }
        for(int pos:positions){
            System.out.print(ifFLoored(reverseByN(pos))+" ");
        }





    }


    int calcIterations(int n){
        int position_1=(n*n+n+2)/2;
        return position_1;
    }
    long reverseByN(int i){
        double n=0;
        n=(-1+Math.sqrt(1-8*(1-i)))/2  ;
        return (long)n;
    }
    int  ifFLoored(double n){
        if(n==1 || n==0) {
            return 1;
        }
     if((n-Math.floor(n))==0){
         return 1;
     }
        return 0;
    }


}


