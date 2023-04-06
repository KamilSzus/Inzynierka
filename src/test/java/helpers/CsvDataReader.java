package helpers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataReader {

    public List<List<String>> readDataFromCSV(String path) throws IOException {

        FileReader fileReader = new FileReader(path);
        CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter('|').withHeader().parse(fileReader);

        List<List<String>> data = new ArrayList<>();
        for (CSVRecord record : csvParser) {
            String name = record.get("productName");
            String description = record.get("productDescription");
            String price = record.get("productPrice");

            List<String> row = new ArrayList<>();
            row.add(name);
            row.add(description);
            row.add(price);

            data.add(row);
        }

        fileReader.close();
        csvParser.close();

        return data;
    }


}
