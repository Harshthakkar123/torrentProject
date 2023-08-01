package com.example.registrationlogindemo.service.impl;

public class CaptchaResult {
    private final String captchaText;
    private final byte[] captchaImage;

    public CaptchaResult(String captchaText, byte[] captchaImage) {
        this.captchaText = captchaText;
        this.captchaImage = captchaImage;
    }

    public String getCaptchaText() {
        return captchaText;
    }

    public byte[] getCaptchaImage() {
        return captchaImage;
    }
}
