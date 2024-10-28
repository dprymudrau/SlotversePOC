package com.sloverset.qa.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ImageHelper {

    public static String getReferenceImageB64(String imagePath) {
        URL refImgUrl = ImageHelper.class.getClassLoader().getResource(imagePath);
        assert refImgUrl != null;
        File refImgFile = null;
        try {
            refImgFile = Paths.get(refImgUrl.toURI()).toFile();
            return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
