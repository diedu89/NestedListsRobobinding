package sv.diedu89.nestedmodels;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.itempresentationmodel.ItemContext;
import org.robobinding.itempresentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mido on 16/04/15.
 */
@PresentationModel
public class MyItemPresentationModel implements ItemPresentationModel<Item>, HasPresentationModelChangeSupport {
    private Item item;
    private List<SubItem> subitems = new ArrayList<SubItem>();
    private PresentationModelChangeSupport changeSupport;
    private PresentationModelChangeSupport parentChangeSupport;

    public MyItemPresentationModel(PresentationModelChangeSupport changeSupport){
        parentChangeSupport = changeSupport;
    }

    @Override
    public void updateData(Item item, ItemContext itemContext) {
        this.item = item;
        //itemContext.getItemView().getParent().requestLayout();
    }

    public String getFoostring() {
        return item.getFoostring();
    }

    public void setFoostring(String foostring) {
        item.setFoostring(foostring);
    }

    public String getFooint() {
        return String.valueOf(item.getFooint());
    }

    public void setFooint(String fooint) {
        item.setFooint(Utils.getIntFromString(fooint));
    }

    @org.robobinding.annotation.ItemPresentationModel(value = SubItemPresentationModel.class, factoryMethod = "createSubItem")
    public List<SubItem> getSubItems(){
        return subitems;
    }

    public SubItemPresentationModel createSubItem(){
        return new SubItemPresentationModel(item);
    }

    public void addSubItem(){
        subitems.add(new SubItem());
        changeSupport.firePropertyChange("subItems");
        parentChangeSupport.firePropertyChange("items");
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        if(changeSupport == null) changeSupport = new PresentationModelChangeSupport(this);
        return changeSupport;
    }
}
