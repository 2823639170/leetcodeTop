public class Class07 {


    public int reverse(int x) {

        boolean isBiggerZero = true;
        if(x == 0){
            return 0;
        }
        if(x>0){
            isBiggerZero = false;
            x = -x;
        }
        int x1 = Integer.MIN_VALUE/10;
        int x2 = Integer.MIN_VALUE%10;
        int res = 0;
        while(x != 0){

            if(res < x1 || res == x1 && x%10<x2){
                return 0;
            }
            res = res*10+x%10;
            x/=10;

        }
        return isBiggerZero ? res : -res;



    }
}
