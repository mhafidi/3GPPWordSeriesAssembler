package com.gpp.clients;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class FtpClient implements Client {
    FTPClient ftpClient;
    private String serverName;

    public FtpClient(String serverName) {
        this.ftpClient=new FTPClient();
        this.serverName=serverName;
    }

    @Override
    public void connect() {
        if (ftpClient!= null) {
            try {
                ftpClient.connect(serverName);
            } catch (IOException e) {
                //TODO to be modified when including a logger library
                System.err.println("server name not found ["+serverName+"]");
            }
        }
    }

    //    FtpClient ftpClient = new FtpClient();
//ftpClient.connect("ftp.server.com");
//ftpClient.login("username", "password");
//ftpClient.enterLocalPassiveMode();
//ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

}
