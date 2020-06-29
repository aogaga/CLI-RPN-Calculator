import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    private Stack<Double> operandStack = new Stack<Double>();
    private Scanner scanner = new Scanner(System.in);
    private Double result = 0.00;
    boolean quit = false;
    boolean clear = false;

    public void runCalculator(){
        System.out.print("Enter X or Q to quit:");
        
        while(!quit || !clear){

            System.out.print(" > ");
            String input = scanner.next();

            if(input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")){

                if(operandStack.isEmpty()){
                    System.out.println("No inputs to operate on");
                }else {
                    determineMathOperation(input);
                }

            } else if (input.toLowerCase().equals("q") || input.toLowerCase().equals("x") ){
                quit();
                return; 
            }else if(input.toLowerCase().equals("c")){
                clear();
            }else {
                try{
                    Double temp =  Double.parseDouble(input);
                    operandStack.push(temp);
                    System.out.println(input);
                }catch (Exception e){
                    System.out.println("invalid entry");
                }
            }
        }

    }

    private void quit() {
        quit = true;
        System.out.println("Good Bye!!!");
    }

    private void clear() {
        result = 0.00;
        operandStack.clear();
        System.out.println("Cleared");
    }

    private void determineMathOperation(String input) {
        if(input.equals("+")){
           result =  addition();
            System.out.println(result);
        }

        if(input.equals("-")){
            result = subtraction();
            System.out.println(result);
        }

        if(input.equals("*")){
            result = multiplication();
            System.out.println(result);
        }

        if(input.equals("/")){
            result = division();
            System.out.println(result);
        }

    }
    
    private double addition(){
        if(operandStack.size() == 1){
            return (operandStack.pop() + result);
        }
        double last = operandStack.pop();
        return  result + (operandStack.pop() + last);
    }
    
    private double subtraction(){
        if(operandStack.size() == 1){
          return (result - operandStack.pop());
        }
        double last = operandStack.pop();
        return  result + (operandStack.pop() - last);
    }

    private double multiplication(){
        if(operandStack.size() == 1){
            return result * operandStack.pop();
        }
        double last = operandStack.pop();
        return  result + (operandStack.pop() * last);
    }

    private double division(){
        if(operandStack.size() == 1){
            return operandStack.pop() / result;
        }
        double last = operandStack.pop();
        return  result + (operandStack.pop() / last);
    }

}
