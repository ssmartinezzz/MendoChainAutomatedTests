package src.tests;

import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import src.core.BaseTest;
import src.core.WineData;
import src.pages.CreateWinePage;
import src.pages.LoggedUserPage;
import src.pages.LoginPage;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.List;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;


public class CreateWineTest extends BaseTest {

    @DataProvider(name = "wineData")
    public Object[][] getWineData() throws FileNotFoundException {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<WineData>>(){}.getType();
        InputStream inputStream = getClass().getResourceAsStream("/wines.json");
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<WineData> wineDataList = gson.fromJson(reader, listType);

        Object[][] wineDataArray = new Object[wineDataList.size()][];
        for (int i = 0; i < wineDataList.size(); i++) {
            WineData wineData = wineDataList.get(i);
            wineDataArray[i] = new Object[] { wineData.variety, wineData.content, wineData.alcohol, wineData.brand, wineData.lote, wineData.year };
        }
        return wineDataArray;
    }

    @Test(dataProvider = "wineData")
    public void createWine(String variety, String content, String alcohol, String brand, String lote, String year) {
        page.goTo("http://localhost:3000/");
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedUserPage  loggedUserPage = loginPage.loginUser("localtest","1597534682sS");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CreateWinePage createWine = loggedUserPage.createWine();
        createWine.uploadAWine(variety,content,alcohol,brand,lote,year);
    }
}



