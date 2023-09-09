package helpers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataReader {

    public List<List<String>> readDataFromCSV(String path, char delimiter, boolean hasHeader) throws IOException {
        List<List<String>> data = new ArrayList<>();

        try (FileReader fileReader = new FileReader(path);
             CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(delimiter)
                     .withHeader(String.valueOf(hasHeader))
                     .parse(fileReader)) {

            for (CSVRecord record : csvParser) {
                List<String> row = new ArrayList<>();
                for (int i = 0; i < record.size(); i++) {
                    row.add(record.get(i));
                }
                data.add(row);
            }
        }

        return data;
    }

}
