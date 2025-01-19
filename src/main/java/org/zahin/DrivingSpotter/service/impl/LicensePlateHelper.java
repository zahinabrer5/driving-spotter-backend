package org.zahin.DrivingSpotter.service.impl;

import org.springframework.web.client.RestTemplate;
import org.zahin.DrivingSpotter.service.OcrService;

public class LicensePlateHelper {
    private static final OcrService ocrService = new OcrService(new RestTemplate());

    // we assume plateImg is a base64 encoded image
    public static String getPlateText(String plateImg) throws Exception {
        return ocrService.performOcr(plateImg);
    }

    public static boolean isValidPlate(String plateText) {
        if (plateText.length() != 7)
            return false;
        for (int i = 0; i < 4; i++) {
            char c = plateText.charAt(i);
            if (!('A' <= c && c <= 'Z'))
                return false;
        }
        for (int i = 0; i < 3; i++) {
            char c = plateText.charAt(i);
            if (!('0' <= c && c <= '9'))
                return false;
        }
        return true;
    }
}
