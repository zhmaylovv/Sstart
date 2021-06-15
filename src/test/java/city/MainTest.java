package city;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MainTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    public static City testCity1;
    public static City testCity2;
    public static City testCity3;

    @BeforeEach
    public void setUp() {
        testCity1 = new City("Новосибирск", "Новосибирская область", "Сибирский федеральный округ", 2000000, 1890);
        testCity2 = new City("Москва", "Московская область", "Центральный федеральный округ", 100500000, 1285);
        testCity3 = new City("Улан-Уде", "Республика бурятия", "Ямбирский федеральный округ", 400000, 1700);
    }


    @Test
    void printSortByName() throws IOException {
        List<City> cityList = new ArrayList<>();
        cityList.add(testCity2);
        cityList.add(testCity1);
        cityList.add(testCity3);
        List<City> testList = Main.sortByName(Main.loadCityFromCsv("src/test/resources/unsortedCitiesForTest.csv"));
        Assertions.assertEquals(cityList, testList);
    }

    @Test
    void printSortByDistrict() throws IOException {
        List<City> cityList = new ArrayList<>();
        cityList.add(testCity1);
        cityList.add(testCity2);
        cityList.add(testCity3);
        List<City> testList = Main.sortByDistrict(Main.loadCityFromCsv("src/test/resources/unsortedCitiesForTest.csv"));
        Assertions.assertEquals(cityList, testList);
    }

    @Test
    void printMaxPopulation() throws IOException {
        List<City> citiesList = new ArrayList<>(city.Main.loadCityFromCsv("src/test/resources/cities.csv"));
        Integer[] expectCase = new Integer[]{1,100500000};
        Assertions.assertArrayEquals(expectCase, Main.maxPopulation(citiesList));
    }

    @Test
    void printCountCityByRegion() throws IOException {
        Map<String, Long> expectedMap = new HashMap<>();
        expectedMap.put("Новосибирская область", 1L);
        expectedMap.put("Республика бурятия", 1L);
        expectedMap.put("Московская область", 1L);
        Assertions.assertEquals(expectedMap, Main.countCityByRegion(Main.loadCityFromCsv("src/test/resources/cities.csv")) );
    }

    @Test
    void checkResultCorrectFileLoad() throws IOException {
        List<City> cityList = new ArrayList<>();
        cityList.add(testCity1);
        cityList.add(testCity2);
        cityList.add(testCity3);
        List<City> testList = Main.loadCityFromCsv("src/test/resources/cities.csv");
        Assertions.assertEquals(cityList, testList);
    }

    @Test
    void passIfExceptionWhenFileLoad() {
        Assertions.assertThrows(IOException.class, () -> Main.loadCityFromCsv("src/test/resources/citiesCorruptedFile.csv"));
    }

    @Test
    void checkCorrectTextPrintMenu() {
        System.setOut(new PrintStream(outputStreamCaptor));
        Main.printMenu("src/main/resources/city.txt");
        Assertions.assertEquals("Загружен файл src/main/resources/city.txt\n" +
                "Введите номер действия и нажмите ввод:\n" +
                "1 - Вывести список городов\n" +
                "2 - Вывесли список отсортированный по названию города\n" +
                "3 - Вывести список отсортированный по федеральному кругу\n" +
                "4 - Вывести элемент массива с максимальным населением\n" +
                "5 - Вывести колличество городов по регионам\n" +
                "0 - Выход", outputStreamCaptor.toString().trim());
    }
}