import java.util.*;

class Friend {
    Map<String, Integer> g = new HashMap<>();
    Map<String, Integer> r = new HashMap<>();

    public Friend() {}

    public int totalGiftsGiven() {
        return g.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int totalGiftsReceived() {
        return r.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int giftIndex() {
        return totalGiftsGiven() - totalGiftsReceived();
    }
}

class Solution {
    Map<String, Friend> map = new HashMap<>();
    Map<String, Integer> resultMap = new HashMap<>();

    public int solution(String[] friends, String[] gifts) {
        for (String friend : friends) {
            map.put(friend, new Friend());
            resultMap.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] line = gift.split(" ");
            String giver = line[0];
            String receiver = line[1];

            Friend giverFriend = map.get(giver);
            Friend receiverFriend = map.get(receiver);

            giverFriend.g.put(receiver, giverFriend.g.getOrDefault(receiver, 0) + 1);
            receiverFriend.r.put(giver, receiverFriend.r.getOrDefault(giver, 0) + 1);
        }

        int n = friends.length;
        for (int i = 0; i < n; i++) {
            String giver = friends[i];
            for (int j = i + 1; j < n; j++) {
                String receiver = friends[j];

                Friend giverFriend = map.get(giver);
                Friend receiverFriend = map.get(receiver);

                int giverToReceiver = giverFriend.g.getOrDefault(receiver, 0);
                int receiverToGiver = receiverFriend.g.getOrDefault(giver, 0);

                if (giverToReceiver > receiverToGiver) {
                    resultMap.put(giver, resultMap.get(giver) + 1);
                } else if (giverToReceiver < receiverToGiver) {
                    resultMap.put(receiver, resultMap.get(receiver) + 1);
                } else {
                    int giverIndex = giverFriend.giftIndex();
                    int receiverIndex = receiverFriend.giftIndex();

                    if (giverIndex > receiverIndex) {
                        resultMap.put(giver, resultMap.get(giver) + 1);
                    } else if (giverIndex < receiverIndex) {
                        resultMap.put(receiver, resultMap.get(receiver) + 1);
                    }
                }
            }
        }

        return resultMap.values().stream().max(Integer::compareTo).orElse(0);
    }
}
