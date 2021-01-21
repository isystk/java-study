package anonymousClass;

/**
 * 匿名クラス
 */
public class Sample {
    public static void main(String[] args) {
        TaskHandler taskHandler = new TaskHandler() {
            @Override
            public void handle(String message) {
                System.out.println(message);
            }
        };
        taskHandler.handle("hello");
    }

}
