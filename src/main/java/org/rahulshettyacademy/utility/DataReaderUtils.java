package org.rahulshettyacademy.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReaderUtils {
    public static List<HashMap<String, String>> getJSONData(String filePath) throws IOException {
        File file = new File(filePath);
        String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();

        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

}
