public class Class08 {

    public static void main(String[] args) {
        String s = "42";
        String s1 = "-91283472332";
        String s2 = "2147483648";
//        System.out.println(myAtoi(s));
        System.out.println(myAtoi(s2));
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        if ( s.length() == 0) {
            return 0;
        }
        boolean isPositive = true;
        char[] array = s.toCharArray();
        int index = 0;
        if (s.charAt(0) == '-') {
            isPositive = false;
            index = 1;
        } else if (s.charAt(0) == '+') {
            index = 1;
        }
        for (; index < s.length(); index++) {
            if (array[index] != '0') {
                break;
            }
        }
        int res = 0;
        int x1 = -Integer.MAX_VALUE / 10;
        int x2 = -Integer.MAX_VALUE % 10;
        int x3 = x2 - 1;
        for ( ; index < array.length; index++) {
            if (array[index]<'0' || array[index]>'9') {
                break;
            }
            int num = -(array[index] - '0');
            if (isPositive && (res < x1 || res == x1 && num < x2)) {
                return Integer.MAX_VALUE;
            }
            if (!isPositive && (res < x1 || res == x1 && num < x3)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + num;
        }
        return isPositive ? -res : res;
    }

}
