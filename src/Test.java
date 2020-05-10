import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter source file:");
        String depar = scan.nextLine();
        System.out.printf("Enter destination file:");
        String desti = scan.nextLine();
        File departure = new File(depar);
        File destination = new File(desti);
        try {
            copyUsingStream(departure, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyUsingJavaFiles(File departure, File destination) throws IOException {
        Files.copy(departure.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyUsingStream(File departure, File destination) throws IOException{
        InputStream is = null ;
        OutputStream os = null;
        try{
            is = new FileInputStream(departure);
            os = new FileOutputStream(destination);
            byte[] myByte = new byte[1024];
            int length;
            while ((length = is.read(myByte)) > 0){
                os.write(myByte, 0 , length);
            }
        }
        finally {
            is.close();
            os.close();
        }
    }
}
