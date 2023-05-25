public class LambdaExpressionExample {
    public static void main(String args[]) {
        LambdaExpressionExample tester = new LambdaExpressionExample();

        MathOperation thirdPower = (x, y) -> x * x * x;
        MathOperation squareRoot = (x, y) -> Math.sqrt(x);
        MathOperation power = (x, y) -> Math.pow(x, y);

        System.out.println("10 ^ 3 = " + tester.operate(10.0, 3.0, thirdPower));
        System.out.println("√10 = " + tester.operate(10.0, 3.0, squareRoot));
        System.out.println("10 ^ 3 = " + tester.operate(10.0, 3.0, power));
        
        PassFailService passFailService = (score) -> {
            if (score >= 70) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        };
        passFailService.showMessage(80);
        passFailService.showMessage(60);
    }

        interface MathOperation {
            double operation(double a, double b);
        }

        interface PassFailService {
            void showMessage(int score);
        }

        private double operate(double a, double b, MathOperation mathOperation) {
            return mathOperation.operation(a, b);
        }
    }