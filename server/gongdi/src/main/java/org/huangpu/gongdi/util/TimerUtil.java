package org.huangpu.gongdi.util;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class TimerUtil {

    private static Timer timer = new Timer();

    public static Map<String, TimerTask> timerMap = new ConcurrentHashMap<>();

    public static void newTimerTask(String key,String date,TimerTask timerTask){
        TimeUtil timeUtil = new TimeUtil();
        timer.schedule(timerTask,timeUtil.getDate(date));
        timerMap.put(key,timerTask);
    }

}
