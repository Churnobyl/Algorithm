import java.util.*;

class Timer {
    int time, length, opStart, opEnd;
    
    public Timer(String video_len, String pos, String op_start, String op_end) {
        int[] l = Arrays.stream(video_len.split(":")).mapToInt(Integer::parseInt).toArray();
        length = l[0] * 60 + l[1];
        
        int[] d = Arrays.stream(pos.split(":")).mapToInt(Integer::parseInt).toArray();
        time = d[0] * 60 + d[1];
        
        int[] os = Arrays.stream(op_start.split(":")).mapToInt(Integer::parseInt).toArray();
        opStart = os[0] * 60 + os[1];
        
        int[] oe = Arrays.stream(op_end.split(":")).mapToInt(Integer::parseInt).toArray();
        opEnd = oe[0] * 60 + oe[1];
    };
    
    public void prev() {
        isOpening();
        
        time -= 10;
        isOpening();
        if (time < 10) time = 0;
    }
    
    public void next() {     
        isOpening();
        
        time += 10;
        isOpening();
        if (length - time < 10) {
            time = length;
        }
    }
    
    private void isOpening() {
        if (opStart <= time && time <= opEnd) {
            time = opEnd;
        }
    }
}

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        Timer timer = new Timer(video_len, pos, op_start, op_end);
        
        for(String com : commands) {
            switch (com) {
                case "next":
                    timer.next();
                    break;
                case "prev":
                    timer.prev();
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        return String.format("%02d", timer.time / 60) + ":" + String.format("%02d", timer.time % 60);
    }
}