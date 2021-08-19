package _Hashmap;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(str);
        System.out.println(ans);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        String key;
        for(String str:strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            key = new String(c);
            if (!map.containsKey(key))
                map.put(key, new LinkedList<String>());
            map.get(key).add(str);
        }
        List<List<String>> lists = new LinkedList<>();

        for (Map.Entry e : map.entrySet()){
            List<String> list= (LinkedList<String>)e.getValue();
            lists.add(list);

        }

        return lists;
    }
}
