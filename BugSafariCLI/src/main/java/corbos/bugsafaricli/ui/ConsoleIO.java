package corbos.bugsafaricli.ui;

public interface ConsoleIO {

    void print(String message);

    String readString(String prompt);

    String readRequiredString(String prompt);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);
}
