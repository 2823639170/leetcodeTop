import java.util.ArrayList;
import java.util.List;

public class Class15 {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        Class15 class15 = new Class15();
        class15.threeSum(arr);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {

        }
        List<List<Integer>> list = new ArrayList<>();

        process(list, nums, 0, 0, new ArrayList<Integer>());
        return list;

    }


    private void process(List<List<Integer>> list, int[] nums, int i, int sum, ArrayList<Integer> pre) {
        if (pre.size() == 3 && sum == 0) {
            list.add(new ArrayList<>(pre));
        }

        if(i == nums.length){
            return;
        }
        Integer integer = Integer.valueOf(nums[i]);
        pre.add(integer);
        process(list, nums, i + 1, sum + nums[i], pre);
        pre.remove(integer);
        process(list, nums, i + 1, sum, pre);

    }
}
