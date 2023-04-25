package HomeClasses.ConfigurationClasses;


import java.io.*;

public class PathWRC implements TxtManager{

    @Override
    public void writeInTxt(String userFilePath) {
        try(FileWriter writer = new FileWriter("src\\res\\configuration\\PathConfig.txt", false))
        {
            writer.write(userFilePath);
            writer.flush();
            System.out.println("Смена пути сохранена в конфигурации, новый путь: " + userFilePath);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readFromTxt() throws IOException {
        String savedUserFilePath;
        try(FileReader fileReader = new FileReader("src\\res\\configuration\\PathConfig.txt")) {
            StringBuilder builder = new StringBuilder();
            int nextChar;
            while ((nextChar = fileReader.read()) != -1) {
                builder.append((char) nextChar);
            }
            savedUserFilePath = String.valueOf(builder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Чтение из конфигурации прошло успешно, текущий путь: " + savedUserFilePath);
        return savedUserFilePath;
    }
}
