package hakerrank;


//public class Solution {
//    public static void main(String[] args) {
//        int year = 1918;
//        LocalDate localDate;
//        String month;
//        if (year == 1918){
//            localDate = Year.of(year).atDay(256+13);
//        }else if (year % 100 == 0 && year < 1918){
//            localDate = Year.of(year).atDay(256+1);
//        }else {
//            localDate = Year.of(year).atDay(256);
//        }
//        if (String.valueOf(localDate.getMonthValue()).length()==1){
//            month = "0" + localDate.getMonthValue();
//        }else {
//            month = String.valueOf(localDate.getMonthValue());
//        }
//        return localDate.getMonthValue() + "." + month + "." + year;
//    }
//}
/*
* Buddy - наставник, помощник в адаптации нового сотрудника.

Лидер Трайба -  сотрудник отвечающий за управление продуктом или группой продуктов и достижение бизнес целей этого Трайба. Отвечает за ключевые показатели эффективности Трайба, в зависимости от его задач (напр. NPS , доля рынка, надежность систем) и т.д.

Следующий модуль - Кибербезопасность.
* */


//public class Solution {
//    public static void main(String[] args) {
//        int [] a = {1,2,2,3};
//        int res = 0;
//        Set<Integer> set = new HashSet<Integer>();
//        for (int i : a ){
//            if (set.contains(i)){
//                res++;
//                set.remove(i);
//
//
//            }else{
//                set.add(i);
//            }
//        }
//    }
//}


//public class Solution {
//    public static void main(String[] args) {
//        String s = "1";
//        s.charAt(1);
//    }
//
//
//}

//
//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//class Result {
//
//    /*
//     * Complete the 'simpleArraySum' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts INTEGER_ARRAY ar as parameter.
//     */
//
//    public static int simpleArraySum(List<Integer> a, List<Integer> b) {
//        int resA = 0;
//        int resB = 0;
//        List<Integer> result = new ArrayList<>(2);
//        for (int i = 0; i < a.size(); i++) {
//            if (a.get(i) > b.get(i)){
//                resA++;
//            }if (a.get(i) < b.get(i)){
//                resB++;
//            }
//        }
//        result.add(resA);
//        result.add(resB);
//        return result;
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.simpleArraySum(ar);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
//
//    int sum = 0;
//        for (int i :ar) {
//                sum += i;
//                }
//                return sum;
//
//import java.util.*;
//public class Solution {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Deque<Integer> deque = new ArrayDeque<>();
//        Set<Integer> unic = new HashSet<Integer>();
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int max = 0;
//        int temp;
//
//        for (int i = 0; i < n; i++) {
//            int num = in.nextInt();
//            deque.addFirst(num);
//            unic.add(num);
//            if (deque.size() == m){
//                if (unic.size()>max){
//                    max = unic.size();
//                }
//                temp = deque.removeFirst();
//                if (!deque.contains(temp)){
//                    unic.remove(temp);
//                }
//            }
//        } Integer.MIN_VALUE;
//        System.out.println(max);
//    }
//}
//
//
//
//
//
////
////
////import java.io.*;
////import java.util.*;
////import java.text.*;
////import java.math.*;
////import java.util.regex.*;
////
////
////public class Solution{
////    public static
////    public static Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\1>");
////    public static void main(String[] args){
////
////        Scanner in = new Scanner(System.in);
////        int testCases = Integer.parseInt(in.nextLine());
////        while(testCases>0){
////            String line = in.nextLine();
////            Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\1>");
////            Matcher matcher = pattern.matcher(line);
////            if (matcher.find()){
////                System.out.println(matcher.group(2));
////
////            }else{
////                System.out.println("NONE");
////            }x
////
////
////            testCases--;
////        }
////    }
////}
////
