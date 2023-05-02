package HomeClasses.ConfigurationClasses;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FontSizeWRC implements TxtManager{
    @Override
    public void writeInTxt(String fontSize) {
        try(FileWriter writer = new FileWriter("src\\res\\configuration\\FontSizeConfig.txt", false))
        {
            writer.write(fontSize);
            writer.flush();
            System.out.println("Смена размера сохранена в конфигурации, новый размер: " + fontSize);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readFromTxt() throws IOException {
        String savedFontSize;
        try (FileReader fileReader = new FileReader("src\\res\\configuration\\FontSizeConfig.txt")) {
            StringBuilder builder = new StringBuilder();
            int nextChar;
            while ((nextChar = fileReader.read()) != -1) {
                builder.append((char) nextChar);
            }
            savedFontSize = String.valueOf(builder);
            if(Objects.equals(savedFontSize, "<default>")){
                savedFontSize = "14";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Чтение из конфигурации прошло успешно, текущий размер: " + savedFontSize);
        return savedFontSize;
    }
}
