package com.spin.game.service;

import com.spin.game.serviceclass.ValueMap;

import java.util.List;

public interface CalculateResultService {
    public int getCurrentGameResult(long id);
    public int getCurrentGameResultByValueMap(long id);
    public List<Integer> getElements(String betName, int Index);
}
