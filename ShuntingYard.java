import java.util.*;

public class ShuntingYard {
    private Stack<String> operationStack;
    private Stack<Double> valueStack;

    public ShuntingYard() {
        this.operationStack = new Stack<>();
        this.valueStack = new Stack<>();
    }

    public void interpretExpression(String expression){
        String[] expressionArray = expression.split(" ");

        for (String e: expressionArray){
            if(e.equals("(")){

            } else if(e.equals("+") || e.equals("*") || e.equals("-") || e.equals("/")){
                this.operationStack.push(e);
            }  else if(e.equals(")")) {
                String operation = this.operationStack.pop();
                if(operation.equals("+")) {
                    this.valueStack.push(this.valueStack.pop()+this.valueStack.pop());
                } else if(operation.equals("*")) {
                    this.valueStack.push(this.valueStack.pop()*this.valueStack.pop());
                } else if(operation.equals("-")) {
                    double x = this.valueStack.pop();
                    double y = this.valueStack.pop();
                    this.valueStack.push(y-x);
                } else {
                    double x = this.valueStack.pop();
                    double y = this.valueStack.pop();
                    this.valueStack.push(y/x);
                }
            } else {
                this.valueStack.push(Double.parseDouble(e));
            }
        }
    }

    public void result(){
        System.out.println(this.valueStack.pop());
    }

}
