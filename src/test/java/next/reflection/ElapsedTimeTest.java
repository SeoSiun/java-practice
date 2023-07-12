package next.reflection;

public class ElapsedTimeTest {
    @ElapsedTime(unit = "ms")
    public void sleep1() throws InterruptedException {
        Thread.sleep(1000);
    }

    @ElapsedTime(unit = "s")
    public void sleep2() throws InterruptedException {
        Thread.sleep(2000);
    }

    @ElapsedTime
    public void sleep3() throws InterruptedException {
        Thread.sleep(3000);
    }
}
