package Bundle;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BundleAutomation {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		dc.setCapability(MobileCapabilityType.VERSION, 10.0); //version is number here
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		
				
		dc.setCapability("appPackage", "com.bundle.billable_hours_app");
		dc.setCapability("appActivity", "com.bundle.billable_hours_app.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
		
		driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
		
		Thread.sleep(5000);
		
		driver.findElementByClassName("android.widget.EditText").click();
		Thread.sleep(2000);
		driver.findElementByClassName("android.widget.EditText").sendKeys("/SD Card/Download/sample1.csv");
		driver.findElementByClassName("android.view.View").click();
		Object ans = driver.findElementByClassName("android.view.View").getText();
		System.out.println(ans);
	}
}
