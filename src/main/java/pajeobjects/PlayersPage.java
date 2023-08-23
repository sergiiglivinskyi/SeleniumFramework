package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PlayersPage extends BaseMain{
    public PlayersPage(WebDriver driver,  Logger log) {
        super(driver, log);
    }

    Map<String, List<String>> info;


    By tableRows = By.xpath("//table[@class='stats-table player-ratings-table']//tbody/tr");

    public void openWebsite() {
        driver.get("https://www.hltv.org/stats/players");
    }

    public void clickAgree() {
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
    }

    public int getTableRowsCount() {
        return driver.findElements(tableRows).size();
    }

    public String firstColumnValue(int row) { //player name is parsed here
        return driver.findElement(By.xpath("//table[@class='stats-table player-ratings-table']//tbody/tr[" + row + "]/td[1]/a")).getText();
    }

    public List<String> secondColumnValues(int row) { //corresponding teams player played for are parsed here
        List<WebElement> values = driver.findElements(By.xpath("//table[@class='stats-table player-ratings-table']//tbody/tr[" + row + "]/td[2]//a/img[not(contains(@class, 'night-only'))]"));
        List<String> teamNames = new ArrayList<>();
        for(WebElement value : values) {
            teamNames.add(value.getAttribute("alt"));
        }
        return teamNames;
    }

    public Map<String, List<String>>  playersInfo() {
        info = new HashMap<>();
        for(int i = 1; i < getTableRowsCount(); i++){
            info.put(firstColumnValue(i), secondColumnValues(i));
        }
        return info;
    }

    public void printData() {
        for(int i = 1; i < getTableRowsCount(); i++){
            System.out.println("Player with name " + firstColumnValue(i) + " plays for those teams:");
            System.out.print("Teams: ");
            for(int j = 0; j < info.get(firstColumnValue(i)).size(); j++) {
                System.out.print(info.get(firstColumnValue(i)).get(j) + " | ");
            }
            System.out.println();
            System.out.println("========================================");
        }
    }
}
