import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        Queue<Music> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getTime() == o2.getTime()) {
                return o1.getIndex() - o2.getIndex();
            }
            
            return o2.getTime() - o1.getTime();
        });
        
        m = replaceMusic(m);
        for (int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            int time = getTime(infos[1]) - getTime(infos[0]);
            String name = infos[2];
            String info = infos[3];
            Music music = new Music(i, name, time, replaceMusic(info));
            StringBuilder builder = findMusic(music);
            if (builder.toString().contains(m)) {
                queue.add(music);
            }
        }
        
        if (queue.isEmpty()) {
            return "(None)";
        }
        
        return queue.poll().getName();
    }
    
    public String replaceMusic(String info) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < info.length(); i++) {
            if (i + 1 < info.length() && Character.isAlphabetic(info.charAt(i)) && info.charAt(i + 1) == '#') {
                builder.append(Character.toLowerCase(info.charAt(i)));
                i++;
            } else {
                builder.append(info.charAt(i));
            }
        }
        
        return builder.toString();
    }
    
    public StringBuilder findMusic(Music music) {
        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < music.getTime(); i++) {
            builder.append(music.getInfo().charAt(cnt));
            if (++cnt >= music.getInfo().length()) {
                cnt = 0;
            }
        }
        
        return builder;
    }
    
    public int getTime(String str) {
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}

class Music {
    private int index;
    private String name;
    private int time;
    private String info;
    
    public Music(int index, String name, int time, String info) {
        this.index = index;
        this.name = name;
        this.time = time;
        this.info = info;
    }
    
    public int getIndex() {
        return index;
    }
    
    public String getName() {
        return name;
    }
    
    public int getTime() {
        return time;
    }
    
    public String getInfo() {
        return info;
    }
}