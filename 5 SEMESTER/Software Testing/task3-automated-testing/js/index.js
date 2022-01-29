const {Builder, By, Key, until} = require('selenium-webdriver');

(async function test() {
    let driver = await new Builder().forBrowser('chrome').build();
    try {
        // Navigate to Url
        await driver.get('http://127.0.0.1:8080/');

        await driver.findElement(By.name('fname')).sendKeys('Džiugas');
        await driver.findElement(By.name('lname')).sendKeys('Pečiulevičius');
        await driver.findElement(By.name('identificationCode')).sendKeys('31234567890');
        await driver.findElement(By.id("male")).click();
        await driver.findElement(By.name('address')).sendKeys('Fizikų 4');
        await driver.findElement(By.name("phone")).sendKeys('+37064444444');
        await driver.findElement(By.id("online")).click();
        
        // there's no way to implement selection from a list in selenium
        new Select (driver.findElement(By.id("program"))).selectByVisibleText("Information Systems");


    } catch(e) {
        console.log("error", e)
    }
    
})();