public class AddPosition {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            String s = Integer.toString(n);
            String[] strArr = s.split("");
            for(String tmp : strArr){
                int num = Integer.parseInt(tmp);
                answer += num;
            }
            return answer;
        }
    }
}
