package com.holdfast.mbide.j2mecompiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author HoldFast
 */
public class Compiler {

    long time1, time2;

    void Compiler() {

    }

    void compile(String apipath, String srcpath, String outpath) throws Exception {
        File file = new File(outpath);
        file.mkdir();
        File[] listOfFiles = file.listFiles();
        for (File fil : listOfFiles) {
            if (fil.isFile()) {
                fil.delete();
            }
        }
        ProcessBuilder pb = new ProcessBuilder("javac",
                "-cp", apipath, "-target",
                "1.1", "-source", "1.3", "-nowarn", "-encoding", "UTF-8", srcpath + "*.java", "-d", outpath);
        Process p = pb.start();

        time1 = System.currentTimeMillis();

        StringBuilder console = new StringBuilder();
        InputStream stream = p.getErrorStream();
        try {
            int read;
            byte[] buf = new byte[1024 * 99];
            while ((read = stream.read(buf)) > 0) {
                console.append(new String(buf, 0, read));
            }
        } finally {
            if (stream != null) {
                stream.close();
            }
        }

        p.waitFor();

        final String result = console.toString().trim();
        System.out.println("javac:");
        System.out.println(result);

        p.waitFor();

        File folder = new File(outpath);
        listOfFiles = folder.listFiles();
        if (listOfFiles.length == 0) {
            throw new Exception("Ошибка компиляции");
        }

        File f = new File("prebuild" + File.separator + "temp.jar");
        f.mkdirs();
        f.delete();

        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(f));

        zip.putNextEntry(new ZipEntry("META-INF/MANIFEST.MF"));
        zip.write(("Manifest-Version: 1.0\n"
                + "Ant-Version: Apache Ant 1.9.4\n"
                + "Created-By: 1.8.0_25-b18 (Oracle Corporation)\n"
                + "MIDlet-1: FW,,FW\n"
                + "MIDlet-Vendor: Vendor\n"
                + "MIDlet-Version: 1.0\n"
                + "MIDlet-Name: MBRun\n"
                + "MicroEdition-Configuration: CLDC-1.1\n"
                + "MicroEdition-Profile: MIDP-2.0").getBytes("UTF-8"));
        zip.closeEntry();

        for (File fil : listOfFiles) {
            if (fil.isFile()) {
                System.out.println(fil.getName());
                zip.putNextEntry(new ZipEntry(fil.getName()));
                FileInputStream fis = new FileInputStream(fil);

                byte[] buffer = new byte[4092];
                int byteCount = 0;
                while ((byteCount = fis.read(buffer)) != -1) {
                    zip.write(buffer, 0, byteCount);
                    System.out.print('.');
                    System.out.flush();
                }
                zip.closeEntry();
            }
        }
        zip.close();
        previrify("prebuild" + File.separator + "temp.jar", "bombom.jar");

    }

    void previrify(String injar, String outjar) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "proguard" + File.separator + "proguard.jar",
                "-injars", injar, "-outjars", outjar,
                "-libraryjars", "proguard" + File.separator + "cldcapi11.jar", "-libraryjars", "proguard" + File.separator + "midpapi20.jar", "-microedition",
                "-keep", "public class * extends javax.microedition.midlet.MIDlet", "-dontoptimize");
        System.out.println("\nproguard:");
        Process p = pb.start();
        StringBuilder console = new StringBuilder();
        InputStream stream = p.getInputStream();
        try {
            int read;
            byte[] buf = new byte[1024 * 99];
            while ((read = stream.read(buf)) > 0) {
                console.append(new String(buf, 0, read));
            }
        } finally {
            if (stream != null) {
                stream.close();
            }
        }

        p.waitFor();
        time2 = System.currentTimeMillis();
        long difference = time2 - time1;
        java.util.Date differneceDate = new Date(difference);

        final String result = console.toString().trim();
        System.out.println(result);
        System.out.println("Сборка завершена за " + getTime(differneceDate));

    }

    private String getTime(Date date) {
        return (new SimpleDateFormat("mm:ss")).format(date);
    }
}
