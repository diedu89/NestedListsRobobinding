package sv.diedu89.nestedmodels;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mido on 16/04/15.
 */
@PresentationModel
public class MainPresentationModel implements HasPresentationModelChangeSupport{
    private PresentationModelChangeSupport changeSupport;
    List<Item> items = new ArrayList<>();
    List<Item> items2 = new ArrayList<>();

    @ItemPresentationModel(value = MyItemPresentationModel.class, factoryMethod = "createItem")
    public List<Item> getItems(){
        return items;
    }

/*    @ItemPresentationModel(value = MyItemPresentationModel.class, factoryMethod = "createItem")
    public List<Item> getItems2(){
        return items2;
    }*/

    public MyItemPresentationModel createItem(){
        return new MyItemPresentationModel(changeSupport);
    }

    public void addItem(){
        items.add(new Item());
        changeSupport.firePropertyChange("items");
    }

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        if(changeSupport==null) changeSupport = new PresentationModelChangeSupport(this);
        return changeSupport;
    }
}
