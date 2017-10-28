public class Main {
    public static void main(String[] args) {
        ShuntingYard shuntingYard = new ShuntingYard();
        shuntingYard.interpretExpression("( ( ( ( 1 + 2 ) * ( 2 + 1 ) ) / 2 ) - 0 )");
        shuntingYard.result();


    }
}
