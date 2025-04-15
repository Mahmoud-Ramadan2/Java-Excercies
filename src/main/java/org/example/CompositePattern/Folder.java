package org.example.CompositePattern;

import java.util.ArrayList;
import java.util.List;

// Composite: Can contain files or other folders
class Folder implements FileS  {
    private String name;
    private List<FileS> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileS component) {
        children.add(component);
    }


    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileS component : children) {
            component.showDetails();
        }
    }
}
