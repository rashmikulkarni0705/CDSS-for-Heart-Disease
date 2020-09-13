package AlgoID3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOp {

    /** Creates a new instance of createPackage */
    public FileOp() {
    }

    public static void createPackageFile(String Filename, String TextData, String newfilename) {
        try {

            //create  Java Class
            String temp = newfilename.substring(0, newfilename.lastIndexOf("\\"));
            createFolder(temp);
            File fileobj = new File(newfilename);
            FileOutputStream fos = new FileOutputStream(fileobj);
            byte b[] = TextData.getBytes();
            fos.write(b, 0, b.length);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
            //       System.out.println(" createPakageFile : " + FilePath + e);
        }
    }

    public static void createPackageFile(String Filename, String TextData) {
        try {

            //create  Java Class

            File fileobj = new File(Filename);
            FileOutputStream fos = new FileOutputStream(fileobj);
            byte b[] = TextData.getBytes();
            fos.write(b, 0, b.length);
            fos.close();

        } catch (Exception e) {
            //       System.out.println(" createPakageFile : " + FilePath + e);
        }
    }

    public static void fileCopy(String src, String dest) {
        try {
            File inputFile = new File(src);
            File outputFile = new File(dest);

            FileInputStream in = new FileInputStream(inputFile);
            FileOutputStream out = new FileOutputStream(outputFile);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead); // write
            }
            in.close();
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileOp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileOp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void fileCopy(File inputFile, String dest) {
        // File inputFile = new File(src);
        try {
            if (dest.endsWith(".cs")) {
                String data = fileRead(new FileInputStream(inputFile));
                data = data.replaceAll("MorphWeb", projectname);
                createPackageFile(dest, data);
            } else {

                File outputFile = new File(dest);

                FileInputStream in;
                in = new FileInputStream(inputFile);

                FileOutputStream out = new FileOutputStream(outputFile);

                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead); // write
                }

                in.close();
                out.close();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileOp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String fileRead(FileInputStream in) {
        StringBuffer sb = new StringBuffer();
        try {
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, bytesRead));
                // out.write(); // write
            }
            in.close();

        } catch (IOException ex) {
            //Logger.getLogger(FileOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
    public static String projectname;

    public static void dirCopy(File srcdirectory, String destdir) {
        createFolder(destdir);
        File[] children = srcdirectory.listFiles();
        for (int i = 0; i < children.length; i++) {
            if (children[i].isFile()) {
                try {
                    System.out.println(destdir + "\\" + children[i].getName());
                    fileCopy(children[i], destdir + "\\" + children[i].getName());
                } catch (Exception ex) {
                    //   Logger.getLogger(FileCopy.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println(destdir + "\\" + children[i].getName());
                dirCopy(children[i], destdir + "\\" + children[i].getName());
            }


        }
    }

    public static boolean createFolder(String dir) {

        StringTokenizer st = new StringTokenizer(dir, "\\");
        String temp = st.nextToken();
        while (st.hasMoreTokens()) {
            temp += "\\" + st.nextToken();
            File f = new File(temp);
            try {
                if (!f.exists()) {
                    f.mkdir();
                }
                //      return true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return true;

    }

    public static void main(String[] args) {
        //createFolder("E:\\test\\t1\\t2\\t3");
//        dirCopy(new File("e:\\test\\App_Code"), "e:\\test\\t2");
    }
}
