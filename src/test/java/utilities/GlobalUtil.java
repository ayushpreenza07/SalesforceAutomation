package utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * This class will get date and time and it will rename the file with date and
 * time
 */
public class GlobalUtil {

	private static CommonSettings commonSettings = new CommonSettings();
	private static WebDriver driver = null;

	/**
	 * The constant result_FolderName.
	 */
	public static String result_FolderName = System.getProperty("user.dir") + "/target/cucumber-html-report";

	/**
	/**
	 * The constant errorMsg.
	 */
	public static String errorMsg;
	/**
	 * The constant e.
	 */
	public static Throwable e;

	/**
	 * Gets common settings.
	 *
	 * @return common settings
	 */
	public static CommonSettings getCommonSettings() {
		return commonSettings;
	}

	/**
	 * Sets common settings.
	 *
	 * @param commonSettings the common settings
	 */
	public static void setCommonSettings(CommonSettings commonSettings) {
		GlobalUtil.commonSettings = commonSettings;
	}

	/**
	 * Gets driver.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return driver;
	}



	/**
	 * Sets driver.
	 *
	 * @param driver the driver to set
	 */
	public static void setDriver(WebDriver driver) {
		GlobalUtil.driver = driver;
	}


	/**
	 * Pack current directory contents.
	 *
	 * @param directoryPath the directory path
	 * @param zos           the zos
	 * @throws IOException the io exception
	 */
	public static void packCurrentDirectoryContents(String directoryPath, ZipOutputStream zos) throws IOException {

		for (String dirElement : new File(directoryPath).list()) {

			String dirElementPath = directoryPath + "/" + dirElement;

			if (new File(dirElementPath).isDirectory()) {
				packCurrentDirectoryContents(dirElementPath, zos);

			} else {
				ZipEntry ze = new ZipEntry(dirElementPath.replaceAll(result_FolderName + "/", ""));

				zos.putNextEntry(ze);

				FileInputStream fis = new FileInputStream(dirElementPath);
				byte[] bytesRead = new byte[512];

				int bytesNum;
				while ((bytesNum = fis.read(bytesRead)) > 0) {
					zos.write(bytesRead, 0, bytesNum);
				}

				fis.close();
			}
		}

	}

}
