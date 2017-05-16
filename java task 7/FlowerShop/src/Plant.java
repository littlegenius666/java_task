import models.ShopModel;

import java.util.Date;

/**
 * Created by Yelyzaveta_Horbachen on 16.05.17.
 */
public abstract class Plant {
    private Date deliveryDate;
    private int shelfLife;
    private int length;
    private double price;
    private int freshness;

    public void checkFreshness() {
        Date currentDate=new Date();
        long difference=currentDate.getTime()-deliveryDate.getTime();
        difference/=(1000*60*60*24);
        double freshnessCoef=difference/shelfLife;
        if (freshnessCoef<0.2) {
            freshness=5;
        } else if (freshnessCoef<0.4) {
            freshness=4;
        } else if (freshnessCoef<0.6) {
            freshness=3;
        }
        else if (freshnessCoef<0.8) {
            freshness=2;
        }
        else if (freshnessCoef<1) {
            freshness=1;
        } else freshness=0;
    }

}
