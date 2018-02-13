import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/* https://open.kattis.com/contests/kpngon/problems/allaboutthatbase */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("C:\\Users\\betsy\\Desktop\\tests.txt");
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        int t=0;
        while(t<tests){

            //String[] st = s.split("\\s");
            boolean flag = false;
            boolean zero = false;
            String[] first = in.next().split("");
            String op = in.next();
            String[] second = in.next().split("");
            in.next();
            String[] last = in.next().split("");

            char[] c1 = {'1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h'
                    ,'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0'};
            ArrayList<Character> c = new ArrayList<Character>(36);
            for(int i = 0;i<36;i++){
                c.add(c1[i]);
            }
            int max = 0;
            for(String p:first){
                if(!p.equals("0"))
                max = Math.max(max,c.indexOf(p.charAt(0)));
                else
                    zero = true;
            }
            for(String p:second){
                if(!p.equals("0"))
               max = Math.max(max,c.indexOf(p.charAt(0)));
                else zero = true;
            }
            for(String p:last){
                if(!p.equals("0"))
                max = Math.max(max,c.indexOf(p.charAt(0)));
                else zero = true;
            }
            //System.out.println(max);
            max++;
            if(max!=1||zero)
                max++;
            while(max<=36){
                long n1 = 0;
                long n2 = 0;
                long n3 = 0;
                long n =4294967295L;

                int k = 0;
                for(int i = first.length-1;i>=0;i--){
                    if(n1>n)
                        break;
                    if(first[i].charAt(0)!='0')
                    n1+= (c.indexOf(first[i].charAt(0))+1) * Math.pow((double)max,(double)k);


                    k++;
                }
                k=0;
                for(int i = second.length-1;i>=0;i--){
                    if(n2>n)
                        break;
                    if(second[i].charAt(0)!='0')
                    n2+= (c.indexOf(second[i].charAt(0))+1) * Math.pow((double)max,(double)k);
                    k++;
                }
                k=0;
                for(int i = last.length-1;i>=0;i--){
                    if(n3>n)
                        break;
                    if(last[i].charAt(0)!='0')
                    n3+= (c.indexOf(last[i].charAt(0))+1) * Math.pow((double)max,(double)k);
                    k++;
                }
               // System.out.println(n1+" "+n2+" "+ n3);
                //System.out.println(op);
                if(n1<=n&&n2<=n&&n3<=n&&n1>0&&n2>0&&n3>0) {
                    if (op.equals("+")) {
                        if (n1 + n2 <= n) {
                            if (n1 + n2 == n3) {
                                System.out.print(c.get(max - 1));
                                flag = true;
                            }
                        }
                    }
                    if (op.equals("-")) {
                        if (n1 - n2 <= (n)&&n1-n2>0) {
                            if (n1 - n2 == n3) {
                                System.out.print(c.get(max - 1));
                                flag = true;
                            }
                        }
                    }
                    if (op.equals("/")) {
                        if (n1 / n2 <= n) {
                            double n4 = (double) n1 / (double) n2;
                            if (n4 == (double) n3) {
                                System.out.print(c.get(max - 1));
                                flag = true;
                            }
                        }
                    }
                    if (op.equals("*")) {
                        if (n1 * n2 <= n) {
                            if (n1 * n2 == n3) {
                                System.out.print(c.get(max - 1));
                                flag = true;
                            }
                        }
                    }
                }
               // System.out.println(n1 + " " + n2 + " " + n3 + " " + (n1-n2));
                max++;
            }
           if(!flag)
                System.out.print("invalid");
            if(t!=tests-1)
                System.out.println();
            t++;
        }
    }
}
