
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegestrationScreen {
    public static String regesterbuton="il.co.mintapp.buyme:id/walletTab";
    public static By googlebuton=MobileBy.id("il.co.mintapp.buyme:id/googleButton");
    public static By creatacount=MobileBy.className("android.widget.Button");
    public static By presspincode=MobileBy.id("com.android.settings:id/password_entry");
    public static By enteremail=MobileBy.id("identifierId");
    public static By next=MobileBy.id("identifierNext");
    public static By getpasswored=MobileBy.id("password");
    public static By next2=MobileBy.className("android.view.View");
    public static By enternumber=MobileBy.id("il.co.mintapp.buyme:id/pinBox");
public static AndroidDriver<MobileElement> driver;

    public static DesiredCapabilities capabilities;
    private static String getData (String keyName) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File("C:\\Users\\Comp29\\Desktop\\App.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        assert dBuilder != null;
        doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    @BeforeClass
    public static void setcapabilites() throws IOException, SAXException, ParserConfigurationException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "hawawi p9 lite");
           capabilities.setCapability("appPackage",getData("apppackage"));
           capabilities.setCapability("appActivity",getData("appactivity"));
           getData("appactivity");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
            capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }

        @Test
    public void test1_regesterbutton(){
        driver.findElement(MobileBy.id(RegestrationScreen.regesterbuton)).click();
        driver.findElement(RegestrationScreen.googlebuton).click();
        driver.findElement(RegestrationScreen.next2).click();


        }
        @Test
    public void test2_hoomscreentest(){
        Homscreen.preescatagory(driver);
        Homscreen.pressbusnis(driver);
        Homscreen.entergiftbudgit(driver);
        Homscreen.presbuy(driver);

        }

        @Test
    public void test3_receverandsenderinfo(){
        SenderReceverInformation.enterReceverName(driver);
            SenderReceverInformation.selectEvent(driver);
            SenderReceverInformation.getBlesingText(driver);
            SenderReceverInformation.enterSenderName(driver);
            SenderReceverInformation.preeContenu(driver);

        }




        @Test
    public void test4_howToPay1(){
        HowToPay.preeSendRightNow(driver);
            HowToPay.pressEmailSendOption(driver);
            HowToPay.pressContenu(driver);

        }
        @AfterClass
    public static void logoutandclosedriver(){
        driver.closeApp();
        }



    }


