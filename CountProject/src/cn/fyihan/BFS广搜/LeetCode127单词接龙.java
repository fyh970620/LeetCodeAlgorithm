package cn.fyihan.BFS广搜;

import java.util.*;

public class LeetCode127单词接龙 {
    private Map<String, Integer> wordsMap = new HashMap<>();

    private int index;

    private List<List<Integer>> asscoitionList= new ArrayList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word: wordList) {
            // 广度连接双向图生成
            putDerivativeWordIntoMap(word);
        }
        putDerivativeWordIntoMap(beginWord);
        if (!wordsMap.containsKey(endWord)) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] countsDown = new int[index];
        Arrays.fill(countsDown, Integer.MAX_VALUE);
        int startIndex = wordsMap.get(beginWord);
        countsDown[startIndex] = 0;
        queue.add(startIndex);
        int endIndex = wordsMap.get(endWord);
        while (!queue.isEmpty()) {
            int tempIndex = queue.poll();
            if (tempIndex == endIndex) {
                return countsDown[tempIndex] / 2 +1;
            }
            List<Integer> asscoitionIndexs = asscoitionList.get(tempIndex);
            for (Integer assoiIndex : asscoitionIndexs) {
                if ( countsDown[assoiIndex] == Integer.MAX_VALUE) {
                    countsDown[assoiIndex] = countsDown[tempIndex] + 1;
                    queue.add(assoiIndex);
                }

            }
        }
        return 0;
    }

    private void putDerivativeWordIntoMap(String word) {
        putWordIntoMap(word);
        // 原生的word在 asscoitionList中的下标
        int originIndex = wordsMap.get(word);
        // 对衍生内容进行存储
        char[] chars = word.toCharArray();
        for (int i=0; i<word.length(); i++) {
            char currentChar = chars[i];
            // 将当前字符标记为替换位字符
            chars[i] = '*';
            putWordIntoMap(new String(chars));
            // 当前可替换字符在数组中的下标
            int currentIndex = wordsMap.get(new String(chars));
            // 互相存入，证明替换是存在双向的
            asscoitionList.get(originIndex).add(currentIndex);
            asscoitionList.get(currentIndex).add(originIndex);
            // 还原
            chars[i] = currentChar;
        }
    }

    private void putWordIntoMap(String word) {
        if (!wordsMap.containsKey(word)) {
            // 同步递增，当前的index对应asscoitionList中的下标记
            wordsMap.put(word, index++);
            asscoitionList.add(new ArrayList<Integer>());
        }
    }

    public static void main(String[] args) {
        LeetCode127单词接龙 test = new LeetCode127单词接龙();
        test.ladderLength("hot","dog",Arrays.asList("hot","dog"));
    }
}

