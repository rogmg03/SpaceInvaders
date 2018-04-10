package Tools;

import java.lang.*;


public class Timer {

    public long now = System.currentTimeMillis();
    public boolean delay(int miliSeconds){
        if ((System.currentTimeMillis()-now)>=miliSeconds){
            now = System.currentTimeMillis();
            return true;
        } else {
            return false;
        }
    }
}
