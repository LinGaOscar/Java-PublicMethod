import java.util.*;

public class CommonUtils {

    /**
     * 通用工具方法：找出多個集合的交集
     *
     * @param collections 集合列表
     * @return 所有集合中共同存在的元素（已排序）
     */
    private static <T extends Comparable<? super T>> List<T> findCommonElements(
            List<? extends Collection<T>> collections) {
        // 如果集合列表為空，直接返回空列表
        if (collections == null || collections.isEmpty()) {
            return new ArrayList<>();
        }

        // 用於存儲所有元素的出現次數
        Map<T, Integer> elementCountMap = new HashMap<>();

        // 遍歷每個集合，統計元素出現次數
        for (Collection<T> collection : collections) {
            // 用於記錄當前集合中的唯一元素
            Set<T> uniqueElementsInCollection = new HashSet<>(collection);
            for (T element : uniqueElementsInCollection) {
                // 如果元素尚未在當前集合中出現過，則計數
                elementCountMap.put(element, elementCountMap.getOrDefault(element, 0) + 1);
            }
        }

        // 找出在所有集合中均出現的元素
        List<T> result = new ArrayList<>();
        int totalCollections = collections.size();
        for (Map.Entry<T, Integer> entry : elementCountMap.entrySet()) {
            if (entry.getValue() == totalCollections) {
                result.add(entry.getKey());
            }
        }

        // 按自然順序排序
        Collections.sort(result);
        return result;
    }

    /**
     * 第一部分：找出三個有序列表的交集
     *
     * @param list1 第一個有序列表
     * @param list2 第二個有序列表
     * @param list3 第三個有序列表
     * @return 三個列表的交集（已排序）
     */
    public List<Integer> intersection(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        List<Collection<Integer>> collections = Arrays.asList(list1, list2, list3);
        return findCommonElements(collections);
    }

    /**
     * 第二部分：找出多個字符串的公共字符
     *
     * @param strings 字符串列表
     * @return 所有字符串中共同出現的字符（已排序）
     */
    public List<Character> commonCharacters(List<String> strings) {
        // 將每個字符串轉換為字符集合
        List<Collection<Character>> charCollections = new ArrayList<>();
        for (String s : strings) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            charCollections.add(set);
        }
        return findCommonElements(charCollections);
    }

    // 測試程式
    public static void main(String[] args) {
        CommonUtils utils = new CommonUtils();

        // 測試第一部分
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);
        List<Integer> list3 = Arrays.asList(3, 4, 5);
        List<Integer> intersectionResult = utils.intersection(list1, list2, list3);
        System.out.println("三個列表的交集: " + intersectionResult); // 輸出: [4]

        // 測試第二部分
        List<String> strings = Arrays.asList("google", "facebook", "youtube");
        List<Character> commonCharsResult = utils.commonCharacters(strings);
        System.out.println("公共字符: " + commonCharsResult); // 輸出: [e, o]
    }
}
