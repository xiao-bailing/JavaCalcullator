package calculator;

import java.util.Stack;

/**
 * @author xiaobailing
 */
public class GetResult {
    public GetResult(){

    }
    static char zero = '0';
    static char nine = '9';
    static char leftBracket = '(';
    static char rightBracket = ')';
    static char point = '.';
    static char plus = '+';
    static char subtraction = '-';
    static char multiply = '*';
    static char divide = '/';

    static Stack<Double> num = new Stack<>();
    static Stack<Character> op = new Stack<>();
    public static String main(String args) {
        try {
            args = format(args);
            stackProcessing(args);
            while (op.size() > 0) {
                eval();
            }

            return String.valueOf(num.peek());
        }catch (Exception e){
            return "Error";
        }
        finally {
            num.clear();
            op.clear();
        }
    }
    public static void stackProcessing(String str){
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)>=zero&&str.charAt(i)<=nine)) {
                i = getNum(str,i);
            }
            else if(str.charAt(i) == leftBracket){
                op.push(str.charAt(i));
            }
            else if(str.charAt(i) == rightBracket){
                while (op.size()>0&&op.peek()!=leftBracket){
                    eval();
                }
                op.pop();
            }
            else{
                while (op.size()>0&&getPriority(str.charAt(i))<=getPriority(op.peek())) {
                    eval();
                }
                    op.push(str.charAt(i));
            }
        }

    }
    public static int  getNum(String str,int i){
        int j = i;
        while(j<str.length()&&(str.charAt(j)>=zero&&str.charAt(j)<=nine||(str.charAt(j)==point))){
                    j++;
        }
        String s = str.substring(i,j);
        double a = Double.parseDouble(s);
        num.push(a);
        return j - 1;
    }
    public static void eval(){
        double a = num.peek();
        num.pop();
        double b = num.peek();
        num.pop();
        char c = op.peek();
        op.pop();
        double r = 0;
        if (c == plus) {
            r = b + a;
        }
        if (c == subtraction) {
            r = b - a;
        }
        if (c == multiply) {
            r = b * a;
        }
        if (c == divide) {
            r = b / a;
        }
        num.push(r);

    }
    public static int getPriority(char s){
        if(s == divide) {
            return 2;
        }
       else if(s == multiply) {
            return 2;
        }
       else if (s == plus) {
            return 1;
        }
       else if(s == subtraction) {
            return 1;
        }
       else if (s == leftBracket){
           return 0;
        } else {
            return 1;
        }
    }
    public static String format (String args){
        for(int i = 0;i < args.length();i++){
            if(args.charAt(i) == subtraction&&i==0){
                args = "0"+args;
            }
            if (args.charAt(i)=='-'&&(args.charAt(i+1)=='-')){
                String temp = args.substring(0,i);
                String temp2 = args.substring(i+2);
                args = temp + "+"+temp2;
            }
            if (args.charAt(i)=='-'&&(args.charAt(i-1)=='+'||args.charAt(i-1)=='-'||args.charAt(i-1)=='(')){
                    String temp = args.substring(0,i);
                    String temp2 = args.substring(i);
                    args = temp + "0"+temp2;
            }
            if(args.charAt(i)=='-'&&(args.charAt(i-1)=='*'||args.charAt(i-1)=='/')){
                String temp = args.substring(0,i);
                int j = i + 1;
                while ((j<args.length())&&(args.charAt(j)>=zero&&args.charAt(j)<=nine)||args.charAt(i)==point) {
                   j++;
                }
                String temp2 = args.substring(i,j);
                String temp3 = args.substring(j);
                args = temp+"(0"+temp2+")"+temp3;

            }
        }
        System.out.println(args);
        return args;
    }
}