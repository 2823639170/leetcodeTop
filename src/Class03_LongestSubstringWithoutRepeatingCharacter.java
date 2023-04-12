import java.util.HashSet;

//longest-substring-without-repeating-character
public class Class03_LongestSubstringWithoutRepeatingCharacter {


    public static void main(String[] args) {
//        String s = "abcabcbb";
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static  int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int len = 0;
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < arr.length) {

            if (!set.contains(arr[r])) {
                set.add(arr[r]);
                r++;
                max = Math.max(r - l , max);
            } else {
                set.remove(arr[l]);
                l++;
            }
        }
        return max;

    }

}
