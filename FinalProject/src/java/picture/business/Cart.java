/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picture.business;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author viniciuscustodio
 */
public class Cart {

    private List<Picture> pictures = new ArrayList();
    private float total = 0;

    /**
     * @return the pictures
     */
    public int listSize() {
        if (pictures != null) {
            return pictures.size();
        }
        return 0;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void appendPicture(Picture e) {
        Iterator i = pictures.iterator();
        while (i.hasNext()) {
            Picture p = (Picture) i.next();
            if(p.getPictureId() == e.getPictureId())
                return;
        }
        this.pictures.add(e);
    }

    public void removePicture(Picture e) {
        this.pictures.remove(e);
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getTotalCurrencyFormat() {
        float total = getTotal();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(total);
    }

    public String convertTotalCurrencyFormat(float total) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(total);
    }

    public float getTotal() {
        float ftotal = 0;
        if (pictures != null) {
            Iterator i = pictures.iterator();
            while (i.hasNext()) {
                Picture p = (Picture) i.next();
                ftotal += p.getPrice();
            }
        }
        return ftotal;
    }

    public float getDiscount() {
        float discount = 0;
        if (pictures != null) {
            Iterator i = pictures.iterator();
            while (i.hasNext()) {
                Picture p = (Picture) i.next();
                discount += (p.getPrice() * p.getPercentage()) / 100;
            }
        }
        return discount;
    }

}
