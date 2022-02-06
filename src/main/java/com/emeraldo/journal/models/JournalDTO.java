package com.emeraldo.journal.models;

public class JournalDTO {
    private String title;
    private String description;

    JournalDTO(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription(){
        return description;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
