import java.util.*;

class RobotBounded {
    public boolean isRobotBounded(String instructions) {
        int insLen = instructions.length();
        //edge case
        if(insLen < 1) return false;

        //assume the robot start at the origin(0,0)
        int x = 0, y = 0;
        //start at the direction north
        int dir = 0;
        //every instruction: up +0, right +1, down +2, left +3
        int[] dirx = {0,1,0,-1};
        int[] diry = {1,0,-1,0};
        char ch;

        for(int i = 0; i<insLen; i++){
            ch = instructions.charAt(i);
            if(ch == 'L'){
                dir = (dir + 3) %4 ;
            }
            else if(ch == 'R'){
                dir = (dir + 1) % 4;
            }
            else{
                x = x + dirx[dir % 4];
                y = y + diry[dir % 4];
            }
        }

        return (( x == 0 && y==0) || (dir != 0) );
    }
}
