package PS_Level1.바탕화면정리;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = 51;
        int maxX = -1;
        int minY = 51;
        int maxY = -1;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (i < minX) {
                        minX = i;
                    }

                    if (j < minY) {
                        minY = j;
                    }

                    if (i > maxX) {
                        maxX = i;
                    }

                    if (j > maxY) {
                        maxY = j;
                    }
                }
            }
        }

        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }
}