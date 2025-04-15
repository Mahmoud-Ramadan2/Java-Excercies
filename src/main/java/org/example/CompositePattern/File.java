package org.example.CompositePattern;


// Leaf: Represents a file (cannot contain other elements)
class File implements FileS {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {

        System.out.println("File: " + name);
    }
}
