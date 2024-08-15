package src.test.java.org.automation.utility;

public class Wait {
    public void wait(int milliSecs){
        try{
            Thread.sleep(milliSecs);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
