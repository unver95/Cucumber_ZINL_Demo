package Utilities;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // webDriver 1, webDriver 2
    private static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // Chrome, firefox ...

    public static void setThreadBrowserName(String browserName) {
        GWD.threadBrowserName.set(browserName);
    }

    public static String getThreadBrowserName() {
        return GWD.threadBrowserName.get();
    }

    public static WebDriver getDriver() {

        Logger.getLogger("").setLevel(Level.SEVERE);

        if (threadBrowserName.get() == null)
            threadBrowserName.set("chrome");


        if (threadDriver.get() == null) {
            switch (threadBrowserName.get()) {
                case "firefox": {
                    //    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                    EdgeOptions optFireFox = new EdgeOptions();
                    optFireFox.addArguments("--lang=nl");
                    threadDriver.set(new FirefoxDriver());
                }
                break;
                case "safari": {

                    threadDriver.set(new SafariDriver());
                }
                break;
                case "edge": {
                    System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    EdgeOptions optEdge = new EdgeOptions();
                    optEdge.addArguments("--lang=nl");
                    threadDriver.set(new EdgeDriver());
                }
                break;
                case "brave":
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // Chrome Driver Output Proerty leri susturdu sadece Error verirse bir sey yazacak
                    ChromeOptions optBrave = new ChromeOptions();
                    optBrave.addArguments("--remote-allow-origins=*");
                    optBrave.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
                    optBrave.addArguments("--lang=nl");
                    threadDriver.set(new ChromeDriver(optBrave));
                    break;
                default: { /*Chrome*/
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    ChromeOptions optChrome = new ChromeOptions();
                    //   opt.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe"); Deze en de bovenste zijn voor Brave browser
                    optChrome.addArguments("--lang=nl");
                    System.out.println("Before check for Intelij");
                    if (!runningFromIntelij()) {
                        optChrome.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=7680,4320");
                        System.out.println("Running from Jenkins");
                        threadDriver.set(new ChromeDriver(optChrome));
                    } else {
                        threadDriver.set(new ChromeDriver(optChrome));
                    }
                }
                break;
            }
        }
        threadDriver.get().manage().window().maximize();
        return threadDriver.get();
    }

    public static boolean runningFromIntelij() { //TODO Sunuma ekle: Burda bakiyor intelij de mi calisiyor diye
        String classPath = System.getProperty("java.class.path");
        return classPath.contains("idea_rt.jar");
    }


    public static void quitDriver() {
        //TODO CMD den kapatma da mi yapsak burda herhalde su anda yok
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null) {
            //   threadDriver.get().quit();
            WebDriver driver = threadDriver.get();
            driver = null;
            threadDriver.set(driver);
        }
    }
}

