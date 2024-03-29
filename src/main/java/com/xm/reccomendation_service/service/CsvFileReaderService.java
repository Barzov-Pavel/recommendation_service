package com.xm.reccomendation_service.service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.xm.reccomendation_service.dto.CryptoCurrencyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for reading data from a CSV file and returning a list of {@link CryptoCurrencyDto} objects.
 */
@Service
public class CsvFileReaderService implements Readable {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvFileReaderService.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CryptoCurrencyDto> read(String dataPath) {
        List<CryptoCurrencyDto> cryptoCurrencyDtos = Collections.emptyList();

        try {
            cryptoCurrencyDtos = new CsvToBeanBuilder<CryptoCurrencyDto>(
                    new FileReader(dataPath))
                    .withType(CryptoCurrencyDto.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            LOGGER.error("Error reading data by path: {} \nReason:\n {}",
                    dataPath, e.getMessage());
        }
        return cryptoCurrencyDtos;
    }
}
