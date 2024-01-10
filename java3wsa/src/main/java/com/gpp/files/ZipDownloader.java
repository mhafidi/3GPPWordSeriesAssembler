package com.gpp.files;

import com.gpp.clients.FtpClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ZipDownloader {

    public void downloadZipFiles() {
        String server = "ftp.3gpp.org";
        int port = 21;
        String remoteDirectory = "/Specs/2023-09/Rel-17/";
        String localDirectory = "/path/to/local/directory/";

        FtpClient ftpClient = new FtpClient(server, port);
        ftpClient.changeDirectory(remoteDirectory);

        FTPFile[] files = ftpClient.listFiles();
        if (files != null) {
            for (FTPFile file : files) {
                if (file.isFile() && file.getName().endsWith(".zip")) {
                    String remoteFile = file.getName();
                    String localFile = localDirectory + remoteFile;

                    downloadFile(ftpClient, remoteFile, localFile);
                }
            }
        }

        ftpClient.disconnect();
    }


    private static void downloadFile(FtpClient ftpClient, String remoteFile, String localFile) {
        try (OutputStream outputStream = new FileOutputStream(localFile)) {
            ftpClient.getFtpClient().retrieveFile(remoteFile, outputStream);
            System.out.println("Downloaded: " + remoteFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
