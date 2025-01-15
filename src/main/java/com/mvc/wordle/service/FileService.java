package com.mvc.wordle.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Service
public class FileService {
    
    public List<String> readFileLinesToArray() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/file/words.txt");
        String fileContent = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        String[] lines = fileContent.split("\\r?\\n");
        return Arrays.stream(lines)
                .filter(FileService::wordLength)
                .toList();
    }

    private static boolean wordLength(String obj) {
        return obj.length() > 4 && obj.length() < 10;
    }


}
