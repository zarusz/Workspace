package com.cs.fx.fxclient.utils;

import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class SampleUtil {
    public static String loadSample(String resourceName) throws IOException {
        try (InputStream is = SampleUtil.class.getResourceAsStream(resourceName)) {
            if (is == null) {
                throw new FileNotFoundException(String.format("The %s file resource does not exist", resourceName));
            }
            return IOUtils.toString(is, "UTF8");
        }
    }
}
