package com.spin.game.service;

import com.spin.game.repository.BetCategoryRepository;
import com.spin.game.repository.BetValuesMapRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StaticDBValuesService {

    private BetValuesMapRepository betValuesMapRepo;
    private BetCategoryRepository betCategoryRepo;
    @Cacheable("betElementsCache")
    public List<Integer> getElements(String betName, int betIndex){
        System.out.println(betName+" "+betIndex);
        String betValues = betValuesMapRepo.getElements(betName, betIndex).orElseThrow(() -> new IllegalStateException("bet is not correct"));
        return Arrays.stream(betValues.split(",")).map((s) -> Integer.parseInt(s)).collect(Collectors.toList());
    }
    @Cacheable("betPayout")
    public double getXTimes(String betName){
        System.out.println("betName : "+betName);
        return betCategoryRepo.getBetCatgoryByBetName(betName).getBetPayout();
    }
}
