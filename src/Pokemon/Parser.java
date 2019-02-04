package Pokemon;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public Parser(){

    }

    public static void writeHashMap(HashMap<String, String> hash, String filename) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> kvp : hash.entrySet()) {
            builder.append(kvp.getKey());
            builder.append(",");
            builder.append(kvp.getValue());
            builder.append("\r\n");
        }

        String content = builder.toString().trim();

        File writeFile = new File(filename + ".csv");
        if (!writeFile.exists()){
            try{
                if (writeFile.createNewFile())
                    System.out.println("File has been saved");
            }
            catch(java.io.IOException ex){
                System.out.println("The file could not be saved. IO Exception\n"+ ex);
            }
        }
        try{
            PrintWriter out = new PrintWriter(filename + ".csv");
            out.print(content);
        }
        catch(java.io.FileNotFoundException ex){
            System.out.println("The file could not be found. FileNotFoundException\n" + ex);
        }
        System.out.println(content);
    }
}


