import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        List<String> parameters = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int start = input.indexOf('?');
        String toParse = input.substring(start + 1);
        String[] params = toParse.split("&");
        if(params == null){
            System.out.println("No parameters in the input string");
            sc.close();
            return;
        }

        boolean isPassPresent = false;
        String passValue = null;
        for(String param:params){
            String key = null;
            String value = null;
            String[] keyValue = param.split("=");
            if(keyValue == null || keyValue.length > 2){
                System.out.println("Invalid parameter");
                continue;
            }

            if(keyValue.length == 1){
                key = keyValue[0];
                if(key.equalsIgnoreCase("pass")){
                    isPassPresent = true;
                    if(value.isBlank()){
                        System.out.println("The value of pass parameter cannot be empty.");
                        sc.close();
                        return;
                    }
                    passValue = value;
                }else{
                    value = "not found";
                }
            }

            if(keyValue.length == 2){
                key = keyValue[0];
                value = keyValue[1];

                if(key.equalsIgnoreCase("pass")){
                    isPassPresent = true;
                    passValue = value;
                }
            }

            parameters.add(key + " : " + value);
        }

        if(isPassPresent){
            parameters.add("password : " + passValue);
        }

        for(String param: parameters){
            System.out.println(param);
        }

        sc.close();
    }
}