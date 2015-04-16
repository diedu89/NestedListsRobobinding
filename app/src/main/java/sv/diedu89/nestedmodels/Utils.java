package sv.diedu89.nestedmodels;

/**
 * Created by mido on 16/04/15.
 */
public class Utils {
    public static int getIntFromString(String str){
        try{
            return Integer.parseInt(str);
        }catch(NumberFormatException e){
            return 0;
        }
    }

    public static float getFloatFromString(String str){
        try{
            return Float.parseFloat(str);
        }catch (Exception e){
            return 0;
        }
    }

}
