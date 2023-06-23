package TaskOne;

final class Award {

    private String name;
    private int year;

    Award(String name, int year) {
        this.name = name;
        this.year = year;
    }

    int getYear() {
        return this.year;
    }

    String getName() {
        return this.name;
    }

}