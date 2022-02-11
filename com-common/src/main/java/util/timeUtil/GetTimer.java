package util.timeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTimer {


    public String getTimer(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        String t= dateFormat.format(date);
        return t;
    }


}
