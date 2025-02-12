package org.rigo.mockitoapp.example;

public class exercise6 {


    public boolean isPalindrome(String inputString) {

        String string = formating(inputString);
        String reverseString = "";

        for (int i = string.length() -1; i >= 0; i-- ){
            reverseString += string.charAt(i);
        }

        if (reverseString.equals(string)) return true;

        return false;
    }

    public String lowerCase(String input){

        String lowerCaseAlp = "abcdefghijklmnopqrstuvwxyz";
        String screamingCaseAlp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String stringLowerCase = "";

        boolean flag = false;

        for( int i = 0; input.length() > i; i++ ){
            flag = false;
            for(int j = 0; screamingCaseAlp.length() > j; j++){

                if(input.charAt(i) == screamingCaseAlp.charAt(j) ){

                    stringLowerCase += lowerCaseAlp.charAt(j);
                    flag = true;
                    break;
                }
            }
            if (!flag){
                stringLowerCase += input.charAt(i);
            }
        }

        return stringLowerCase;
    }

    public String formating(String input){

        String string = lowerCase(input);

        String lowerCaseAlp = "abcdefghijklmnopqrstuvwxyz";
        String formating = "";

        for(int i = 0; i < string.length(); i++){
            for(int j = 0; j < lowerCaseAlp.length(); j++){

                if (string.charAt(i) == lowerCaseAlp.charAt(j)) {
                    formating += string.charAt(i);
                    break;
                }
            }
        }
        return formating;
    }

    public static void main(String[] args) {

        exercise6 test = new exercise6();
        System.out.println(test.isPalindrome("=ahA?"));

    }
}
