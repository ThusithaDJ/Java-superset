package finalkeyword;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        final FinalObject obj = new FinalObject("name", 22);
//        System.out.println(obj);
//
//        try {
//            System.out.println("try");
//            return;
//        } finally {
//            System.out.println("finally");
//        }
        Integer val = Integer.valueOf(10);
        String s2 = "Strring";
        String s1 = "S1";
        String s3 = s2 + s1;

        Map<Integer, String> map = new HashMap<>();

        System.out.println("checking memory" + val + s3);

        int arr[][] = new int[][]{{0,1,0}, {1,1,0}, {1,0,1}};
//        Map<Integer, Integer> collect = Arrays.stream(arr).collect(Collectors.toMap(x -> x[0], x -> x[1], (oldV, newV) -> newV));
//        collect.forEach((k,v) -> System.out.println(k +"->"+v));

        Map<Integer, int[]> vl = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                vl.put(i, arr[i]);
            }
        }

        for (int i = 0; i < vl.size(); i++) {

        }
    }
}
