# Lab 06

## Overview
This project is part of Lab 06. It includes a Selenium test to verify the presence of the search button on the home page of the BookstoreApp.

## Selenium Test
The Selenium test checks the following functionality:
- **Presence of the Search Button**: Ensures that the search button is present on the home page.

### Example Selenium Test
```java
@Test
public void testSearchButtonPresence() {
    WebElement searchButton = driver.findElement(By.cssSelector("input[type='submit']"));
    assertNotNull(searchButton, "Search button should be present on the home page");
}
Name: Saja Elkurtehi
Student Number: 300288667
