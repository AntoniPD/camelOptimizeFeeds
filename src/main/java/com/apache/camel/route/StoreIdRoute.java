package com.apache.camel.route;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StoreIdRoute {

    public static List<String> storeIds;
    // TODO: refactor
    private static File file = new File("data/stores/stores.csv");
    private static Long lastModified;

    public static List<String> getStoreIds() throws Exception {
        if (lastModified == null || lastModified != file.lastModified()) {
            lastModified = file.lastModified();
            storeIds = readLines(file);
        }
        return storeIds;
    }

    private static List<String> readLines(File file) throws Exception {
        if (!file.exists()) {
            return new ArrayList<String>();
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> results = new ArrayList<>();
        String line = reader.readLine();
        if (line.equals("store_id")) {
            line = reader.readLine();
        }
        while (line != null && !line.isEmpty()) {
            results.add(line);
            line = reader.readLine();
        }
        reader.close();
        return results;
    }

}