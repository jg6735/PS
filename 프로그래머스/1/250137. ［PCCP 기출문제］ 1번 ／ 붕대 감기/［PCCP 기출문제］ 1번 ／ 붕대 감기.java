class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int casting = bandage[0];
        int second = bandage[1];
        int bonus = bandage[2];
        int idx = 0;
        int count = 0;
        for (int i = 0; i <= attacks[attacks.length - 1][0]; i++) {
            if (attacks[idx][0] == i) {
                hp -= attacks[idx][1];
                if (hp <= 0) {
                    return -1;
                }
                
                idx++;
                count = 0;
            } else {
                count++;
                if (hp < health) {
                    hp = Math.min(health, hp + second);
                    if (count == casting) {
                        hp = Math.min(health, hp + bonus);
                        count = 0;
                    }
                }
            }
        }
        
        return hp;
    }
}