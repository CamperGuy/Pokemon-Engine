package Pokemon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {

    /**
     * This class is used for writing and reading HashMaps into a csv file and reading from the generated files
     */
    public Parser(){

    }

    /**
     * Writes a HashMap<String, String> into a csv file at the given path
     * @param hash The HashMap that is to be written as a file
     * @param filename The file location that the HashMap is to be written to
     */
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


    /**
     * Reads a csv file into a HashMap<String,String> and returns that
     * @param filename The filepath that is to be read from
     * @return The HashMap containing the file's values in String form
     */
    public static HashMap<String, String> readHashMapFile(String filename){
        HashMap<String, String> returnedHash = new HashMap<>();
        try{
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext()){
                String[] values = scanner.nextLine().split(",");
                returnedHash.put(values[0], values[1]);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found exception!");
        }
        return returnedHash;
    }

}


