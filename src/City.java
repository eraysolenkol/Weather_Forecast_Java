import java.util.LinkedHashMap;

public class City {
    private String name;
    private int currentCTemp;
    private LinkedHashMap<String,Integer> cTempsByDays;

    public City(String name) {
        this.name = name;
        this.cTempsByDays = new LinkedHashMap<>();
    }

    public City() {
        this.name = "Unknown";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentCTemp() {
        return currentCTemp;
    }

    public void setCurrentCTemp(int currentCTemp) {
        this.currentCTemp = currentCTemp;
    }

    public LinkedHashMap<String, Integer> getcTempsByDays() {
        return cTempsByDays;
    }

    public void setcTempsByDays(LinkedHashMap<String, Integer> cTempsByDays) {
        this.cTempsByDays = cTempsByDays;
    }
    
    
}
