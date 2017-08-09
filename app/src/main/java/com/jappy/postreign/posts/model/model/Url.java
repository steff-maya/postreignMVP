
package com.jappy.postreign.posts.model.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by jappy on 08-08-17.
 */

public class Url {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("matchLevel")
    @Expose
    private String matchLevel;
    @SerializedName("matchedWords")
    @Expose
    private List<String> matchedWords = null;
    @SerializedName("fullyHighlighted")
    @Expose
    private Boolean fullyHighlighted;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMatchLevel() {
        return matchLevel;
    }

    public void setMatchLevel(String matchLevel) {
        this.matchLevel = matchLevel;
    }

    public List<String> getMatchedWords() {
        return matchedWords;
    }

    public void setMatchedWords(List<String> matchedWords) {
        this.matchedWords = matchedWords;
    }

    public Boolean getFullyHighlighted() {
        return fullyHighlighted;
    }

    public void setFullyHighlighted(Boolean fullyHighlighted) {
        this.fullyHighlighted = fullyHighlighted;
    }

}
