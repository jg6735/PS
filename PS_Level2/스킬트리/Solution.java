package PS_Level2.스킬트리;

// https://school.programmers.co.kr/learn/courses/30/lessons/49993
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        StringBuilder builder = new StringBuilder();
        for (String skillTree : skill_trees) {
            for (int i = 0; i < skillTree.length(); i++) {
                char c = skillTree.charAt(i);
                if (skill.contains(String.valueOf(c))) {
                    builder.append(c);
                }
            }

            if (skill.indexOf(builder.toString()) == 0) {
                answer++;
            }

            builder.setLength(0);
        }

        return answer;
    }
}