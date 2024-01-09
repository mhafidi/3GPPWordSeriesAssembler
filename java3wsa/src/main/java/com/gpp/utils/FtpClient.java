package com.gpp.utils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class FtpClient {
    FTPClient ftpClient;

    public FtpClient(String serverName) throws IOException {
        ftpClient=new FTPClient();
        ftpClient.connect(serverName);

    }

    //    FtpClient ftpClient = new FtpClient();
//ftpClient.connect("ftp.server.com");
//ftpClient.login("username", "password");
//ftpClient.enterLocalPassiveMode();
//ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

}
