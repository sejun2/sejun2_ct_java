package programmers;

public class Q12948 {
    public String solution(String phone_number){
        StringBuilder sb = new StringBuilder();
        sb.append(phone_number);
        sb.replace(0, phone_number.length()-4, "*".repeat(phone_number.length()-4));

        return sb.toString();
    }
}
