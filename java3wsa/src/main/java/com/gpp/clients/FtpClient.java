package com.gpp.clients;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class FtpClient implements Client {
    public static final String ANONYMOUS = "anonymous";
    FTPClient ftpClient;
    private String serverName;
    int port;

    public FtpClient(String serverName,int port) {
        this.ftpClient=new FTPClient();
        this.serverName=serverName;
        this.port = port;
    }

    @Override
    public void connect() {
        if (ftpClient!= null) {
            try {
                ftpClient.connect(serverName,port);
                ftpClient.login(ANONYMOUS, "");
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            } catch (IOException e) {
                //TODO to be modified when including a logger library
                System.err.println("server name not found ["+serverName+"]");
            }
        }
    }
    public FTPFile[] listFiles() {
        try {
            return ftpClient.listFiles();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void disconnect() {
        if(ftpClient!=null){
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                //TODO once introducing logger library to be changed
                System.err.println("Cannot disconnect FTP Client Error Occurred");
            }
        }
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }
    public void changeDirectory(String remoteDirectory) {
        try {
            ftpClient.changeWorkingDirectory(remoteDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //    FtpClient ftpClient = new FtpClient();
//ftpClient.connect("ftp.server.com");
//ftpClient.login("username", "password");
//ftpClient.enterLocalPassiveMode();
//ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

}
