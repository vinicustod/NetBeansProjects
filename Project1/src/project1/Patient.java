/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.util.Date;

/**
 *
 * @author lucasmarques
 */
public class Patient {

    private String name;
    private String id;
    private String address;
    private int height;
    private double weight;
    private Date birth;
    private Date firstVisit;
    private Date lastVisit;

    Patient(String name, String id, String address, int height, double weight, Date birth, Date firstVisit, Date lastVisit) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.height = height;
        this.weight = weight;
        this.birth = birth;
        this.firstVisit = firstVisit;
        this.lastVisit = lastVisit;
    }

    Patient() {
    }

    public int get_age() {
        Date now = new Date();
        int nowMonth = now.getMonth();
        int nowYear = now.getYear();
        int result = nowYear - birth.getYear();

        if (birth.getMonth() > nowMonth) {
            result--;
        } else if (birth.getMonth() == nowMonth) {
            int nowDay = now.getDate();

            if (birth.getDate() > nowDay) {
                result--;
            }
        }
        return result;
    }

    public int get_time_as_patient() {
        Date now = new Date();
        int nowMonth = now.getMonth();
        int nowYear = now.getYear();
        int result = nowYear - firstVisit.getYear();

        if (firstVisit.getMonth() > nowMonth) {
            result--;
        } else if (firstVisit.getMonth() == nowMonth) {
            int nowDay = now.getDate();

            if (firstVisit.getDay() > nowDay) {
                result--;
            }
        }
        return result;
    }

    public int get_time_since_last_visit() {
        Date now = new Date();
        int nowMonth = now.getMonth();
        int nowYear = now.getYear();
        int result = nowYear - lastVisit.getYear();

        if (lastVisit.getMonth() > nowMonth) {
            result--;
        } else if (lastVisit.getMonth() == nowMonth) {
            int nowDay = now.getDate();

            if (lastVisit.getDay() > nowDay) {
                result--;
            }
        }
        return result;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * @param birth the birth to set
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * @return the firstVisit
     */
    public Date getFirstVisit() {
        return firstVisit;
    }

    /**
     * @param firstVisit the firstVisit to set
     */
    public void setFirstVisit(Date firstVisit) {
        this.firstVisit = firstVisit;
    }

    /**
     * @return the lastVisit
     */
    public Date getLastVisit() {
        return lastVisit;
    }

    /**
     * @param lastVisit the lastVisit to set
     */
    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

}
