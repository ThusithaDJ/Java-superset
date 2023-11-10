package strings;

public class StringsMain {
    public static void main(String[] args) {
        String text = "baava";
        long n = 5;
        long result = 0;
        int ac = 0;
        byte[] b = text.getBytes();
        for (int i = 0; i < b.length; i++) {
            if ((char)b[i] == 'a') {
                ac++;
            }
        }

        if (n % text.length() == 0) {
            result = (long)(n/text.length()) * ac;
        } else {
            int sac = 0;
            String sub = text.substring(0, (int) (n % text.length()));
            for (int i = 0; i < sub.getBytes().length; i++) {
                if ((char)b[i] == 'a') {
                    sac++;
                }
            }
            result = (long)((n/text.length()) * ac) + sac;
        }
        System.out.println(result);
    }

}
