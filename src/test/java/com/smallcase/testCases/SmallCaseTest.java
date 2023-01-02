package com.smallcase.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.smallcase.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public class SmallCaseTest extends BaseClass{

	Utils utils;
	@Test
	 public void Test1()
    {
        RestAssured.baseURI ="https://bookstore.toolsqa.com/";
        String Result = given().log().all().get("BookStore/v1/Books").then().log().all().
        				assertThat().statusCode(200).extract().response().asString();
        System.out.println(Result);
        JsonPath js =new JsonPath(Result);
        
        //Total Count of isbn 
        String isbnCount = js.getString("books.isbn");
        String isbnCounts = isbnCount.replace("[", "").replace("]", "");
         String[] TotalCount = isbnCounts.split(", ");  
        for(int i =0;i<TotalCount.length;i++)
        {    
            String publish_date=js.getString("books["+i+"].publish_date");
            boolean PublishDate = utils.isDate(publish_date);
            Assert.assertTrue(PublishDate, "Date Publish datatype is Date as per requirement");
            System.out.println("Date Publish datatype is Date as per requirement");
            
            String Page=js.getString("books["+i+"].pages");
            boolean Pages = utils.isInteger(Page);
            Assert.assertTrue(Pages, "Pages datatype is int as per requirement");
            System.out.println("Pages datatype is int as per requirement");

            String title=js.getString("books["+i+"].title");
            boolean Title = utils.isChar(title);
            Assert.assertTrue(Title, "Title datatype is char as per requirement");
            System.out.println("Title datatype is char as per requirement");

            String subTitle=js.getString("books["+i+"].subTitle");
            boolean SubTitle = utils.isChar(subTitle);
            Assert.assertTrue(SubTitle, "subTitle datatype is char as per requirement");
            System.out.println("subTitle datatype is char as per requirement");
            
            String author=js.getString("books["+i+"].author");
            boolean Author = utils.isChar(author);
            Assert.assertTrue(Author, "author datatype is char as per requirement");
            System.out.println("author datatype is char as per requirement");
            
            String publisher=js.getString("books["+i+"].publisher");
            boolean Publisher = utils.isChar(publisher);
            Assert.assertTrue(Publisher, "Publisher datatype is char as per requirement");
            System.out.println("Publisher datatype is char as per requirement");
            
            String description=js.getString("books["+i+"].description");
            boolean Description = utils.isChar(description);
            Assert.assertTrue(Description, "Description datatype is String as per requirement");
            System.out.println("Description datatype is String as per requirement");
            
            String website=js.getString("books["+i+"].website");
            boolean Website = utils.isLink(website);
            Assert.assertTrue(Website, "Website datatype is link as per requirement");
            System.out.println("Title datatype is link as per requirement");
        }
    }
}
