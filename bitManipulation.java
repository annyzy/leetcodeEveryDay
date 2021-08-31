import java.util.*;

class bitManipulation{
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i ++){
            //if n&1 = 1, then the least sig fig is 1; else 0
            count += n&1;
            //shit to right by 1
            n = n >> 1;
        }
    return count;
    }
}