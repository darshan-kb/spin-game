package com.spin.game.serviceclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
@Getter
@Setter
@Component
public class ValueMap {

    //List.of("single","vSplit","row","hSplit","corner","zero","half","dozen","mis","column");
    private HashMap<String, int[]> valueMap;
    public ValueMap(){

        valueMap = new HashMap<>();
        initializeValueMap();
    }

    public void initializeValueMap(){
        this.valueMap.put("single", new int[37]);
        this.valueMap.put("vSplit", new int[24]);
        this.valueMap.put("row", new int[3]);
        this.valueMap.put("hSplit", new int[33]);
        this.valueMap.put("corner", new int[22]);
        this.valueMap.put("zero", new int[1]);
        this.valueMap.put("half", new int[2]);
        this.valueMap.put("dozen", new int[3]);
        this.valueMap.put("mis", new int[4]);
        this.valueMap.put("column", new int[12]);
    }

    public void setValue(String setValueName, int index, int value){
        int[] valueArray = valueMap.get(setValueName);
        valueArray[index] = value;
        valueMap.put(setValueName,valueArray);
    }

    public int getValue(String setValueName,int index){
        return valueMap.get(setValueName)[index];
    }

    public int[] getBetList(String betName){
        return valueMap.get(betName);
    }

    public void addValueToIndex(String setValueName, int index, int value){
        int finalValue = getValue(setValueName,index) + value;
        setValue(setValueName,index,finalValue);
    }

    @Override
    public String toString() {
        return "ValueMap{" +
                "valueMap=" + valueMap +
                '}';
    }
}
