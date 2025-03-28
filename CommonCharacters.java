import java.util.*;

public class CommonCharacters {

    /**
     * 找出多個字符串的公共字符
     *
     * @param strings 字符串列表
     * @return 所有字符串中共同出現的字符（已排序）
     */
    public List<Character> commonCharacters(List<String> strings) {
        // 如果字符串列表為空，直接返回空列表
        if (strings == null || strings.isEmpty()) {
            return new ArrayList<>();
        }

        // 用於存儲所有字符的出現次數
        Map<Character, Integer> charCountMap = new HashMap<>();

        // 遍歷每個字符串，統計字符出現次數
        for (String s : strings) {
            // 用於記錄當前字符串中的唯一字符
            Set<Character> uniqueCharsInString = new HashSet<>();
            for (char c : s.toCharArray()) {
                // 如果字符尚未在當前字符串中出現過，則計數
                if (uniqueCharsInString.add(c)) {
                    charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
                }
            }
        }

        // 找出在所有字符串中均出現的字符
        List<Character> result = new ArrayList<>();
        int totalStrings = strings.size();
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == totalStrings) {
                result.add(entry.getKey());
            }
        }

        // 按字典序排序
        Collections.sort(result);
        return result;
    }

    // 測試程式
    public static void main(String[] args) {
        CommonCharacters solution = new CommonCharacters();

        // 測試案例
        List<String> strings = Arrays.asList("google", "facebook", "youtube");

        // 計算公共字符
        List<Character> result = solution.commonCharacters(strings);

        // 輸出結果
        System.out.println("公共字符: " + result); // 輸出: [e, o]
    }
}
