from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.select import Select
from selenium.webdriver import Chrome
import time

PATH = "D:/MY FILES/Studies/5 SEMESTER/Software Testing/task3-automated-testing/seleniumWebDrivers/chromedriver.exe"
driver = webdriver.Chrome(PATH)

driver.get("http://127.0.0.1:8080/")

time.sleep(1)

# --- First name input ---
fname_input = driver.find_element_by_id("fname")
fname_input.send_keys("Džiugas")

# --- Last name input ---
lname_input = driver.find_element_by_id("lname")
lname_input.send_keys("Pečiulevičius")

# --- Identity id code input ---
identificationCode_input = driver.find_element_by_id("identificationCode")
identificationCode_input.send_keys('39804108888')

# --- Gender radio ---
driver.find_element_by_css_selector("input[type='radio'][value='male']").click()

# --- Address input ---
address_input = driver.find_element_by_id("address")
address_input.send_keys("Fiziku 69")

# --- Phone input ---
phone_input = driver.find_element_by_id("phone")
phone_input.send_keys('37067946664')

# --- Program dropdown ---
program_input = driver.find_element_by_id("program")
program_object = Select(program_input)
program_object.select_by_value("software-engineering")

# --- Program radio ---
driver.find_element_by_css_selector("input[type='radio'][value='online']").click()

time.sleep(0.5)

# --- Submit button ---
driver.find_element_by_id("btn").click()