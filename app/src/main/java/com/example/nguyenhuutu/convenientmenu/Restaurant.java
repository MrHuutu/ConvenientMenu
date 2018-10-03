package com.example.nguyenhuutu.convenientmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    /**
     * Properties
     */

    private String restId;
    private String restPassword;
    private String restName;
    private List<String> restAddresses;
    private String restDescription;
    private List<String> restMoreImages;
    private String restHomeImage;

    /**
     * Methods List
     */

    public Restaurant(){
        this.restId = "";
        this.restPassword = "";
        this.restName = "";
        this.restAddresses = new ArrayList<>();
        this.restDescription = "";
        this.restHomeImage = "";
        this.restMoreImages = new ArrayList<>();
    }

    public Restaurant(String _restId, String _restPassword, String _restName, String _restDescription, List<String> _restAddresses, String _restHomeImage, List<String> _restMoreImages) {

        this.restId = _restId;
        this.restPassword = _restPassword;
        this.restName = _restName;
        this.restAddresses = _restAddresses;
        this.restDescription = _restDescription;
        this.restHomeImage = _restHomeImage;
        this.restMoreImages = _restMoreImages;
    }

    /**
     * Getter methods for properties
     */
    protected String getRestId() {
        return this.restId;
    }

    protected String getRestPassword() {
        return this.restPassword;
    }

    protected String getRestName() {
        return this.restName;
    }

    protected List<String> getRestAddresses() {
        return this.restAddresses;
    }

    protected String getRestDescription() {
        return this.restDescription;
    }

    protected String getRestHomeImage() {
        return this.restHomeImage;
    }

    protected List<String> getRestMoreImages() {
        return this.restMoreImages;
    }

    /**
     * createRestId()
     *  - Create a new id for restaurant
     * @return String
     */
    public static String createRestId(Integer idNumber) {
        String newId;

        if (idNumber < 10) {
            newId = String.format("REST00%d", idNumber);
        }
        else if (idNumber < 100) {
            newId = String.format("REST0%d", idNumber);
        }
        else {
            newId = String.format("REST%d", idNumber);
        }

        return newId;
    }

    /**
     * loadRestaurant()
     *  - Load data of a restaurant
     * @return Restaurant
     */
    public static Restaurant loadRestaurant(Map<String, Object> document) {
        String _id = (String)document.get("rest_id");
        String _password= (String)document.get("rest_password");
        String _name = (String)document.get("rest_name");
        String _description = (String)document.get("rest_description");
        List<String> _addresses = (ArrayList)document.get("rest_addresses");
        String _homeImage = (String)document.get("rest_home_image");
        List<String> _moreImages = (ArrayList)document.get("rest_more_images");

        return new Restaurant(_id, _password, _name, _description, _addresses, _homeImage, _moreImages);
    }

    /**
     * createRestaurantData()
     *  - Create restaurant's data for query
     * @param _restId
     * @param _restPassword
     * @param _restName
     * @param _restDescription
     * @param _restAddresses
     * @param _restHomeImage
     * @param _restMoreImages
     * @return Map<String, Object>
     */
    public static Map<String, Object> createRestaurantData(String _restId, String _restPassword, String _restName, String _restDescription, List<String> _restAddresses, String _restHomeImage, List<String> _restMoreImages) {
        Map<String, Object> restData = new HashMap<>(); // Save data of dish

        restData.put("rest_id", _restId);
        restData.put("rest_password", _restPassword);
        restData.put("rest_name", _restName);
        restData.put("rest_description", _restDescription);
        restData.put("rest_addresses", _restAddresses);
        restData.put("rest_home_image", _restHomeImage);
        restData.put("rest_more_images", _restMoreImages);

        return restData;
    }
}
