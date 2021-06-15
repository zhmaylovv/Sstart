package city.comparators;

import city.City;

import java.util.Comparator;

public class ComparatorCityNameSort implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
    }
}
