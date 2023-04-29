package HomeClasses.ConfigurationClasses;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ThemesWRC  implements TxtManager{
    @Override
    public void writeInTxt(String userTheme) {
        try(FileWriter writer = new FileWriter("src\\res\\configuration\\ThemesConfig.txt", false))
        {
            writer.write(userTheme);
            writer.flush();
            System.out.println("Смена темы сохранена в конфигурации, новая тема: " + userTheme);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readFromTxt() throws IOException {
        String savedUserTheme;
        try(FileReader fileReader = new FileReader("src\\res\\configuration\\ThemesConfig.txt")) {
            StringBuilder builder = new StringBuilder();
            int nextChar;
            while ((nextChar = fileReader.read()) != -1) {
                builder.append((char) nextChar);
            }
            savedUserTheme = String.valueOf(builder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Чтение из конфигурации прошло успешно, текущая тема: " + savedUserTheme);
        return savedUserTheme;
    }
}
