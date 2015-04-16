package sv.diedu89.nestedmodels;

import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

/**
 * Created by mido on 16/04/15.
 */

public class SubItemPresentationModel implements ItemPresentationModel<SubItem>, HasPresentationModelChangeSupport{
    private SubItem subItem;
    private Item parent;
    private PresentationModelChangeSupport changeSupport;

    public SubItemPresentationModel(Item parentItem){
        parent = parentItem;
    }

    @Override
    public void updateData(SubItem subItem, ItemContext itemContext) {
        this.subItem = subItem;
    }

    public String getFoostring() {
        return subItem.getFoostring();
    }

    public void setFoostring(String foostring) {
        subItem.setFoostring(foostring);
    }

    public String getFoostring2() {
        return subItem.getFoostring2();
    }

    public void setFoostring2(String foostring2) {
        subItem.setFoostring2(foostring2);
    }

    public String getFooint() {
        return String.valueOf(subItem.getFooint());
    }

    public void setFooint(String fooint) {
        subItem.setFooint(Utils.getIntFromString(fooint));
        changeSupport.firePropertyChange("foofloat2");
    }

    public String getFoofloat() {
        return String.valueOf(subItem.getFoofloat());
    }

    public void setFoofloat(String foofloat) {
        subItem.setFoofloat(Utils.getFloatFromString(foofloat));
        changeSupport.firePropertyChange("foofloat2");
    }

    public String getFoofloat2() {
        if(parent.getFooint() == 0)
            subItem.setFoofloat2(0f);
        else
            subItem.setFoofloat2((subItem.getFooint() * subItem.getFoofloat()) / parent.getFooint());

        return String.valueOf(subItem.getFoofloat2());
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        if(changeSupport == null) changeSupport = new PresentationModelChangeSupport(this);
        return changeSupport;
    }
}
