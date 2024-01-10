package com.gpp;

import com.gpp.files.ZipDownloader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WSAApplication {
    public static void main(String[] args){
        ZipDownloader zipDownloader = new ZipDownloader();
        zipDownloader.downloadZipFiles();
    }
}
