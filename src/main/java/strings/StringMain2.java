package strings;

import java.util.HashSet;
import java.util.Set;

public class StringMain2 {
    public static void main(String[] args) {
        String message = "abaacss";
        String finalText = "";

        byte []chars = message.getBytes();
        for(int i = 0; i < chars.length; i++) {
            char c = (char)chars[i];
            int oc = 1;
            int idx= i;
            for(int j = idx+1; j < chars.length; j++) {
                if (c != (char)chars[j]) {
                    finalText += String.valueOf(c)+oc;
                    break;
                }
                oc++;
            }
        }

//        Set<String> ts = new HashSet<>();
//        for(byte c : chars) {
//            String t = String.valueOf((char) c);
//            int i = 1;
//            if(ts.add(String.valueOf((char)c))) {
//                ts = new HashSet<>();
//                finalText += t;
//            } else {
//                i++;
//                t = t+i;
//            }
//        }

        for(int i = 0; i < chars.length; i++) {
            char c = (char)chars[i];
            Set<String> ts = new HashSet<>();
            for(int j = i; j < chars.length; j++) {
                String t = String.valueOf((char) c);
                int ii = 1;
                if(ts.add(String.valueOf((char)c))) {
                    ts = new HashSet<>();
                    finalText += t;
                } else {
                    ii++;
                    t = t+ii;
                }
            }
        }

        System.out.println(finalText);
    }
}
