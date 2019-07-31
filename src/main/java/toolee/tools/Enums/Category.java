package toolee.tools.Enums;

public enum Category {
    HomeImprovement("Home Improvement"),
    HandTools("Hand Tools"),
    PowerTools("Power Tools"),
    Hardware("Hardware"),
    Accessories("Accessories"),
    FloorAndSurfaceCare("Floor and Surface"),
    MeasuringAndMarking("Measuring and Marking"),
    Plumbing("Plumbing"),
    LawnAndGarden("Lawn and Garden"),
    Miscellaneous("Miscellaneous");

    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
    }



    //Reference: https://stackoverflow.com/questions/8389150/java-enum-elements-with-spaces