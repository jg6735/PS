import java.util.*;

class Solution {
    private static final String CODE = "code";
    private static final String DATE = "date";
    private static final String MAX = "maximum";
    private static final String REMAIN = "remain";
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        for (int[] arr : data) {
            if (ext.equals(CODE) && arr[0] < val_ext) {
                list.add(arr);
            } else if (ext.equals(DATE) && arr[1] < val_ext) {
                list.add(arr);
            } else if (ext.equals(MAX) && arr[2] < val_ext) {
                list.add(arr);
            } else if (ext.equals(REMAIN) && arr[3] < val_ext) {
                list.add(arr);
            }
        }
        
        list.sort((o1, o2) -> {
            if (sort_by.equals(CODE)) {
                return o1[0] - o2[0];
            } else if (sort_by.equals(DATE)) {
                return o1[1] - o2[1];
            } else if (sort_by.equals(MAX)) {
                return o1[2] - o2[2];
            } else if (sort_by.equals(REMAIN)) {
                return o1[3] - o2[3];
            } else {
                return 0;
            }
        });
        
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}