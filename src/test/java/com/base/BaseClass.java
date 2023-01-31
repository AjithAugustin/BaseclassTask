package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static void getDriver() {
    WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
    }
	public static void getUrl(String url) {
		
		driver.get(url);
		}
	public static void maximizeWindow() {
		
		driver.manage().window().maximize();

	}
	public void sendKeys(WebElement element, String text) {
		element.sendKeys(text);

	}
	public void click(WebElement element) {
		
		element.click();
		
       }
	public void acceptAlert() {
		driver.switchTo().alert().accept();

	}
	public void dissmissAlert() {
		driver.switchTo().alert().dismiss();

	}
	public String getTextElement(WebElement element) {
		String text = element.getText();
      return text;
	}
	public String getValueTextbox(WebElement element) {
		 
	     String attribute = element.getAttribute("value");
		
   return attribute;
	}
	public String getValueTextbox(WebElement element,String attributeName) {
		 String attribute = element.getAttribute(attributeName);
		
    return attribute;
	}
   public static void closeAllWindow() {
	  driver.quit();

    }
   public void closeCurrentWindow() {
	driver.close();
   }
   public String getTitle() {
	String title = driver.getTitle();
	return title;
   }
   public String getEnteredUrl() {
	String currentUrl = driver.getCurrentUrl();
    return currentUrl;
   }
   public void selectoptionByText(WebElement element,String text) {
	Select select = new Select(element);
	select.selectByVisibleText(text);

    }
   public void selectoptionByAttribute(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
       }
   public void selectoptionByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
      }
   public void insertValueJs(WebElement element, String text) {
	  JavascriptExecutor executor =(JavascriptExecutor)driver;
      executor.executeScript("arguments[0].setAttribute('value','"+text+"')", element);
	}
   public void buttonClickJs(WebElement element) {
	   JavascriptExecutor executor =(JavascriptExecutor)driver;
	   executor.executeScript("arguments[0].click()", element);
		
      }
   public Set<String> switchToChildWindow(String window) {
	String parentWindow = driver.getWindowHandle();
    Set<String> allWindows = driver.getWindowHandles();
    for (String eachWindow : allWindows) {
		if(!parentWindow.equals(eachWindow)) {
			
			driver.switchTo().window(eachWindow);
		}
		
	}
	return allWindows;
    }
   
   public void switchToFrameByIndex(int index) {
	driver.switchTo().frame(index);

    }
   public void switchToFrameByFrameId(String nameOrId ) {
	driver.switchTo().frame(nameOrId);

   }
   
   public void switchToFrameByFrameElement(WebElement frameElement) {
	
	   driver.switchTo().frame(frameElement);

}
   public WebElement findElementById(String attributeValue) {
	   WebElement element = driver.findElement(By.id(attributeValue));
	   return element;
	}
   public WebElement findElementByName(String attributeValue) {
      WebElement element = driver.findElement(By.name(attributeValue));
      return element;
}
   public WebElement findElementByClassName(String attributeValue) {
	   WebElement element = driver.findElement(By.className(attributeValue));
	   return element;
	}
   
   public WebElement findElementByXpath(String xpathExpression) {
	   WebElement element = driver.findElement(By.xpath(xpathExpression));
	   return element;
	}
   
   public List<WebElement> getAllOptionsFromDropDownText(WebElement element) {
	  Select select = new Select(element);
	  List<WebElement> options = select.getOptions();
	  for (WebElement webElement : options) {
		String text = webElement.getText();
		System.out.println(text);
		}
   return options;
   }
   public List<WebElement> getAllOptionsFromDropDownAttributeValue(WebElement element,String value) {
		  Select select = new Select(element);
		  List<WebElement> options = select.getOptions();
		  for (WebElement webElement : options) {
			String text = webElement.getAttribute(value);
			System.out.println(text);
			}
	   return options;
	   }
   
   public String getFirstSelectedOptiontextWeb(WebElement element) {
	  Select select = new Select(element);
      String text = select.getFirstSelectedOption().getText();
      return text;
   }
   public Boolean isMultiSelectoption(WebElement element) {
	  Select select = new Select(element);
      boolean multiple = select.isMultiple();
      return multiple;
   }
   public void implicitWait(int duration) {
	   driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
	
     }
   public void pageLoadWait(int duration) {
     driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.SECONDS);
     }
   public Boolean isDisplayed(String attributeValue) {
	   boolean displayed = driver.findElement(By.id(attributeValue)).isDisplayed();
       return displayed;
      }
   public Boolean isEnabled(String attributeValue) {
	   boolean displayed = driver.findElement(By.id(attributeValue)).isEnabled();
       return displayed;
      }
   public Boolean isSelected(String attributeValue) {
	   boolean displayed = driver.findElement(By.id(attributeValue)).isSelected();
       return displayed;
      }
   public void deselectByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);

	    }
   public void deselectByValue(WebElement element,String value) {
		Select select = new Select(element);
		select.deselectByValue(value);

	    }
   public void deselectByVisibleText(WebElement element,String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);

	    }
   public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();

	    }
   public String getCurrentWindow() {
	   String currentWindow = driver.getWindowHandle();
       return currentWindow;
       }
   public Set<String> getAlltWindows() {
	   Set<String> allWindows = driver.getWindowHandles();
       return allWindows;
       }
   public void clearText(WebElement element) {
	   element.clear();
	
     }
   public File takeScreenshot(String path) throws IOException {
	TakesScreenshot screenshot =(TakesScreenshot)driver;
	File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
	File destination = new File(path);
	FileUtils.copyFile(screenshotAs, destination);
	return screenshotAs;
     }
	
   public File takeScreenshotForElement(WebElement element) {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	     }
   public void moveToElement(WebElement element) {
	  Actions actions = new Actions(driver);
	  actions.moveToElement(element).perform();

      }
   public void dragAndDrop(WebElement element) {
		  Actions actions = new Actions(driver);
		  actions.dragAndDrop(element, element).perform();

	      }
   public void moveToElement() {
		  Actions actions = new Actions(driver);
		  actions.contextClick().perform();
	      }
   public void doubleClick() {
		  Actions actions = new Actions(driver);
		  actions.doubleClick().perform();

	      }
