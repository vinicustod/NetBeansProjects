/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picture.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author viniciuscustodio
 */
@Entity
public class Users implements Serializable{
  
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;
    private String Email;
    private String FirstName;
    private String LastName;
    private String UserName;
    private String Address;
    private String AddressNumber;
    private String City;
    private String State;
    private String ZipCode;
    private String Password;

    public Users(String Email, String FirstName, String LastName, String UserName, String Address, String City, String State, String ZipCode, String Password){
        this.userID = userID;
        this.Email = Email;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.ZipCode = ZipCode;
        this.Password = Password;
    }

    public Users() {
    }
    /**
     * @return the userID
     */
    public long getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(long userID) {
        this.userID = userID;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param UserName the UserName to set
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the AddressNumber
     */
    public String getAddressNumber() {
        return AddressNumber;
    }

    /**
     * @param AddressNumber the AddressNumber to set
     */
    public void setAddressNumber(String AddressNumber) {
        this.AddressNumber = AddressNumber;
    }

    /**
     * @return the City
     */
    public String getCity() {
        return City;
    }

    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     * @return the State
     */
    public String getState() {
        return State;
    }

    /**
     * @param State the State to set
     */
    public void setState(String State) {
        this.State = State;
    }

    /**
     * @return the ZipCode
     */
    public String getZipCode() {
        return ZipCode;
    }

    /**
     * @param ZipCode the ZipCode to set
     */
    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
