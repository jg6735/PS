package PS_Level2.주차요금계산;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/92341
class Solution {
    // 주차 차량 클래스
    private static class ParkingCar {
        private final String carNumber; // 차량 번호
        private int time; // 누적 주차 시간
        private int lastEntryTime; // 마지막 입차 시간
        private int lastExitTime; // 마지막 출차 시간

        public ParkingCar(String carNumber, int time) {
            this.carNumber = carNumber;
            this.time = time;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public int getTime() {
            return time;
        }

        public int getLastEntryTime() {
            return lastEntryTime;
        }

        public int getLastExitTime() {
            return lastExitTime;
        }

        // 주차 시간 누적하기
        public void park(int time) {
            this.time += time;
        }

        // 입차
        public void enter(int time) {
            this.lastEntryTime = time;
        }

        // 출차시 주차 시간 누적 후 기록 초기화용
        public void clear() {
            this.lastEntryTime = -1;
            this.lastExitTime = -1;
        }
    }

    // 문자열을 분 단위로 변환
    private static int parseTime(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    // 주차 시간 구하기
    private static int getParkingTime(int entryTime, int exitTime) {
        return exitTime - entryTime;
    }

    private static final String ENTER = "IN";
    private static final String EXIT = "OUT";
    private static final String LAST_TIME = "23:59";

    public int[] solution(int[] fees, String[] records) {
        Map<String, ParkingCar> map = new TreeMap<>();
        for (String rec : records) {
            String[] split = rec.split(" ");
            String time = split[0];
            String carNumber = split[1];
            String status = split[2];

            if (status.equals(ENTER)) {
                // 맵에 차량 번호, 입차 시각 저장
                map.put(carNumber, map.getOrDefault(carNumber, new ParkingCar(carNumber, 0)));
                map.get(carNumber).enter(parseTime(time));
            } else if (status.equals(EXIT)){
                // 출차시 맵에 저장된 차량 번호에 주차 누적 시간 합산, 입/출차 기록 초기화
                ParkingCar exitedCar = map.get(carNumber);
                exitedCar.park(getParkingTime(exitedCar.getLastEntryTime(), parseTime(time)));
                exitedCar.clear();
            }
        }

        int[] answer = new int[map.size()];
        int index = 0;
        for (ParkingCar car : map.values()) {
            // 입차했지만 출차하지 않은 경우 주차 시간 누적해서 저장
            if (car.getLastEntryTime() >= 0 && car.getLastExitTime() <= 0) {
                car.park(getParkingTime(car.getLastEntryTime(), parseTime(LAST_TIME)));
            }

            // 기본 시간 이하인 경우 기본 요금만 부과
            if (car.getTime() <= fees[0]) {
                answer[index++] = fees[1];
                // 기본 시간 초과할 경우 기본 요금 + 단위 시간별 단위 요금 추가 부과
            } else {
                answer[index++] = (int) (fees[1] + Math.ceil((double) (car.getTime() - fees[0]) / fees[2]) * fees[3]);
            }
        }

        return answer;
    }
}