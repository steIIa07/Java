import java.lang.reflect.*;

public class RunSimpleTest {
    public static void main(String[] args) throws Exception {
        String className = args[0];
        int testsPassed = 0;
        int testsFailed = 0;

        for (Method method : Class.forName(className).getMethods()) {
            if (method.isAnnotationPresent(SimpleTest.class)) {
                try {
                    method.invoke(null);
                    testsPassed++;
                } catch (Throwable ex) {
                    System.out.println(method.getName() + " failed " + ex);
                    testsFailed++;
                }
            }
        }

        System.out.printf("%d passed out of %d tested%n", testsPassed, testsPassed + testsFailed);
    }
}
