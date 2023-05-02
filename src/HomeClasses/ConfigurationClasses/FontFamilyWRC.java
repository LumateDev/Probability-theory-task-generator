package HomeClasses.ConfigurationClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FontFamilyWRC implements TxtManager{
    @Override
    public void writeInTxt(String fontFamily) {
        try(FileWriter writer = new FileWriter("src\\res\\configuration\\FontFamilyConfig.txt", false))
        {
            writer.write(fontFamily);
            writer.flush();
            System.out.println("Смена шрифта сохранена в конфигурации, новый шрифт: " + fontFamily);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readFromTxt() throws IOException {
        String savedFontFamily;
        try (FileReader fileReader = new FileReader("src\\res\\configuration\\FontFamilyConfig.txt")) {
            StringBuilder builder = new StringBuilder();
            int nextChar;
            while ((nextChar = fileReader.read()) != -1) {
                builder.append((char) nextChar);
            }
            savedFontFamily = String.valueOf(builder);
            if(Objects.equals(savedFontFamily, "<default>")){
                savedFontFamily = "Tames New Roman";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Чтение из конфигурации прошло успешно, текущий шрифт: " + savedFontFamily);
        return savedFontFamily;
    }
}
