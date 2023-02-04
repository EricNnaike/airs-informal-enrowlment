package com.app.AIRS.serviceImpl;

import com.app.AIRS.repository.TinRepository;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Data
@Service
public class TinGenerationService {

    @Autowired
    private TinRepository tinRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());


    public static List<Integer> getStreamOfRandomInts(int num) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        random.ints(num).sorted().forEach((number) -> {
            randomNumbers.add(Math.abs(number));
        });
        return randomNumbers;
    }

    public String generateNewTinNumber() {
        List<Integer> randomNumbers = TinGenerationService.getStreamOfRandomInts(5);
        int i = 0;
        while (i < randomNumbers.size()) {
            String tinNumber = Integer.toString(randomNumbers.get(i));
            if (!getTinRepository().existsByTinNumber(tinNumber)) {
                return tinNumber;
            }
            i++;
        }
        return generateNewTinNumber();
    }


}
