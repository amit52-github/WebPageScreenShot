package com.java.service;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.json.JSONObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


@Service
public class WebPageScreenShotServiceImpl implements WebPageScreenShotService {
	

	static int screenshotNo=0;
	
	
	
	public String capture(String site)
	{
		
		String response = "";
		screenshotNo++;
		JSONObject jsonReq = new JSONObject(site);
		if(jsonReq.has("url")) {
		try {
			String url = jsonReq.getString("url");
			System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
			WebDriver driver  = new ChromeDriver();	
		driver.manage().window().setPosition(new Point(-2000, 0));
		driver.get(url);
		driver.manage().window().maximize();
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("D://screenshot//Screenshot"+screenshotNo+".jpg"));
		driver.manage().window().setPosition(new Point(-2000, 0));
		response = "Successfully created";
	}catch(IOException e) {
		e.printStackTrace();
		response = "Error";
	}} else {
		response = "Invalid url";
	}
		return response;
	}
	
	
	

}
