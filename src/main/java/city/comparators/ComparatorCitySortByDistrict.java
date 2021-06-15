package city.comparators;

import city.City;

import java.util.Comparator;

public class ComparatorCitySortByDistrict implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        int result = o1.getDistrict().compareTo(o2.getDistrict());
        if (result == 0){
            return o1.getName().compareTo(o2.getName());
        }
        return result;
    }
}
