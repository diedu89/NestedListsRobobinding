package sv.diedu89.nestedmodels;

/**
 * Created by mido on 16/04/15.
 */
public class SubItem {

    private String foostring;
    private String foostring2;
    private int fooint;
    private float foofloat;
    private float foofloat2;

    public SubItem(){
        fooint =0;
        foofloat=0f;
        foofloat2=0f;
    }

    public String getFoostring() {
        return foostring;
    }

    public void setFoostring(String foostring) {
        this.foostring = foostring;
    }


    public String getFoostring2() {
        return foostring2;
    }

    public void setFoostring2(String foostring2) {
        this.foostring2 = foostring2;
    }


    public int getFooint() {
        return fooint;
    }

    public void setFooint(Integer fooint) {
        this.fooint = fooint;
    }


    public float getFoofloat() {
        return foofloat;
    }

    public void setFoofloat(float foofloat) {
        this.foofloat = foofloat;
    }


    public float getFoofloat2() {
        return foofloat2;
    }

    public void setFoofloat2(float foofloat2) {
        this.foofloat2 = foofloat2;
    }

}