package city;

/**
 * Класс City реализует обьект Город для справочника городов.
 */
public class City {
    private String name;
    private String region;
    private String district;
    private Integer population;
    private Integer foundtion;

    public City(String name, String region, String district, Integer population, Integer foundtion) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundtion = foundtion;
    }
    public City() {}

    @Override
    public int hashCode() {
        return getPopulation().hashCode() + getFoundtion().hashCode() +
                getRegion().hashCode() + getDistrict().hashCode() + getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        City cityObj = (City) obj;
        return getName().equals(cityObj.getName()) &&
                getRegion().equals(cityObj.getRegion()) &&
                getDistrict().equals(cityObj.getDistrict()) &&
                getPopulation().equals(cityObj.getPopulation()) &&
                getFoundtion().equals(cityObj.getFoundtion());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public void setFoundtion(Integer foundtion) {
        this.foundtion = foundtion;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public Integer getPopulation() {
        return population;
    }

    public Integer getFoundtion() {
        return foundtion;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundtion=" + foundtion +
                '}';
    }
}
