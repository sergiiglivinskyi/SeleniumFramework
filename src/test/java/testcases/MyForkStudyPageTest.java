package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pajeobjects.MyForkStudyPage;

import java.util.List;


public class MyForkStudyPageTest extends BaseTest {

    @Test
    public void listOfTopicsWithoutSearch() {
        myForkHomePage.openWebsite();
        myForkHomePage.openCourseGalleryPage();
        myForkStudyPage.openStudyPage();
        myForkStudyPage.verifyDefaultListOfTopics();
    }

    @Test
    public void validateSearchResultsByTopic() {
        String parameter = "es";
        int expectedNumberOfTopics = 7;
        myForkHomePage.openWebsite();
        myForkHomePage.openCourseGalleryPage();
        myForkStudyPage.openStudyPage();
        myForkStudyPage.searchBy(parameter);
        List<String> list = myForkStudyPage.getTopicsList();

        int actualNumberOfTopics = myForkStudyPage.countSearchResults(list);
        myForkStudyPage.validateIntWithAssertEqual(actualNumberOfTopics, expectedNumberOfTopics);
        System.out.println("Number of topics found: " + actualNumberOfTopics);

        int actualNumberOfTopicsBySubstringInString = myForkStudyPage.numberOfTopicsBySubstringInList(parameter, list);
        myForkStudyPage.validateIntWithAssertEqual(actualNumberOfTopicsBySubstringInString, expectedNumberOfTopics);
        System.out.println("'" + parameter + "'" + " was found in all topics. Search results found " + actualNumberOfTopicsBySubstringInString + " topic(s).");
    }

    @Test
    public void validateSearchResultsByNumberOfMaterials() {
        String parameter = "66";
        int expectedTotalSearchResults = 1;
        myForkHomePage.openWebsite();
        myForkHomePage.openCourseGalleryPage();
        myForkStudyPage.openStudyPage();
        myForkStudyPage.searchBy(parameter);
        List<String> list = myForkStudyPage.getNumberOfMaterialsList();

        int actualTotalSearchResults = myForkStudyPage.countSearchResults(list);
        myForkStudyPage.validateIntWithAssertEqual(actualTotalSearchResults, expectedTotalSearchResults);
        System.out.println("Number of topics found by searching number of materials : " + actualTotalSearchResults);


        int actualNumberOfTopicsHavingSubstringInString = myForkStudyPage.numberOfTopicsBySubstringInList(parameter, list);
        myForkStudyPage.validateIntWithAssertEqual(actualNumberOfTopicsHavingSubstringInString, expectedTotalSearchResults);
        System.out.println("'" + parameter + "'" + " was found in all topics. Search results found " + actualNumberOfTopicsHavingSubstringInString + " topic(s).");

    }
}
