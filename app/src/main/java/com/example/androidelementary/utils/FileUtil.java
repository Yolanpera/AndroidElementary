package com.example.androidelementary.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 */

public class FileUtil {

    private static final int NUM_2048 = 2048;

    private FileUtil() {
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static void unZipFolder(String zipFilePath, String outPath) throws Exception {
        ZipInputStream inZip;
        BufferedOutputStream out;
        inZip = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFilePath)));
        ZipEntry zipEntry;
        String unsafePath = ".." + File.separator;
        while ((zipEntry = inZip.getNextEntry()) != null) {
            String szName = zipEntry.getName();
            if (isEmpty(szName) && szName.contains(unsafePath)) {
                throw new IOException("Unzip maybe be unsafe.");
            }
            if (zipEntry.isDirectory()) {
                // get the folder name of the widget
                File folder = new File(outPath + File.separator + szName);
                folder.mkdirs();
            } else {
                File file = new File(outPath + File.separator + szName);
                if (file.exists()) {
                    file.delete();
                } else {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                // get the output stream of the file
                out = new BufferedOutputStream(new FileOutputStream(file));
                int len;
                byte[] buffer = new byte[NUM_2048];
                // read (len) bytes into buffer
                while ((len = inZip.read(buffer)) != -1) {
                    // write (len) byte from buffer at the position 0
                    out.write(buffer, 0, len);
                }
                out.flush();
                out.close();
            }
        } //end of while
        inZip.close();
    } //end of func

    public static boolean removeDir(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            File[] files = fileOrDirectory.listFiles();
            if (files == null || files.length == 0) {
                return fileOrDirectory.delete();
            }
            for (File child : files) {
                if (child.isDirectory()) {
                    removeDir(child);
                } else {
                    child.delete();
                }
            }
            return fileOrDirectory.delete();
        } else {
            return fileOrDirectory.delete();
        }
    }
}
