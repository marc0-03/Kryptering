public class Kryp1 {
    public static void main(String[] args) {
        String message = "fart";
        String BigKey = "dart";

        System.out.println("---------");
        int n = 0;
        for (int i = 0; i<message.length(); i++) {
            if (n>=BigKey.length()) {
                n = 0;
            }
            System.out.println(Integer.toBinaryString(message.charAt(i)) + message.charAt(i));
            System.out.println(Integer.toBinaryString(BigKey.charAt(n)) + BigKey.charAt(n));
            String s = Integer.toBinaryString(message.charAt(i) ^ BigKey.charAt(n));
            while (s.length()<7){
                s="0"+s;
            }
            System.out.println(s +((char) Integer.parseInt(s,2)) + "\n");
            n++;
        }

        System.out.println("---------");
    }
}
