import java.io.*;
import java.util.*;

/**
 * @link http://acm.timus.ru/problem.aspx?space=1&num=1439
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
    BufferedReader in1;

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    String nextString() throws IOException {

        in.nextToken();
        return (String) in.sval;
    }

    void readIteration(SegmentTreeRoom t,ArrayList<Integer> listRoom) throws IOException {

        String action=nextString();
        int numberRoom=nextInt();

        if (action.equals("D")) {
            t.deleteRoom(t,listRoom,numberRoom);

        } else if (action.equals("L")) {
           t.lookRoom(listRoom,numberRoom);
        }


    }

    void run() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }

    void solve() throws IOException {

        int MaxNumbersRoom = nextInt();
        int reads = nextInt();
        SegmentTreeRoom roomTree=new SegmentTreeRoom(MaxNumbersRoom);
        ArrayList<Integer> roomList=new ArrayList<Integer>(MaxNumbersRoom);
        for(int i=1;i<MaxNumbersRoom;i++){
            roomList.add(i);
        }
      //  System.out.println(roomList);

        for (int i = 0; i < reads; i++) {
            readIteration(roomTree,roomList);
        }


    }
}

class SegmentTreeRoom {

    // specific code
    static final int INIT_VALUE = 0;
    static final int NEUTRAL_VALUE = Integer.MIN_VALUE;
    static final int NEUTRAL_DELTA = 0;

    static int joinValues(int leftValue, int rightValue) {
        return Math.max(leftValue, rightValue);
    }

    static int joinDeltas(int oldDelta, int newDelta) {
        return oldDelta + newDelta;
    }

    static int joinValueWithDelta(int value, int delta, int length) {
        return value + delta;
    }

    int n;
    int[] value;
    int[] delta; // affects only child roots



    public SegmentTreeRoom(int n) {
        this.n = n;
        value = new int[4 * n];
        delta = new int[4 * n];
        init(0, 0, n - 1);
    }

    public int sizeTree(){
        return n;
    }

    public void init(int root, int left, int right) {
        if (left == right) {
            value[root] = INIT_VALUE;
            delta[root] = NEUTRAL_DELTA;
        } else {
            init(2 * root + 1, left, (left + right) / 2);
            init(2 * root + 2, (left + right) / 2 + 1, right);
            value[root] = joinValues(value[2 * root + 1], value[2 * root + 2]);
            delta[root] = NEUTRAL_DELTA;
        }
    }


    void applyDelta(int root, int delta, int length) {
        value[root] = joinValueWithDelta(value[root], delta, length);
        this.delta[root] = joinDeltas(this.delta[root], delta);
    }

    void pushDelta(int root, int left, int right) {
        int middle = (left + right) / 2;
        applyDelta(2 * root + 1, delta[root], middle - left + 1);
        applyDelta(2 * root + 2, delta[root], right - middle);
        delta[root] = NEUTRAL_DELTA;
    }


    public int query(int a, int b) {
        return query(a, b, 0, 0, n - 1);
    }

    int query(int a, int b, int root, int left, int right) {
        if (a > right || b < left)
            return NEUTRAL_VALUE;
        if (a <= left && right <= b)
            return value[root];
        pushDelta(root, left, right);
        return joinValues(query(a, b, root * 2 + 1, left, (left + right) / 2),
                query(a, b, root * 2 + 2, (left + right) / 2 + 1, right));
    }

    public void modify(int a, int b, int delta) {
        modify(a, b, delta, 0, 0, n - 1);
    }

    void modify(int a, int b, int delta, int root, int left, int right) {
        if (a > right || b < left)
            return;
        if (a <= left && right <= b) {
            applyDelta(root, delta, right - left + 1);
            return;
        }
        pushDelta(root, left, right);
        modify(a, b, delta, 2 * root + 1, left, (left + right) / 2);
        modify(a, b, delta, 2 * root + 2, (left + right) / 2 + 1, right);
        value[root] = joinValues(value[2 * root + 1], value[2 * root + 2]);
    }

    public void deleteRoom(SegmentTreeRoom t,ArrayList<Integer> l,int numberRoom){
        int delta=-1;
        t.modify(numberRoom,t.sizeTree(),delta);
        l.remove(numberRoom-1);
        l.add(l.get(l.size()-1)+1);
        //   System.out.println(l);

    }

    public void lookRoom(ArrayList<Integer> x,Integer numberRoom){
       /* if(numberRoom<0 && x.size()>numberRoom){
            throw  new IllegalArgumentException("Index not valid");
        }*/

        System.out.println(x.get(numberRoom-1));
    }



}

