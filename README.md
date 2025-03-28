# Java-PublicMethod

/**
 * 第一部分 ListIntersection
 *
 * -- 第一部分 --
 * private List<Integer> intersection(List<Integer> list1, List<Integer> list2, List<Integer> list3)
 * 給定 3 個已排序的列表，找出這 3 個列表的交集。例如：
 * 輸入:  [1, 2, 3, 4], [2, 4, 6, 8], [3, 4, 5]
 * 輸出: [4]
 */

第一部分：三個有序列表的交集
方法思路：

將每個列表轉換為集合（Set），確保每個元素唯一。

使用計數法統計公共元素。若某元素的出現次數等於集合數量（即所有列表均包含該元素），則為交集元素。

將結果按自然順序排序。

/**
 * 第二部分 CommonCharacters
 *
 * -- 第二部分 --
 * private List commonCharacters(List<String> strings)
 * 給定一個字符串列表，找出所有字符串中共同出現的字符。例如：
 * 輸入:  'google', 'facebook', 'youtube'
 * 輸出: ['e' , 'o']
 */

第二部分：多字符串的公共字符
方法思路：

將每個字符串轉換為字符集合，去重。

使用工具方法 findCommonElements，統計各字符在集合中的出現次數。

/**
 * 第三部分
 *
 * -- 第三部分 --
 * 提取一個工具方法，並使用相同的方法來解決第一題和第二題。
 */

第三部分：提取公共工具方法
工具方法：

方法名：findCommonElements

功能：處理任意數量集合的交集問題。

實現細節：

使用 Map 統計元素在所有集合中的出現次數。

篩選出出現次數等於集合數量的元素。

將結果按自然順序排序。