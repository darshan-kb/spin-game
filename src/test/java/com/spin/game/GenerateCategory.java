package com.spin.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateCategory {

    @Test
    public void generateTwoAdjacentCombinationCategories(){

        List<String> TwoValueCombination = new ArrayList<>();

        for(int i=1;i<=36;i++){
            TwoValueCombination.add(i+"");
        }

        for(int i=1;i<=33;i++){
            TwoValueCombination.add(i+"-"+(i+3));
            if(i%3!=0){
                TwoValueCombination.add(i+"-"+(i+1));
            }
        }
        generateThreeColumnCombination(TwoValueCombination);
    }

    @Test
    public void generateThreeColumnCombination(List<String> result){

        for(int i=0;i<11;i++){
            int t = (i*3)+1;
            result.add((t)+"-"+(t+1)+"-"+(t+3)+"-"+(t+4));
            t++;
            result.add((t)+"-"+(t+1)+"-"+(t+3)+"-"+(t+4));
        }
        for(int i=1;i<=12;i++){
            result.add(i+"lineOf3");
        }

        for(int i=1;i<=3;i++){
            result.add(i+"lineOf12");
        }

        for(int i=1;i<=3;i++){
            result.add(i+"dozen");
        }

        result.add("even");

        result.add("odd");

        result.add("red");

        result.add("black");

        result.stream().forEach(System.out::println);
        System.out.println(result.size());
    }
}
