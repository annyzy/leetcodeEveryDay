import java.util.*;

public class Interleave {
    // public List<Integer> interleaveList (List<List<Integer>> lists){
    // if (lists == null || lists.size() == 0) return null;

    // List<Integer> ans = new ArrayList<>();

    // int maxSize=0;
    // for( List<Integer> list: lists ){
    // maxSize = Math.max(maxSize, list.size());
    // System.out.println(maxSize);

    // }

    // int index = 0;
    // int listsLen = lists.size();
    // while(index < maxSize){
    // for(int i = 0; i < listsLen; i ++){
    // if(index < lists.get(i).size()){
    // ans.add(lists.get(i).get(index));
    // }
    // }
    // index ++;
    // }

    // return ans;
    // }

    static int[] interleaveList(int[][] lists) {
        if (lists == null || lists.length == 0)
            return null;

        List<Integer> ans = new ArrayList<>();

        int maxSize = 0;
        for (int[] list : lists) {
            maxSize = Math.max(maxSize, list.length);

        }

        int index = 0;
        int listsLen = lists.length;
        while (index < maxSize) {
            for (int i = 0; i < listsLen; i++) {
                if (index < lists[i].length) {
                    ans.add(lists[i][index]);
                }
            }
            index++;
        }

        int[] res = new int[ans.size()];
        int pos = 0;
        for (int integer : ans) {
            res[pos] = integer;
            pos++;
        }

        return res;
    }

    public static void main(String[] args) {
        // Interleave ll = new Interleave();
        // List<List<Integer>> list = new ArrayList<>();
        // List<Integer> l1 = new ArrayList<>();
        // l1.add(1);
        // l1.add(2);
        // l1.add(3);
        // list.add(l1);
        // System.out.println(l1);
        // List<Integer> l2 = new ArrayList<>();
        // l2.add(1);
        // l2.add(3);
        // l2.add(4);
        // l2.add(5);
        // list.add(l2);
        // System.out.println(list);

        // System.out.println(ll.interleaveList(list));
        int[][] arr = { { 1, 2 }, { 9 }, {}, { -4, -5, -2 } };

        int[] out = interleaveList(arr);
        System.out.println(Arrays.toString(out));
    }
}
