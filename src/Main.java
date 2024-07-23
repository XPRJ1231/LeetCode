import java.util.*;

public class Main {
    public static void main(String[] args) {

    }



    public int[] maxSlidingWindow(int[] nums, int k) {
        //239. 滑动窗口最大值
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> list = new LinkedList<>(); //链表模拟单调队列

        for (int i = 0; i < n; i++) {
            while (!list.isEmpty() && list.getFirst() < i - k + 1) {
                list.removeFirst(); //队列超过k个数，左边出队
            }

            while (!list.isEmpty() && nums[i] > nums[list.getLast()]) {
                list.removeLast(); //队列中小于后来者的出队
            }

            list.add(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[list.getFirst()];
            }

        }

        return res;
    }

    public int subarraySum(int[] nums, int k) {
        // 560. 和为 K 的子数组
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        //438. 找到字符串中所有字母异位词  数组
        int nS = s.length(), nP = p.length();

        if (nS == 0 || nP == 0 || nS < nP) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();

        int[] cntS = new int[26];
        int[] cntP = new int[26];

        for (int i = 0; i < nP; i++) {
            cntS[s.charAt(i) - 'a']++;
            cntP[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cntS, cntP)) {
            res.add(0);
        }

        for (int i = 0; i < nS - nP; i++) {
            cntS[s.charAt(i) - 'a']--;
            cntS[s.charAt(i + nP) - 'a']++;

            if (Arrays.equals(cntS, cntP)) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        //438. 找到字符串中所有字母异位词  哈希表
        int nS = s.length(), nP = p.length();

        if (nS == 0 || nP == 0 || nS < nP) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapP = new HashMap<>();

        for (int i = 0; i < nP; i++) {
            mapP.put(p.charAt(i), mapP.getOrDefault(p.charAt(i), 0) + 1);
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (mapS.equals(mapP)) {
            res.add(0);
        }

        for (int i = 0; i < nS - nP; i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) - 1);
            if (mapS.get(s.charAt(i)) == 0) {
                mapS.remove(s.charAt(i));
            }
            mapS.put(s.charAt(i + nP), mapS.getOrDefault(s.charAt(i + nP), 0) + 1);

            if (mapS.equals(mapP)) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        //3. 无重复字符的最长子串
        int n = s.length();
        int res = 0, start = 0, index = 0;
        HashSet<Character> set = new HashSet();

        while (index < n) {
            if (set.contains(s.charAt(index))) {
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(s.charAt(index));
                index++;
                res = Math.max(res, index - start);
            }
        }

        return res;
    }

    public int trap(int[] height) {
        //42. 接雨水单调栈
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int top = Math.min(height[stack.peek()], height[i]);
                res += (top - bottom) * (i - stack.peek() - 1);
            }

            stack.push(i);
        }

        return res;
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
