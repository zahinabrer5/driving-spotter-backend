package org.zahin.DrivingSpotter.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zahin.DrivingSpotter.DrivingSpotterApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OcrService {

    private final RestTemplate restTemplate;

    public OcrService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String performOcr(String imgBase64) throws Exception {
        String ocrApiUrl = "https://api.groq.com/openai/v1/chat/completions";
        String apiKey = DrivingSpotterApplication.dotenv.get("GROQ_API_KEY");

        // Construct the JSON payload
        Map<String, Object> imagePayload = Map.of(
                "type", "image_url",
                "image_url", Map.of("url", "data:image/jpeg;base64," + imgBase64)
        );

        Map<String, Object> textPayload = Map.of(
                "type", "text",
                "text", "Give me the license plate code in this image of a Canadian license plate (using OCR), give me ONLY the code as a plain text 7 character string, without any markdown formatting."
        );

        Map<String, Object> messagePayload = Map.of(
                "role", "user",
                "content", List.of(textPayload, imagePayload)
        );

        Map<String, Object> requestPayload = new HashMap<>();
        requestPayload.put("messages", List.of(messagePayload));
        requestPayload.put("model", "llama-3.2-11b-vision-preview");
        requestPayload.put("temperature", 1);
        requestPayload.put("max_completion_tokens", 1024);
        requestPayload.put("top_p", 1);
        requestPayload.put("stream", false);
        requestPayload.put("stop", null);

        // Set up the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        // Create the request entity
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestPayload, headers);

        // Make the POST request
        return restTemplate.postForObject(ocrApiUrl, request, String.class);
    }
}
