package com.example.nguyenhuutu.convenientmenu;

import java.util.HashMap;
import java.util.Map;

public class CommentDish {
    /**
     * Properties
     */
    private String cmtDishid;
    private String cmtDishContent;
    private String cmtDishDate;
    private String dishId;
    private String username;
    private Integer score;

    /**
     * Constructor Methods
     */
    public CommentDish(String _cmtDishId, String _cmtDishContent, String _cmtDishDate, String _dishId, String _username, Integer _score) {
        this.cmtDishid = _cmtDishId;
        this.cmtDishContent = _cmtDishContent;
        this.cmtDishDate = _cmtDishDate;
        this.dishId = _dishId;
        this.username = _username;
        this.score = _score;
    }

    /**
     * Getter methods
     */
    public String getCmtDishid() {
        return cmtDishid;
    }

    public String getCmtDishContent() {
        return cmtDishContent;
    }

    public String getCmtDishDate() {
        return cmtDishDate;
    }

    public String getDishId() {
        return dishId;
    }

    public String getUsername() {
        return username;
    }

    public Integer getScore() {
        return score;
    }

    /**
     * Other Methods
     */

    /**
     * createCommentDishId()
     *  - Create new id for comment dish
     * @param idNum
     * @return String
     */
    public static String createCommentDishId(Integer idNum) {
        String newId;

        if (idNum < 10) {
            newId = String.format("MENU0000%d", idNum);
        }
        else if (idNum < 100) {
            newId = String.format("MENU000%d", idNum);
        }
        else if (idNum < 1000) {
            newId = String.format("MENU00%d", idNum);
        }
        else if (idNum < 10000) {
            newId = String.format("MENU0%d", idNum);
        }
        else {
            newId = String.format("MENU%d", idNum);
        }

        return newId;
    }

    /**
     * loadCommentDish()
     *  - Load menu's information of a comment dish
     * @param document
     * @return CommentDish
     */
    public CommentDish loadCommentDish(Map<String, Object> document) {
        String _cmtDishId = document.get("cmt_dish_id").toString();
        String _cmtDishContent = document.get("cmt_dish_content").toString();
        String _cmtDishDate = document.get("cmt_dish_date").toString();
        String _dishId = document.get("dish_id").toString();
        String _username = document.get("username").toString();
        Integer _score = ((Number)document.get("score")).intValue();

        return new CommentDish(_cmtDishId, _cmtDishContent, _cmtDishDate, _dishId, _username, _score);
    }

    /**
     * createCommentDishData()
     *  -   Create CommentDish's data for query
     * @param _cmtDishId
     * @param _cmtDishContent
     * @param _cmtDishDate
     * @param _dishId
     * @param _username
     * @param _score
     * @return Map<String, Object>
     */
    public static Map<String, Object> createCommentDishData(String _cmtDishId, String _cmtDishContent, String _cmtDishDate, String _dishId, String _username, Integer _score) {
        Map<String, Object> document = new HashMap<>();

        document.put("cmt_dish_id", _cmtDishId);
        document.put("cmt_dish_content", _cmtDishContent);
        document.put("cmt_dish_date", _cmtDishDate);
        document.put("dish_id", _dishId);
        document.put("username", _username);
        document.put("score", _score);

        return document;
    }
}