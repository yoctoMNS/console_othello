import java.io.IOException;


public class ConsoleController {
    private ProcessBuilder p;

    
    public ConsoleController(String... args) {
        p = new ProcessBuilder(args);
    }


    public void run() {
        try {
            p.inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (IOException e) {
        }
    }
}
