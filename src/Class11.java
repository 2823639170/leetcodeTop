public class Class11 {

    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (r > l) {
            if (height[r] >= height[l]) {
                max = Math.max(max, height[l] * (r - l));
                l++;
            } else {
                max = Math.max(max, height[r] * (r - l));
                r--;
            }
        }
        return max;

    }
}
