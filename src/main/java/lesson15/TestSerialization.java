package lesson15;

import lesson7.MyTestListener;
import org.testng.annotations.Test;

public class TestSerialization {
    @Test
    public void serializeTest() {
        MyStorage myStorage = new MyStorage();
        myStorage.name = "Jack";
        myStorage.age = 15;
        SerializationWorker.serializeStorage(myStorage, "storage");

    }
}
