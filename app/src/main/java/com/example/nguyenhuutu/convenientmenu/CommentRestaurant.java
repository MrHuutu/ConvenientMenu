package com.example.nguyenhuutu.convenientmenu;

import java.util.HashMap;
import java.util.Map;

public class CommentRestaurant {
    /**
     * Properties
     */
    private String cmtRestid;
    private String cmtRestContent;
    private String cmtRestDate;
    private String restId;
    private String username;
    private Integer score;

    /**
     * Constructor Methods
     */
    public CommentRestaurant(String _cmtRestId, String _cmtRestContent, String _cmtRestDate, String _restId, String _username, Integer _score) {
        this.cmtRestid = _cmtRestId;
        this.cmtRestContent = _cmtRestContent;
        this.cmtRestDate = _cmtRestDate;
        this.restId = _restId;
        this.username = _username;
        this.score = _score;
    }

    /**
     * Getter methods
     */
    public String getCmtRestid() {
        return cmtRestid;
    }

    public String getCmtRestContent() {
        return cmtRestContent;
    }

    public String getCmtRestDate() {
        return cmtRestDate;
    }

    public String getRestId() {
        return restId;
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
     * createCommentRestId()
     *  - Create new id for CommentRestaurant
     * @param idNum
     * @return String
     */
    public static String createCommentRestId(Integer idNum) {
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
     * loadCommentRestaurant()
     *  - Load information of a CommentRestaurant
     * @param document
     * @return CommentRestaurant
     */
    public CommentDish loadCommentRestaurant(Map<String, Object> document) {
        String _cmtRestId = document.get("cmt_rest_id").toString();
        String _cmtRestContent = document.get("cmt_rest_content").toString();
        String _cmtRestDate = document.get("cmt_rest_date").toString();
        String _restId = document.get("rest_id").toString();
        String _username = document.get("username").toString();
        Integer _score = ((Number)document.get("score")).intValue();

        return new CommentDish(_cmtRestId, _cmtRestContent, _cmtRestDate, _restId, _username, _score);
    }

    /**
     * createCommentRestaurantData()
     *  -   Create CommentRestaurant's data for query
     * @param _cmtRestId
     * @param _cmtRestContent
     * @param _cmtRestDate
     * @param _restId
     * @param _username
     * @param _score
     * @return
     */
    public static Map<String, Object> createCommentRestaurantData(String _cmtRestId, String _cmtRestContent, String _cmtRestDate, String _restId, String _username, Integer _score) {
        Map<String, Object> document = new HashMap<>();

        document.put("cmt_rest_id", _cmtRestId);
        document.put("cmt_rest_content", _cmtRestContent);
        document.put("cmt_rest_date", _cmtRestDate);
        document.put("rest_id", _restId);
        document.put("username", _username);
        document.put("score", _score);

        return document;
    }
}
