package com.emag.model;

import com.emag.config.Constants;
import com.emag.config.ConstantsErrorMessages;
import com.emag.exceptions.AddressException;
public class Address {

    private Long id;
    private String receiverName;
    private String receiverPhone;
    private String city;
    private String street;
    private Integer floor;

    public Address() {
    }

    public Address(String receiverName, String receiverPhone, String city, String street, Integer floor) throws AddressException {
        setReceiverName(receiverName);
        setReceiverPhone(receiverPhone);
        setCity(city);
        setStreet(street);
        setFloor(floor);
    }

    public Address(Long id, String receiverName, String receiverPhone, String city, String street, Integer floor) throws AddressException {
        setId(id);
        setReceiverName(receiverName);
        setReceiverPhone(receiverPhone);
        setCity(city);
        setStreet(street);
        setFloor(floor);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws AddressException {

       if(city!=null && city.trim().length() >= Constants.MIN_CITY_NAME_LENGTH){
           this.city=city;
       }
       else throw new AddressException(ConstantsErrorMessages.INVALID_CITY_NAME);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) throws AddressException {
        if (id > -1) {
            this.id = id;
        } else {
            throw new AddressException(ConstantsErrorMessages.INVALID_ID_VALUE);
        }
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) throws AddressException {
        if (receiverName != null && receiverName.trim().length() > 0) {
            this.receiverName = receiverName;
        } else {
            throw new AddressException(ConstantsErrorMessages.INVALID_RECEIVER_NAME);
        }
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) throws AddressException {
        if (receiverPhone != null && receiverPhone.trim().length() == Constants.PHONE_NUMBER_LENGTH && receiverPhone.startsWith(Constants.PHONE_NUMBER_PREFIX)) {
            this.receiverPhone = receiverPhone;
        } else {
            throw new AddressException(ConstantsErrorMessages.INVALID_PHONE_NUMBER_VALUE);
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws AddressException {
        if (street != null && street.trim().length() > 0) {
            this.street = street;
        } else {
            throw new AddressException(ConstantsErrorMessages.INVALID_STREET_VALUE);
        }
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) throws AddressException {
        if (floor != null && floor >= 0) {
            this.floor = floor;
        } else {
            throw new AddressException(ConstantsErrorMessages.INVALID_FLOOR_VALUE);
        }
    }
}