//   public void InsertValueAndEnter(WebElement element,String text) {
//	element.sendkeys(text,Keys.ENTER);
//
//       }
   public void RefreshPage() {
	driver.navigate().refresh();

    }
   public String getPageSource() {
	String pageSource = driver.getPageSource();
	return pageSource;
      }
   public void backWebpage() {
	driver.navigate().back();

    }
   public void forwardWebpage() {
		driver.navigate().forward();

	    }
   public void LaunchBrowserByToString(String url) {
		driver.navigate().to(url);

	    }
   public void LaunchBrowserByToUrlUrl(String url) {
		driver.navigate().to(url);

	    }
   public void ThreadSleep(Long millis) throws InterruptedException {
	   Thread.sleep(millis);
 	}
   public List<WebElement> findElementsTable(String tagName) {
	List<WebElement> findElements = driver.findElements(By.tagName(tagName));
    return findElements;
   }
   
   public String getcellData(String sheetName,int rownum,int cellnum) throws IOException {
	
	   String res="";
	   File file = new File("C:\\Users\\MUTHU\\eclipse-workspace\\BaseClass\\Excel\\Adactin Hotel.xlsx");
	   FileInputStream stream = new FileInputStream(file);
	   Workbook workbook = new XSSFWorkbook(stream);
	   Sheet sheet = workbook.getSheet(sheetName);
	   Row row = sheet.getRow(rownum);
	   Cell cell = row.getCell(cellnum);
	   CellType type = cell.getCellType();
	   
	   switch (type) {
	case STRING:
		//String stringCellValue
		res = cell.getStringCellValue();
		
		break;
	case NUMERIC:
		if (DateUtil.isCellDateFormatted(cell)) {
		Date dateCellValue = cell.getDateCellValue();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		//String format
		res = dateformat.format(dateCellValue);
		}else {
			double numericCellValue = cell.getNumericCellValue();
			long check = Math.round(numericCellValue);
		
		if (check==numericCellValue) {
				//String valueOf 
				res = String.valueOf(numericCellValue);
			}else {
				//String valueOf
				res = String.valueOf(check);
				
			}
		
		break;
		}

	default:
		break;
		}
	   
	return res;
   }
   
   public static void getAllCellData(String path,String sheetName) throws IOException {

		String res = "";
		File file = new File(path);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			Row row = sheet.getRow(i);
			if (row != null) {

				for (int j = 0; j < row.getLastCellNum() + 1; j++) {

					Cell cell = row.getCell(j);
					if (cell != null) {

						CellType type = cell.getCellType();
						switch (type) {
						case STRING:
							res = cell.getStringCellValue();
							System.out.println(res);
							break;
						case NUMERIC:

							if (DateUtil.isCellDateFormatted(cell)) {

								Date date = cell.getDateCellValue();
								SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
								res = dateFormat.format(date);
								System.out.println(res);
							} else {
								double numericCellValue = cell.getNumericCellValue();
								long round = Math.round(numericCellValue);
								if (round == numericCellValue) {
									res = String.valueOf(numericCellValue);
									System.out.println(res);
								} else {
									res = String.valueOf(round);
									System.out.println(res);
								}

							}

							break;
						default:
							break;
						}
					}

				}

			}

		}

	}
 
   
  public void updateCellData(String sheetName,int rownum,int cellnum,String oldData,String newData) throws IOException {
	
	  File file = new File("C:\\Users\\MUTHU\\eclipse-workspace\\BaseClass\\Excel\\Adactin Hotel.xlsx");
	  FileInputStream stream = new FileInputStream(file);
	  Workbook workbook = new XSSFWorkbook(stream);
	  Sheet sheet = workbook.getSheet(sheetName);
	  Row row = sheet.getRow(rownum);
	  Cell cell = row.getCell(cellnum);
	  
	  String value = cell.getStringCellValue();
	  
	  if (value.equals(oldData)) {
		  cell.setCellValue(newData);
		  }
	  FileOutputStream outputStream = new FileOutputStream(file);
	  workbook.write(outputStream);
	  } 
   public void writeCellData(String sheetName, int rownum,int cellnum,String data) throws IOException {
	   
	   File file = new File("C:\\Users\\MUTHU\\eclipse-workspace\\BaseClass\\Excel\\Adactin Hotel.xlsx");
	   FileInputStream stream = new FileInputStream(file);
	   Workbook workbook = new XSSFWorkbook(stream);
	   Sheet sheet = workbook.getSheet(sheetName);
	   Row row = sheet.getRow(rownum);
	   Cell cell = row.createCell(cellnum);
	   cell.setCellValue(data);
	   FileOutputStream outputStream = new FileOutputStream(file);
	   workbook.write(outputStream);
	
       }
   public void scrollDownJs(WebElement element) {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeAsyncScript("arguments[0].scrollIntoView(true)", element);
       }
   
   public void scrollUpJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeAsyncScript("arguments[0].scrollIntoView(false)", element);
	       }
   
    
}
   
   
