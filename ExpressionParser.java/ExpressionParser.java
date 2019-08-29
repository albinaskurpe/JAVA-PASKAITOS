public class ExpressionParser {
 
    // This is the main function for you to implement
    public static int simplify(String expression){
        // YOUR CODE HERE
        return 0;
    }
 
    public static void main(String[] args){        
       
        // HELPER CLASS
        class TestParams {
            String expression;
            int value;
            TestParams(String expression, int value){
                this.expression = expression;
                this.value = value;
            }
            boolean match(){
                if (value == ExpressionParser.simplify(expression))
                    return true;
                return false;
            }
        }
 
        // TEST CASES (you can add)
        TestParams[] tests = new TestParams[] {
            new TestParams("0+0-0", 0),
            new TestParams("1+3", 4),
            new TestParams("-1+18", 17),
            new TestParams("9+8*4", 288),
            new TestParams("8*(2+4)-(15-5)/2", 43),
        };
       
        // run tests
        for (int i = 0; i < tests.length; ++i){
            if (!tests[i].match()){
                System.out.format("Expression %20s," , "\"" + tests[i].expression + "\"");
                System.out.format(" %10s,", "value " + ExpressionParser.simplify(tests[i].expression));
                System.out.format(" %20s\n", "expected " + tests[i].value);
            }
        }
 
    }
}