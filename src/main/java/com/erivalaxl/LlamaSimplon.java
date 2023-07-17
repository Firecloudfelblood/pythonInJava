package com.erivalaxl;
import java.io.*;
import java.lang.ProcessBuilder;
import java.util.ArrayList;
import java.util.List;

public class LlamaSimplon {
    public static void main(String[] args) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder("python3",
                resolvePythonScriptPath("src/main/python/ImageValidation/Main.py"));

        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        List<String> results = readProcessOutput(process.getInputStream());

        for (String response : results) {
            System.out.println(response);
        }

        if (Boolean.parseBoolean(results.get(0))){
            System.out.println("The images match");
        }else{
            System.out.println("The images do not match");
        }
    }

    private static List<String> readProcessOutput(InputStream inputStream) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String readline;
            List<String> process = new ArrayList<>();
            while ((readline = reader.readLine()) !=null){
                process.add(readline);
            }
            return process;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String resolvePythonScriptPath(String path) {
        File file = new File(path);
        return file.getAbsolutePath();
    }
}
