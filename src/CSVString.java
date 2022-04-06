public class CSVString {
    private final String first;
    private final String second;
    private final String third;
    private final String fullString;

    public CSVString(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fullString = first + ";" + second + ";" + third;
    }

    public String getFullString() {
        return fullString;
    }

    public String getThird() {
        return third;
    }

    public String getSecond() {
        return second;
    }

    public String getFirst() {
        return first;
    }
}
