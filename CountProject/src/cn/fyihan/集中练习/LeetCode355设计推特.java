package cn.fyihan.exam.LeetCodeTest;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode355设计推特 {
    // 用户与关注人容器
    private Map<Integer, List<Integer>> userMsgMap;

    private LinkedList<MessageNode> messageCollection;

    public LeetCode355设计推特() {
        userMsgMap = new HashMap<>();
        messageCollection = new LinkedList<>();
    }

    public void postTweet(int userId, int tweetId) {
        messageCollection.addFirst(new MessageNode(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        // 获取用户关注的人的ID
        List<Integer> followIds = userMsgMap.getOrDefault(userId, new ArrayList<>());
        return messageCollection.stream()
                .filter(messageNode -> messageNode.userId == userId || followIds.contains(messageNode.userId))
                .limit(10)
                .map(node -> node.twitterId).collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        List<Integer> followIds = userMsgMap.getOrDefault(followerId, new ArrayList<>());
        followIds.add(followeeId);
        userMsgMap.put(followerId, followIds);
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> followIds = userMsgMap.getOrDefault(followerId, new ArrayList<>());
        if(followIds.contains(followeeId)){
            followIds.remove((Object)followeeId);
        }
    }

    public class MessageNode {
        // 用户ID
        int userId;
        // 推特ID
        int twitterId;

        MessageNode(int userId, int twitterId){
            this.userId = userId;
            this.twitterId = twitterId;
        }
    }

    public static void main(String[] args) {
        LeetCode355设计推特 test = new LeetCode355设计推特();
        test.postTweet(1,5);
        test.getNewsFeed(1);
        test.follow(1,2);
        test.postTweet(2,6);
        test.getNewsFeed(1);
        test.unfollow(1,2);
        test.getNewsFeed(1);
    }
}
