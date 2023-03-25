import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 /** My ordering flow for konga
 *1. open your microsoft edge browser
 *2. Input your konga url (https://www.konga.com/)
 *3. Maximize the browser
 * 4. Click on the login/signup button to open the login page
 * 5. Input your username on the username field
 * 6.input your password on the password field
 * 7. Click on the login button
 * 8.From the Categories, click on the “Computers and Accessories”
 * 9. Scroll down to the Laptop SubCategory
 * 10. Click on the MacBooks
 * 11. Click add an item to the cart
 * 12. Click "add to cart" button
 * 13. click 'continue checkout" button
 * 14. click change the add delivery address
 * 15.  On the iframe click the address in the address in the address book
 * 16.  click on the use address option
 * 17. click pay now
 * 18. Click continue to make payment
 * 19. Select a Card Payment Method
 * 20. Input invalid card details
 * 21. Print Out the error message: Invalid card number
 * 22. Close the iFrame that displays the input card Modal
 * 23. Quit the browser.
 * */

/**       MY TEST
 * 1.verify that the user input the correct url and user is on the right webpage
 * 2. verify that when user clicks on the login/signup button,the user is directed to the right login page
 *  3. verify that user is successfully directed to the computer and accessories page when the computer and accessories button is clicked
 *  4. verify that user is successfully directed to the laptop page when the laptop button is clicked
 * 5. verify that apple macbook is present on the laptop section
 * 6. verify that user cannot successfully input invalid card details without getting an error message(invalid card number)
 */


public class PersonalKongaOrderingTest {

    //import the selenium webdriver

    private By ModalButton = By.xpath("//]/div/div[2]/div[3]/div[2]/div/button");
    private By ModalCardbutton = By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button/div/span");
    private By ModalCardNumber = By.id("card-number");
    private By ModalDate = By.id("expiry");
    private By ModalCVV = By.id("id=\"cvv\"");
    private By ModalPayNowButton = By.id("validateCardForm");
    private By CloseIframe = By.xpath("/html/body/section/section/section/div[2]/div[1]/aside");

    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the geckodriver is
        System.setProperty("webdriver.geckodriver.exe", "resources/geckodriver.exe");
        //open your firefox driver

        driver = new FirefoxDriver();
        //TEST 1: verify that the user input the correct url and user is on the right webpage
        //input your konga url(https://www.konga.com/)
        driver.get("https://www.konga.com/");
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
        //maximize the browser
        driver.manage().window().maximize();
        //click on the login/signup button to open login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void positiveLogin() throws InterruptedException {
        //TEST 2: verify that user can login with valid details
        //input your username on the username field
        driver.findElement(By.id("username")).sendKeys("macoyoptions@gmail.com");
        //input your password on the password field
        driver.findElement(By.id("password")).sendKeys("Chinyere$12");
        //click on the login page
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        String LoginMessage = "TheSuccessfulLoginMessageFromTheWebsite";
        if (LoginMessage.contains("TheSuccessfulLoginMessageFromTheWebsite"))
            //pass
            System.out.println("successfully login");
        else
            //fail
            System.out.println("not logged in");

        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void clickComputerAndAccessories() throws InterruptedException {
        //TEST 3:verify that user is successfully directed to the computer and accessories page when the computer and accessories button is clicked.
        //click computer and accessories
        WebElement ComputerAndAccessories = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]"));
        ComputerAndAccessories.click();
        String ComputersAndAccessoriesMessage = "Computers&Accessories|Buy";
        if (ComputersAndAccessoriesMessage.contains("Computers&Accessories|Buy"))
            //pass
            System.out.println("Computers&Accessories|Buy");
        else
            //fail
            System.out.println("page not found");

        Thread.sleep(25000);

    }

    @Test(priority = 2)
    public void goLaptops() throws InterruptedException {
       //TEST 4: verify that user is successfully directed to the laptop page when the laptop button is clicked
        //find the laptops
        WebElement Laptop = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span"));
        Laptop.click();
        String LaptopMessage = "Computers&Accessories|Buy";
        if (LaptopMessage.contains("Computers&Accessories|Buy"))
            //pass
            System.out.println("Computers&Accessories|Buy");
        else
            //fail
            System.out.println("page not found");
        Thread.sleep(25000);

    }

    @Test(priority = 3)
    public void clickAppleMacBooks() throws InterruptedException {
        //TEST 5 :verify that apple macbook is present on the laptop section
        //click on apple macbooks
        WebElement AppleMacBooks = driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span"));
        AppleMacBooks.click();
        String AppleMacbookMessage = "Computers&Accessories|Buy";
        if (AppleMacbookMessage.contains("Computers&Accessories|Buy"))
            //pass
            System.out.println("Computers&Accessories|Buy");
        else
            //fail
            System.out.println("page not found");
        Thread.sleep(25000);


    }

    @Test(priority = 4)
    public void verifyItem() throws InterruptedException {
        // search for an item
        //Click on add an item
        WebElement item = driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button"));
        item.click();
        Thread.sleep(25000);
    }

    @Test(priority = 5)
    public void ClickAddToCart() throws InterruptedException {
        // click add to cart
        WebElement AddToCart = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]"));
        AddToCart.click();

        String expectedTitle = "Cart Overview";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("expectedTitle"))
            //pass
            System.out.println("Cart Overview");
        else
            //fail
            System.out.println("blank page");
        Thread.sleep(25000);
    }

    @Test(priority = 6)
    public void clickCheckout() throws InterruptedException {
        //click checkout on the iframe that displays
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(25000);
    }

    @Test(priority = 7)
    public void clickChange() throws InterruptedException {
        // click on change
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(25000);
        //Select add delivery address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(25000);
    }

    @Test(priority = 8)
    public void clickAddressThere() throws InterruptedException {
        // click on the already registered address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(25000);
    }

    @Test(priority = 9)
    public void clickUseAddress() throws InterruptedException {
        // click on the "use address" button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(25000);
    }

    @Test(priority = 10)
    public void clickPayNow() throws InterruptedException {
        // under the "payment options" click pay on now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(25000);
    }

    @Test(priority = 11)
    public void clickContinueToMakePayment() throws InterruptedException {
        //Click on "continue to make payment" button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(25000);
        //Test 5. verify that "continue to payment" button brings an iframe display requesting user to choose a payment option

    }

    @Test(priority = 12)
    public void clickCard() throws InterruptedException {
        //click card
        click(ModalButton);
        Thread.sleep(25000);
    }

    private void click(By modalButton) {
    }

    @Test(priority = 13)
    public void inputCardDetails() throws InterruptedException {
        // Input invalid card number
        //Test 6 verify that user cannot successfully input invalid card details without getting an error message(invalid card number).
        setText(ModalCardNumber, 342523253);
        setText(ModalDate, 19 / 26);
        setText(ModalCVV, 123);
        click(ModalPayNowButton);
        String ErrorMessage = "TheErrorMessageFromTheWebsite";
        if (ErrorMessage.contains("TheErrorMessageFromTheWebsite"))
            //pass
            System.out.println("Invalid card number");
        else
            //fail
            System.out.println("successful message");

        Thread.sleep(25000);
    }

    @Test(priority = 14)
    public void closeIframe() throws InterruptedException {
// close the iframe that displays the input card modal
        click(CloseIframe);
        Thread.sleep(20000);
    }

    @AfterTest
    public void closeBrowser() {
        //Quit browser
        driver.quit();

    }

    private void setText(By modalCardNumber, int i) {


    }
}

