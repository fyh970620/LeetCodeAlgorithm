package cn.fyihan.集中练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1268搜索推荐系统 {
    private List<List<String>> recommandDatas = new ArrayList<>();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        char[] chars = searchWord.toCharArray();
        String matchStr = chars[0]+"";
        return matcherProducts(Arrays.asList(products), matchStr, searchWord);
    }

    private List<List<String>> matcherProducts(List<String> products, String searchWord, String orginSearchWord) {
        if (searchWord.length() > orginSearchWord.length()) {
            return recommandDatas;
        }
        List<String> matcherProds = new ArrayList<>();
        String newSearWord = "";
        if ( searchWord.length()+1 > orginSearchWord.length()) {
            newSearWord = searchWord + " ";
        } else {
            newSearWord = orginSearchWord.substring(0, searchWord.length()+1);
        }
        for (String product : products) {
            if (product.startsWith(searchWord)) {
                matcherProds.add(product);
            }
        }
        String[] prods = new String[matcherProds.size()];
        if (matcherProds.size() > 3) {
            Arrays.sort(matcherProds.toArray(prods));
            recommandDatas.add(Arrays.asList(prods[0], prods[1], prods[2]));
        } else {
            Arrays.sort(matcherProds.toArray(prods));
            recommandDatas.add(Arrays.asList(prods));
        }
        return matcherProducts(matcherProds, newSearWord, orginSearchWord);
    }

    public static void main(String[] args) {
        LeetCode1268搜索推荐系统 test = new LeetCode1268搜索推荐系统();
        test.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
    }
}
