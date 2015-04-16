package sv.diedu89.nestedmodels;

/**
 * Created by mido on 16/04/15.
 */
public class Item {

    private String foostring;
    private Integer fooint;

    public Item(){
        fooint=0;
    }

    public String getFoostring() {
        return foostring;
    }

    public void setFoostring(String foostring) {
        this.foostring = foostring;
    }

    public Integer getFooint() {
        return fooint;
    }

    public void setFooint(Integer fooint) {
        this.fooint = fooint;
    }

}