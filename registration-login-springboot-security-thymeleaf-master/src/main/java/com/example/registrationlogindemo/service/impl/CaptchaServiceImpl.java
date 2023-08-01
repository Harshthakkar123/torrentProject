package com.example.registrationlogindemo.service.impl;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

@Service
public class CaptchaServiceImpl {

    private final int width = 150;
    private final int height = 50;
    private final int captchaLength = 6;


    public CaptchaResult generateCaptchaImage() {
        String captchaText = generateRandomCaptchaText();
        BufferedImage captchaImage = generateCaptchaBufferedImage(captchaText);

        byte[] imageBytes;
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ImageIO.write(captchaImage, "png", outputStream);
            imageBytes = outputStream.toByteArray();
        } catch (Exception e) {
            // Handle exception if necessary
            imageBytes = new byte[0];
        }

        return new CaptchaResult(captchaText, imageBytes);
    }

    private String generateRandomCaptchaText() {
        StringBuilder captchaText = new StringBuilder();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < captchaLength; i++) {
            captchaText.append(characters.charAt(random.nextInt(characters.length())));
        }

        return captchaText.toString();
    }

    private BufferedImage generateCaptchaBufferedImage(String captchaText) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        // Fill the background with a white color
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);

        // Draw random lines to make it harder for bots to recognize the characters
        graphics.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 10; i++) {
            int x1 = (int) (Math.random() * width);
            int y1 = (int) (Math.random() * height);
            int x2 = (int) (Math.random() * width);
            int y2 = (int) (Math.random() * height);
            graphics.drawLine(x1, y1, x2, y2);
        }

        // Draw the captcha text
        graphics.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 30);
        graphics.setFont(font);
        int textX = 30;
        int textY = 35;
        graphics.drawString(captchaText, textX, textY);

        graphics.dispose();

        return image;
    }
}
