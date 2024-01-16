package algorithm.programmers;
/*
    x,y에서 도달할 수 있는 좌표 개수 n 구하기
    1) 격자를 넘지 않은 경우
        n = 1 + 4*1 + 4*2 + ... + 4*d
          = 1 + 2d(d+1)

        d = 1 => n = 1 + 2*1*2 = 5
        d = 2 => n = 1 + 2*2*3 = 13
        d = 3 => n = 1 + 2*3*4 = 25
    2) 격자를 넘은 경우
        1. x-d < 0
        2. x+d > n
        3. y-d < 0
        4. y+d > m

        i) 위 경우 중 1가지만 해당될 때
            k // 넘어간 거리 ex) x-d < 0 => k = d-x;
            k = 1 => _n = 1
            k = 2 => _n = 1 + 3
            k = 3 => _n = 1 + 3 + 5

            _n = 1 + 3 + 5 + ... + 2k-1
               = k^2
            n = 1 + 2d(d+1) - _n
              = 1 + 2d(d+1) + k^2
        j)

*/

public class 현대모비스2023_미로주행 {

    public static void main(String[] args) {
    }
    class Solution {
        public long solution(int n, int m, int[][] tests) {
            long answer = 0;

            return answer;
        }
    }
}