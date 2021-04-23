
// Java program to demonstrate
// FileSystem.getRootDirectories() method

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;

public class GFG {

    public static void main(String[] args) throws IOException {

        File outputFile = new File("C:\\Users\\matth\\IdeaProjects\\OSFinal\\src\\testText.html");
        PrintStream resultFile = new PrintStream(outputFile);
        System.setOut(resultFile);


        /**This iterable path method is used to get the path of root directory*/
        //Iterable<Path> dirs = FileSystems.getDefault().getPath("C:\\Users\\matth\\IdeaProjects\\OSFinal\\src\\");

            /**This for loop iterates through the directories in the path, "name"*/
            //for (Path name : dirs) {
            //System.out.println(name);

            File f = new File("C:\\Users\\matth\\IdeaProjects\\OSFinal\\src\\");
            String path = f.getPath();
            Path dir = Paths.get(path);



            // Display the file path of the file object
            //System.out.println("File path : " + path);

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                System.out.println("<html> <body>");
                System.out.println("<div class=\"container col-lg-6 col-md-8 col-sm-12 text text-primary text-center\" style=\"padding:2em\">\n" +
                                    "<div class=\"border border-dark\">\n" +  "<h1>Directories in my computer</h1>\n");

                for (Path file : stream) {
                    //Formatter for the date / time
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

                    //convert the path object to file object for date/time and filesize
                    File pathStr = file.toFile();
                    //convert to string to check if the string contains a period
                    String strFile = file.toString();

                    /** If contains dot, download it, otherwise treat as directory */
                    if ((strFile).contains(".")) {
                        System.out.println("<a href = \"" + file.getFileName() + "\"  download > " + file.getFileName() + "</a> <text>"
                                + sdf.format(pathStr.lastModified()) + "</text> <text> " + filesize_in_kiloBytes(pathStr) + "</text> <br> ");
                    } else {
                        System.out.println("<a href = \"" + file.getFileName() + "\\index.html\"  > " + file.getFileName() + "</a> <text>"
                                + sdf.format(pathStr.lastModified()) + "</text> <text> " + filesize_in_kiloBytes(pathStr) + "</text> <br> ");
                    }
                }

                System.out.println("</body> </html>");
            } catch (IOException | DirectoryIteratorException x) {
                // IOException can never be thrown by the iteration.
                // In this snippet, it can only be thrown by newDirectoryStream.
                System.err.println(x);
            }
        }

    private static String filesize_in_kiloBytes(File file) {
        DecimalFormat df_obj = new DecimalFormat("#.##");
        return df_obj.format((double) file.length()/1024) +"  kb";
    }

    }

//Output stream