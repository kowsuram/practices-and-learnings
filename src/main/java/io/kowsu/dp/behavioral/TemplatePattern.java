package io.kowsu.dp.behavioral;

public class TemplatePattern {

    public static void main(String[] args) {
        FileProcessorTemplate excelTemplate = new ExcelFileProcessor("data.xlsx");
        excelTemplate.process();
        FileProcessorTemplate jsonTemplate = new JsonFileProcessor("data.json");
        jsonTemplate.process();
    }
}

abstract class FileProcessorTemplate {
    private String fileName;
    public FileProcessorTemplate(String fileName) {
        this.fileName = fileName;
    }
    final void open() {
        System.out.printf("Opening the file %s \n", fileName);
    }
    abstract void parseHeader();
    abstract void processData();

    final void close() {
        System.out.printf("Closing the file %s \n", fileName);
    }

    void process() {
        open();
        parseHeader();
        processData();
        close();
    }
}

class JsonFileProcessor extends FileProcessorTemplate {
    private String fileName;
    public JsonFileProcessor(String fileName) {
        super(fileName);
        this.fileName = fileName;
    }

    @Override
    void parseHeader() {
        System.out.printf("parsing the json header in file: %s \n", this.fileName);
    }

    @Override
    void processData() {
        System.out.printf("parsing the json data in file: %s \n", this.fileName);
    }
}

class ExcelFileProcessor extends FileProcessorTemplate {

    private String fileName;
    public ExcelFileProcessor(String fileName) {
        super(fileName);
        this.fileName = fileName;
    }

    @Override
    void parseHeader() {
        System.out.printf("parsing the excel header in file: %s \n", this.fileName);
    }

    @Override
    void processData() {
        System.out.printf("parsing the excel data in file: %s \n", this.fileName);
    }
}