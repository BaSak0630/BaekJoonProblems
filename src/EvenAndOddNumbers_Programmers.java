public class EvenAndOddNumbers_Programmers {
    class Solution {
        public int[] solution(int[] num_list) {
            int[] answer = new int[2];
            int sNumCount = 0;
            int dNumCount = 0;
            int listLength = num_list.length;
            for (int i = 0; i < listLength; i++) {
                if (num_list[i] % 2 == 0) {
                    dNumCount++;
                }
                if (num_list[i] % 2 != 0) {
                    sNumCount++;
                }
            }
            answer[0] = dNumCount;
            answer[1] = sNumCount;
            return answer;
        }
    }
}
