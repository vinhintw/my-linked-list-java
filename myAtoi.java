public class myAtoi {
  public static void main(String[] args) {
        String x = "+-12";
        
        System.out.println(aToi(x));
    }
    static int aToi(String x){
        x = x.trim();
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int negative = 0;
        long ans = 0;        
        for (int i =0; i < x.length(); i++) {
            if(x.charAt(i) == '-'){
                negative ++;
            }
            if ('0' <= x.charAt(i) && x.charAt(i) <= '9') {
                ans = ans*10 + (x.charAt(i)-'0');
            } 
        }
            if (negative>0) {
                ans = -ans;
            }
            if (ans > max) {
                return max;
            }
            if (ans < min) {
                return min;
            }
            return (int) ans;
    }
}