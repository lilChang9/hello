package leetcode.backTracking.lc332;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test332 {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("JFK");
        t1.add("KUL");
        List<String> t2 = new ArrayList<>();
        t2.add("JFK");
        t2.add("NRT");
        List<String> t3 = new ArrayList<>();
        t3.add("NRT");
        t3.add("JFK");
        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);

        Solution solution = new Solution();
        List<String> itinerary = solution.findItinerary(tickets);
        System.out.println(itinerary);

    }
}
