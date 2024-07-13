import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //49字母异位词分组
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans;

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        ans = new ArrayList<>(map.values());
        return ans;
    }


}
