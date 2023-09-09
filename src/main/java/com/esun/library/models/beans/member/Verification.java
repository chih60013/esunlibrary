package com.esun.library.models.beans.member;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Verification {

	

	    private static final String CHARACTERS = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
	    private static final int CAPTCHA_LENGTH = 6; // 驗證碼的長度

	    public static String generateRandomCaptcha() {
	        Random random = new Random();
	        StringBuilder captcha = new StringBuilder();

	        for (int i = 0; i < CAPTCHA_LENGTH; i++) {
	            int index = random.nextInt(CHARACTERS.length());
	            captcha.append(CHARACTERS.charAt(index));
	        }

	        return captcha.toString();
	    }

	    public static BufferedImage generateCaptchaImage(String captcha) {
	        int width = 200; // 圖像寬度
	        int height = 80; // 圖像高度

	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = image.createGraphics();

	        // 設置背景色
	        g2d.setColor(Color.WHITE);
	        g2d.fillRect(0, 0, width, height);

	        // 設置字體和顏色
	        g2d.setFont(new Font("Arial", Font.BOLD, 36));
	        g2d.setColor(Color.BLACK);

	        // 繪製驗證碼字符
	        g2d.drawString(captcha, 30, 50);

	        g2d.dispose();

	        return image;
	    }

	
	    
	}