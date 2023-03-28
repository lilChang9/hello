package leetcode.backTracking.lc332;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {

    LinkedList<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 针对所有的ticket的第二个字符串进行升序排序
        Collections.sort(tickets,(a, b) -> a.get(1).compareTo(b.get(1)));
        res.add("JFK");
        // 使用used数组记录当前机票是否使用过
        boolean[] used = new boolean[tickets.size()];

        backtracking(tickets,used);
        return res;
    }

    public boolean backtracking(List<List<String>> tickets,boolean[] used){
        if(res.size() == tickets.size()+1){
            return true;
        }

        for(int i = 0; i < tickets.size(); i++){
            // 如果当前机票没有使用过，并且当前机票的出发地等于结果集最后一个值
            if(!used[i] && res.getLast().equals(tickets.get(i).get(0))){
                res.add(tickets.get(i).get(1));
                used[i] = true;
                if(backtracking(tickets,used)){
                    return true;
                }
                used[i] = false;
                res.removeLast();
            }
        }
        return false;
    }
}
