package city;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import city.comparators.ComparatorCitySortByDistrict;
import city.comparators.ComparatorCityNameSort;

/**
 * Класс Main обеспечивает загрузку списка городов, предоставляет кользователю консольное меню для выбора
 * вариантов сортировки и вывод определенных данныхю
 */
public class Main {
    public static final String FILE_PATH = "src/main/resources/city.txt";

    public static void main(String[] args) throws IOException {
        List<City> citiesList = new ArrayList<>(loadCityFromCsv(FILE_PATH));
        Scanner input = new Scanner(System.in);
        printMenu(FILE_PATH);

        while (true) {
            String choice = input.nextLine();
            if (choice.equals("0")){
                    break;
            }else if (choice.equals("1")){
                for (City city : citiesList) {
                    System.out.println(city);
                }
            }else if (choice.equals("2")) {
                for (City city : sortByName(citiesList)) {
                    System.out.println(city);
                }
            }else if (choice.equals("3")) {
                for (City city : sortByDistrict(citiesList)) {
                    System.out.println(city);
                }
            }else if (choice.equals("4")) {
                Integer[] indexAndPopulation = maxPopulation(citiesList);
                System.out.println("[" + indexAndPopulation[0] + "] = " + indexAndPopulation[1]);

            }else if (choice.equals("5")) {
                Map<String, Long> counter = new HashMap<>(countCityByRegion(citiesList));
                for (String key : counter.keySet()) {
                    System.out.println(key + " - " + counter.get(key));
                }
            }else {
                System.out.println("Не верный формат ввода, повторите попытку.");
            }
            }
        }

    /**
     *Метод printMenu выводит в консоль текст пользовательского меню
      * @param filePath имя файла загруженного для обработки.
     */
    public static void printMenu(String filePath){
        System.out.println("Загружен файл " + filePath + '\n' +
                "Введите номер действия и нажмите ввод:" + '\n' +
                "1 - Вывести список городов" + '\n' +
                "2 - Вывесли список отсортированный по названию города" + '\n' +
                "3 - Вывести список отсортированный по федеральному кругу" + '\n' +
                "4 - Вывести элемент массива с максимальным населением" + '\n' +
                "5 - Вывести колличество городов по регионам"+ '\n' +
                "0 - Выход"
        );
    }

    /**
     *  Метод sortByName сортирует список городов по полю "name"
     * @param citiesList список обьектов City для сортировки
     * @return сортированный список обьектов City
     */
    public static List<City> sortByName(List<City> citiesList) {
        Comparator<City> comparatorCityNameSort = new ComparatorCityNameSort();
        citiesList.sort(comparatorCityNameSort);
        return citiesList;
    }

    /**
     *  Метод sortByDistrict сортирует список городов по полю "district"
     * @param citiesList список обьектов City для сортировки
     * @return сортированный список обьектов City
     */
    public static List<City> sortByDistrict(List<City> citiesList) {
        Comparator<City> comparatorCitySortByDistrict = new ComparatorCitySortByDistrict();
        citiesList.sort(comparatorCitySortByDistrict);
        return citiesList;
    }
    /**
     *  Метод maxPopulation ищет максимальное значение поля population в массиве созданном из списка City
     * @param citiesList список обьектов City для создания массива и поиска
     * @return Массив из двух Integer index и значение population.
     */
    public static Integer[] maxPopulation(List<City> citiesList) {
        Integer[] indexAndPopulation = new Integer[2];
        indexAndPopulation[0] = 0;
        indexAndPopulation[1] = 0;
        City[] citiesArray = citiesList.toArray(City[]::new);
        for (int i = 0; i < citiesArray.length; i++) {
            if (citiesArray[i].getPopulation() > indexAndPopulation[1]) {
                indexAndPopulation[1] = citiesArray[i].getPopulation();
                indexAndPopulation[0] = i;
            }
        }
        return indexAndPopulation;
    }

    /**
     * Метод countCityByRegion подсчитывает количество городов по регионам
     * @param citiesList Список обьектов City для поиска и подсчета
     * @return Map {region : количество городов}
     */
    public static Map<String, Long> countCityByRegion(List<City> citiesList) {
        return citiesList.stream().collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
    }

    /**
     * Метод loadCityFromCsv считывает файл с городами и формирует список обьектов City
     * формат файла: id;name;region;district;population;foundation
     * @param path Путь файла для загрузки
     * @return список обьектов City
     * @throws IOException Выбрасивает исключение при не верном формате файла
     */
    public static List<City> loadCityFromCsv(String path) throws IOException {
        String line;
        Scanner scanner;
        List<City> cityList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));

        while ((line = reader.readLine()) != null) {
            City city = new City();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            int index = 0;
            while (scanner.hasNext()) {
                String scannerData = scanner.next();
                if (index == 1) {
                    city.setName(scannerData);
                } else if (index == 2) {
                    city.setRegion(scannerData);
                } else if (index == 3) {
                    city.setDistrict(scannerData);
                } else if (index == 4) {
                    city.setPopulation(Integer.parseInt(scannerData));
                } else if (index == 5) {
                    city.setFoundtion(Integer.parseInt(scannerData));
                } else if (index > 5) throw new IOException("City csv file wrong format");
                index++;
            }
            cityList.add(city);
        }
        reader.close();
        return cityList;
    }
}
