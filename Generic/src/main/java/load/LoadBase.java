package load;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadBase {

    public static Properties properties;
    public final String PATH =System.getProperty("user.dir") + "/src/main/resources/secret.properties";

    public LoadBase(){ //whenever we create a object of this class, we are going to be loading the properties from the resources

        try {

            properties = new Properties();
            FileInputStream fis = new FileInputStream(PATH);
            properties.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
