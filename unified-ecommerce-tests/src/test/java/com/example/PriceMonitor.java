package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * PriceMonitor class for tracking product prices and sending email notifications
 * Integrated within the unified ecommerce test suite
 */
public class PriceMonitor {

    private static final Logger logger = Logger.getLogger(PriceMonitor.class.getName());

    private WebDriver driver;
    private WebDriverWait wait;
    private String productUrl;
    private double thresholdPrice;

    public PriceMonitor(String productUrl, double thresholdPrice) {
        this.productUrl = productUrl;
        this.thresholdPrice = thresholdPrice;

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080", "--no-sandbox");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        logger.info("PriceMonitor initialized for product: " + productUrl);
    }

    public void checkPrice() {
        try {
            logger.info("Checking price for product...");
            driver.get(productUrl);
            Thread.sleep(3000);

            double currentPrice = extractPrice();
            logger.info("Current price: $" + currentPrice + ", Threshold: $" + thresholdPrice);

            if (currentPrice > 0 && currentPrice <= thresholdPrice) {
                logger.info("Price drop detected! Sending notification...");
                sendEmailNotification("Price Drop Alert!", "Product price has dropped to $" + currentPrice);
            } else {
                logger.info("No price drop detected.");
            }

        } catch (Exception e) {
            logger.severe("Error checking price: " + e.getMessage());
        }
    }

    private double extractPrice() {
        try {
            String[] selectors = {
                ".a-price .a-offscreen",
                "#priceblock_ourprice",
                "#priceblock_dealprice",
                ".a-color-price",
                "[data-cy='price-recipe']"
            };

            for (String selector : selectors) {
                List<WebElement> priceElements = driver.findElements(By.cssSelector(selector));
                for (WebElement priceElement : priceElements) {
                    String priceText = priceElement.getText().trim();
                    logger.fine("Found price text: '" + priceText + "' with selector: " + selector);
                    if (!priceText.isEmpty()) {
                        String cleanPrice = priceText.replaceAll("[^0-9.,]", "");
                        if (cleanPrice.contains(",")) {
                            cleanPrice = cleanPrice.replace(",", "");
                        }
                        try {
                            double price = Double.parseDouble(cleanPrice);
                            if (price > 0) {
                                logger.info("Extracted price: $" + price);
                                return price;
                            }
                        } catch (Exception e) {
                            logger.warning("Could not parse price: " + cleanPrice);
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.warning("Could not extract price: " + e.getMessage());
        }
        return 0.0;
    }

    public void sendEmailNotification(String subject, String message) {
        // Note: This is a demo implementation with placeholder credentials
        // In a real application, use secure credential management
        final String fromEmail = "your-email@gmail.com"; // Replace with actual email
        final String password = "your-app-password"; // Replace with app password
        final String toEmail = "recipient@example.com"; // Replace with recipient

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject(subject);
            msg.setText(message + "\n\nProduct URL: " + productUrl);

            Transport.send(msg);
            logger.info("Email notification sent successfully");

        } catch (MessagingException e) {
            logger.severe("Failed to send email notification: " + e.getMessage());
            throw new RuntimeException("Email sending failed", e);
        }
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
