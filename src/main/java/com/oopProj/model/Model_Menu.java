package com.oopProj.model;

public class Model_Menu {


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
     * @return the type
     */
    public MenuType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu(String name, MenuType type) {
        this.name = name;
        this.type = type;
    }
    public Model_Menu() {
    }
    
    private String name;
    private MenuType type;
    

    public static enum MenuType{
        TITLE, MENU, EMPTY
    }
    
}
