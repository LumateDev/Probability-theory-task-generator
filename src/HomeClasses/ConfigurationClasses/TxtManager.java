package HomeClasses.ConfigurationClasses;

import java.io.IOException;

public interface TxtManager {
    void writeInTxt(String string);

    String readFromTxt() throws IOException;
}
