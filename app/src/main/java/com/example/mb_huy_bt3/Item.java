package com.example.mb_huy_bt3;

public class Item {
    private String name;
    private String description;
    private int iconRes;

    public Item(String name, String description, int iconRes) {
        this.name = name;
        this.description = description;
        this.iconRes = iconRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }
}
