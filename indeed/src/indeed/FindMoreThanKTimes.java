package indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class FindMoreThanKTimes {
       
    
    public List<Integer> findMoreThanKTimes(List<List<Integer>> lists, int k) {
        if (lists == null || lists.size() == 0)
            return null;

        List<Integer> results = new ArrayList<Integer>();

         //PriorityQueue<Node> minQueue = new PriorityQueue<Node>(1, new MyNodeComparator());
      
         PriorityQueue<Node> minQueue = new PriorityQueue<Node>();
         
        //PriorityQueue minQueue = new PriorityQueue<>(new MyNodeComparator());


        for (List<Integer> list : lists) {
            if (list != null && list.size() != 0) {

                minQueue.add(new Node(list.iterator()));
            }
        }

        while (!minQueue.isEmpty()) {
            Node current = minQueue.poll();
            Integer curVal = current.val;
            int count = 1;
            while (current.iterator.hasNext()) {
                Integer nextVal = current.iterator.next();
                if (nextVal == curVal) {
                    continue;
                } else {
                    current.val = nextVal;
                    minQueue.add(current);
                    break;
                }
            }

            while (!minQueue.isEmpty() && minQueue.peek().val == curVal) {
                count++;
                Node node = minQueue.poll();
                int nodeVal = node.val;
                while (node.iterator.hasNext()) {
                    int nextNodeVal = node.iterator.next();
                    if (nodeVal == nextNodeVal) {
                        continue;
                    } else {
                        node.val = nextNodeVal;
                        minQueue.add(node);
                        break;
                    }
                }
            }
            if (count > k) {
                results.add(curVal);
            }
            
            if (minQueue.size() <= k){
                break;
            }
        }
        
        return results;
    }
    
    
    public static void main(String[] args) {
        FindMoreThanKTimes sol = new FindMoreThanKTimes();
        Integer[] a = new Integer[]{1, 2, 4};
        Integer[] b = new Integer[]{2, 3, 4};
        Integer[] c = new Integer[]{1, 2, 3, 3, 4};
        List lists = new ArrayList<>();
        lists.add(Arrays.asList(a));
        lists.add(Arrays.asList(b));
        lists.add(Arrays.asList(c));
        List<Integer> result = sol.findMoreThanKTimes(lists, 2);
        for (Integer e : result) {
        System.out.print(e + " ");
        }
        System.out.println(" "); 
        }    
    
    class Node implements Comparable<Node>{
        int val;
        Iterator<Integer> iterator;
        
        public Node(Iterator<Integer> iterator){
            this.iterator = iterator;
            this.val = iterator.next();
            
        }

        @Override
        public int compareTo(Node node) {
            // TODO Auto-generated method stub
            return this.val - node.val;
        }
    }
    

   
    

}
