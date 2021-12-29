package com.eacuamba.config.resource_bundle;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ResourceBundleWraper extends ResourceBundle {
    public ResourceBundleWraper(ResourceBundle parent) {
        setParent(parent);
    }

    @Override
    protected Object handleGetObject(String key) {
        return parent.getObject(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        return parent.getKeys();
    }

    public static class Control  extends ResourceBundle.Control {
        private String enoding;
        private String extension;

        public Control(String encoding, String extension) {
            this.enoding = encoding;
            this.extension = extension;

        }

        @Override
        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IOException {
            String bundleName = toBundleName(baseName, locale);
            String resourceName = toResourceName(bundleName, extension);
            ResourceBundle resourceBundle = null;
            InputStream inputStream = null;

            if (reload) {
                URL url = loader.getResource(resourceName);
                if (url != null) {
                    URLConnection urlConnection = url.openConnection();
                    if (urlConnection != null) {
                        urlConnection.setUseCaches(false);
                        inputStream = urlConnection.getInputStream();
                    }
                }
            } else {
                inputStream = loader.getResourceAsStream(resourceName);
            }
            if (inputStream != null) {
                try {
                    resourceBundle = new PropertyResourceBundle(new InputStreamReader(inputStream, this.enoding));
                } finally {
                    inputStream.close();
                }
            }
            return resourceBundle;
//            return super.newBundle(baseName, locale, format, loader, reload);
        }
    }


}
