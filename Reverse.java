public class Reverse {

    public static void main(String[] args) {
        int x = 1000000009;
        System.out.println(reverse(x));
    }
    static int reverse(int x){
        String a = x + "";
        String b = "";
        if (x >= 0) {
            for (int i = a.length() - 1; i >= 0; i--) {
                b = b + a.charAt(i);
            }
            try {
                int result = Integer.parseInt(b);
                return result;
            }catch (Exception e) {
                return 0; 
            } 
        }else{
            for (int i = a.length() - 1; i >= 1; i--) {
                b = b + a.charAt(i);
            }
            b = "-" + b;
            try {
                int result = Integer.parseInt(b);
                return result;
            } catch (Exception e) {
                return 0;
            }
        }
    }
}