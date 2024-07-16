import java.util.*;

public class Main {
    public static void main(String[] args) {

    }


    public int trap(int[] height) {
        //42. 接雨水
        int n = height.length;
        int trap = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                trap += (height[i] - height[stack.peek()]) * (i - stack.peek() - 1);
                stack.pop();
            }

            stack.push(i);
        }

        return trap;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        //15. 三数之和
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);

                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    public int maxArea(int[] height) {
        //11.盛最多水的容器
        int max = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
//            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
//            if(height[left] < height[right]){
//                left++;
//            }else {
//                right--;
//            }
            max = Math.max(max,
                    (right - left) * (height[left] < height[right] ? height[left++] : height[right--]));
        }

        return max;
    }

    public int longestConsecutive(int[] nums) {
        //128.最长连续序列
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;

        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int count = 1;

            while (set.contains(i + 1)) {
                i++;
                count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        // 49.字母异位词分组
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans;

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.computeIfAbsent(sorted, _ -> new ArrayList<>()).add(str);
        }

        ans = new ArrayList<>(map.values());
        return ans;
    }

}
