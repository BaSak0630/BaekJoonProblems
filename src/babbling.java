public class babbling {
    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            int count = 0;
            String[]strArr ={"aya", "ye", "woo", "ma"};
            for(String word : babbling){
                for(String babblingStr : strArr){
                    if(word.contains(babblingStr)) {
                        word = word.replace(babblingStr,",");
                        count++;
                    }
                }
                for(int i = 0; i < count; i++) word = word.replace(",","");
                if(word.length() == 0){
                    answer++;
                }
            }
            return answer;
        }
    }
}
