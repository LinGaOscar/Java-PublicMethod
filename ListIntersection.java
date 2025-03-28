import java.util.*;

public class ListIntersection {

    /**
     * 找出三個有序列表的交集
     *
     * @param list1 第一個有序列表
     * @param list2 第二個有序列表
     * @param list3 第三個有序列表
     * @return 三個列表的交集（已排序）
     */
    public List<Integer> intersection(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        // 用於存儲結果
        List<Integer> result = new ArrayList<>();

        // 三個指針，分別指向三個列表的起始位置
        int i = 0, j = 0, k = 0;

        // 遍歷三個列表，直到其中一個列表被完全遍歷
        while (i < list1.size() && j < list2.size() && k < list3.size()) {
            int num1 = list1.get(i);
            int num2 = list2.get(j);
            int num3 = list3.get(k);

            // 如果三個元素相等，則為交集元素
            if (num1 == num2 && num2 == num3) {
                result.add(num1);
                i++;
                j++;
                k++;
            }
            // 如果 num1 是最小的，移動 list1 的指針
            else if (num1 < num2 || num1 < num3) {
                i++;
            }
            // 如果 num2 是最小的，移動 list2 的指針
            else if (num2 < num1 || num2 < num3) {
                j++;
            }
            // 如果 num3 是最小的，移動 list3 的指針
            else {
                k++;
            }
        }

        return result;
    }

    // 測試程式
    public static void main(String[] args) {
        ListIntersection solution = new ListIntersection();

        // 測試案例
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);
        List<Integer> list3 = Arrays.asList(3, 4, 5);

        // 計算交集
        List<Integer> result = solution.intersection(list1, list2, list3);

        // 輸出結果
        System.out.println("交集結果: " + result); // 輸出: [4]
    }
}
