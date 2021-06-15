package hakerrank;

import java.math.BigInteger;
import java.util.*;
class BigDec {

    public static void main(String []args) {
        //Input
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        sc.close();
        BigInteger bigInt = new BigInteger(n);




    }

//    }    public static void main(String []args){
//        //Input
//        Scanner sc= new Scanner(System.in);
//        int n=sc.nextInt();
//        String []s=new String[n+2];
//        for(int i=0;i<n;i++){
//            s[i]=sc.next();
//        }
//        sc.close();
//        Comparator comparator = new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                if (s1 == null || s2 == null) {
//                    return 0;
//                }
//
//                BigDecimal bds1 = new BigDecimal(s1);
//                BigDecimal bds2 = new BigDecimal(s2);
//                return bds2.compareTo(bds2);
//            }
//        };
//        Arrays.sort(s, comparator );
//        BigInteger bigInt = new BigInteger(n);
//
//        //Output
//        for(int i=0;i<n;i++)
//        {
//            System.out.println(s[i]);
//        }
//    }

}