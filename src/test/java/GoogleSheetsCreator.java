import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class GoogleSheetsCreator {
    public static void main(String[] args) {
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Website Elements");
            String[][] data = {
                    {"Кнопка входу у власний кабінет", "//button[contains(text(),'Увійдіть в особистий кабінет')]", "button.button--navy.button--small.main-auth__button"},
                    {"Кнопка реестраціі", "//button[@class='button button--link side-menu__auth-button']", "//button[contains(@class, 'button--link') and contains(@class, 'side-menu__auth-button')]"},
                    {"Каталог товарів", "//button[@id=\"fat-menu\" and contains(@class, \"button--with-icon\")]", "button#fat-menu.button--with-icon"},
                    {"Кнопка Про нас", "//a[@class=\"ng-tns-c1400081795-3\" and @href=\"https://rozetka.com.ua/ua/pages/about/\"]", "a.ng-tns-c1400081795-3[href=\"https://rozetka.com.ua/ua/pages/about/\"]"},
                    {"Контакти", "//a[@class=\"ng-tns-c1400081795-3\" and @href=\"https://rozetka.com.ua/ua/contacts/\"]", "a.ng-tns-c1400081795-3[href=\"https://rozetka.com.ua/ua/contacts/\"]"},
                    {"Я шукаю", "//input[@class=\"search-form__input ng-untouched ng-pristine ng-valid\" and @type=\"text\" and @name=\"search\" and @formcontrolname=\"text\" and @placeholder=\"Я шукаю...\"]", "input.search-form__input[type=\"text\"][name=\"search\"][formcontrolname=\"text\"][placeholder=\"Я шукаю...\"]"},
                    {"Знайти", "//button[contains(@class, 'button_color_green') and contains(@class, 'button_size_medium') and contains(@class, 'search-form__submit')]", "button.button.button_color_green.button_size_medium.search-form__submit"},
                    {"Корзина", "//button[@type=\"button\" and @class=\"header__button ng-star-inserted\"]", "button.header__button.ng-star-inserted[type=\"button\"]"},
                    {"Улюбленне", "//svg[@_ngcontent-rz-client-c576401443 and @aria-hidden=\"true\"]", "svg[_ngcontent-rz-client-c576401443][aria-hidden=\"true\"]"},
                    {"Завантажити з Гугл плей", "//img[@_ngcontent-rz-client-c3450194174 and @loading=\"lazy\" and @alt=\"Google Play\" and @src=\"https://xl-static.rozetka.com.ua/assets/img/design/button-google-play-ua.svg\"]", "img[_ngcontent-rz-client-c3450194174][loading=\"lazy\"][alt=\"Google Play\"][src=\"https://xl-static.rozetka.com.ua/assets/img/design/button-google-play-ua.svg\"]"},
                    {"Завантажити з Апп стор", "//img[@_ngcontent-rz-client-c3450194174 and @loading=\"lazy\" and @alt=\"AppStore\" and @src=\"https://xl-static.rozetka.com.ua/assets/img/design/button-appstore-ua.svg\"]", "img[_ngcontent-rz-client-c3450194174][loading=\"lazy\"][alt=\"AppStore\"][src=\"https://xl-static.rozetka.com.ua/assets/img/design/button-appstore-ua.svg\"]"},
                    {"Місто", "//p[@class=\"side-menu__switch-label ng-tns-c1370900134-1\"]", "p.side-menu__switch-label.ng-tns-c1370900134-1"},
                    {"Мова", "//p[@class=\"side-menu__switch-label ng-tns-c1370900134-1\"]", "p.side-menu__switch-label.ng-tns-c1370900134-1"},
                    {"Довідковий центр", "//a[@class=\"button button--large side-menu__button ng-tns-c1370900134-1 ng-star-inserted\" and @href=\"https://help.rozetka.com.ua/\"]", "a.button.button--large.side-menu__button.ng-tns-c1370900134-1.ng-star-inserted[href=\"https://help.rozetka.com.ua/\"]"},
                    {"Сервісний Центр", "//a[@class=\"ng-tns-c1400081795-2\" and @href=\"https://rozetka.com.ua/ua/service-centers/\"]", "a.ng-tns-c1400081795-2[href=\"https://rozetka.com.ua/ua/service-centers/\"]"}
            };
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < data[0].length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(data[0][i]);
            }
            for (int i = 1; i < data.length; i++) {
                Row row = sheet.createRow(i);
                for (int j = 0; j < data[i].length; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(data[i][j]);
                }
            }
            try (FileOutputStream fileOut = new FileOutputStream("WebsiteElements.xlsx")) {
                workbook.write(fileOut);
            }
            workbook.close();
            System.out.println("Google Sheets created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
