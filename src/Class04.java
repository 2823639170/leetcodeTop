public class Class04 {

    public static void main(String[] args) {
        int[] arr1 = {1,4,5 };
        int[] arr2 = {2,3,6};
//        System.out.println(findMedianSortedArrays(arr1, arr2));
        System.out.println(findMedianSortedArrays2(arr1, arr2));
    }

    /**
     * 自然解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;

        boolean isTwo = false;
        int mid = len / 2 + 1;
        if (len % 2 == 0) {
            isTwo = true;
        }
        int i1 = 0;
        int i2 = 0;
        int cur = 0;
        int pre = 0;
        System.out.println(mid);
        for (int i = 0; i < mid; i++) {
            if (i1 < nums1.length && i2 < nums2.length) {
                if (nums1[i1] <= nums2[i2]) {

                    cur = nums1[i1];
                    i1++;
                    System.out.println("1===:");
                } else {
                    cur = nums2[i2];
                    i2++;
                    System.out.println("2===:");
                }
            } else if (i1 < nums1.length) {
                cur = nums1[i1];
                i1++;
                System.out.println("3===:");

            } else if (i2 < nums2.length) {
                cur = nums2[i2];
                i2++;
                System.out.println("===:");

            }
            if (i == mid - 2 && isTwo) {
                pre = cur;
            }
            System.out.println(cur);
        }
        if (isTwo) {
            return (pre + cur + 0.0) / 2;
        }
        return cur;
    }

    /**
     * 最优解,并且可以有方法可以复用
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(nums1==null ||nums1.length == 0){
            if(nums2.length%2==0){
                return (nums2[nums2.length/2]+nums2[nums2.length/2-1]+0.0)/2;
            }
            return  nums2[nums2.length/2];
        }
        if(nums2==null ||nums2.length == 0){
            if(nums1.length%2==0){
                return (nums1[nums1.length/2]+nums1[nums1.length/2-1]+0.0)/2;
            }
            return  nums1[nums1.length/2];

        }
        if (len % 2 == 0) {
            return (findTwoArrK(nums1, nums2, len / 2) + findTwoArrK(nums1, nums2, len/2+1) + 0.0) / 2;
        }
        return findTwoArrK(nums1, nums2, len / 2 + 1);

    }

    /**
     * 找到两个数组中第k小的数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findTwoArrK(int[] nums1, int[] nums2, int k) {

        if (nums1.length > nums2.length) {
            int[] help = nums1;
            nums1 = nums2;
            nums2 = help;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;
        if (len1 >= k) {
            System.out.println(findMidNum(nums1, 0, k - 1, nums2, 0, k - 1));
            return findMidNum(nums1, 0, k - 1, nums2, 0, k - 1);
        }
        if (len1 < k && k <= len2) {
            if (nums2[k - len1 - 1] >= nums1[len1 - 1]) {
                return nums2[k - len1 - 1];
            }
            return findMidNum(nums1, 0, len1 - 1, nums2, k - len1, k - 1);
        }
        if (k > len2) {
            if (nums1[k - len2 - 1] >= nums2[len2 - 1]) {
                return nums1[k - len2 - 1];
            }
            if (nums2[k - len1 - 1] >= nums1[len1 - 1]) {
                return nums2[k - len1 - 1];
            }
            return findMidNum(nums1, k - len2, len1 - 1, nums2, k - len1, len2 - 1);
        }
        return -1;
    }

    /**
     * 找到两个区间长度相同的数组的上中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findMidNum(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2) {

        if (r1 == l1) {
            return Math.min(nums1[l1], nums2[l2]);
        }

        int mid1 = (l1 + r1) / 2;
        int mid2 = (l2 + r2) / 2;
        //是奇数还是偶数
        if ((r1 - l1 + 1) % 2 == 0) {
//            System.out.println("===========");
//            System.out.println(mid1);
//            System.out.println(r1);
//            System.out.println(l2);
//            System.out.println(mid2);
//            System.out.println("------");
//            System.out.println(nums1[mid1]);
//            System.out.println(nums2[mid2]);
            if (nums1[mid1] == nums2[mid2]) {
                return nums1[mid1];
            } else if (nums1[mid1] > nums2[mid2]) {
                return findMidNum(nums1, l1, mid1, nums2, mid2 + 1, r2);
            } else {
                System.out.println("===========");
                System.out.println(mid1);
                System.out.println(r1);
                System.out.println(l2);
                System.out.println(mid2);
                return findMidNum(nums1, mid1 + 1, r1, nums2, l2, mid2 );
            }
        } else {
            if (nums1[mid1] == nums2[mid2]) {
                return nums1[mid1];
            } else if (nums1[mid1] > nums2[mid2]) {
                if (nums2[mid2] >= nums1[mid1 - 1]) {
                    return nums2[mid2];
                }
                return findMidNum(nums1, l1, mid1 - 1, nums2, mid2 + 1, r2);
            } else {
                if (nums1[mid1] >= nums2[mid2 - 1]) {
                    return nums1[mid1];
                }
                return findMidNum(nums1, mid1 + 1, r1, nums2, l2, mid2 - 1);
            }
        }
    }


}
