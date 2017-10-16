package com.moderate.ch16;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LRUCacheTest {

    private LRUCache cache = new LRUCache();



    @Test
    public void testDish(){
        String[][] input = new String[][]{{"Pasta","Tomato Sauce","Onions","Garlic"},
 {"Chicken Curry","Chicken","Curry Sauce"},
 {"Fried Rice","Rice","Onions","Nuts"},
 {"Salad","Spinach","Nuts"},
 {"Sandwich","Cheese","Bread"},
 {"Quesadilla","Chicken","Cheese"}};
        String[][] result = groupingDishes(input);
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println(groupingDishes(input));
    }

    String[][] groupingDishes(String[][] dishes) {
        Map<String, List<String>> dishMap = new HashMap<>();
        for(int i = 0; i < dishes.length; i++){
            String dish = dishes[i][0];
            List<String> ingredientDishList = null;
            for(int j = 1; j < dishes[i].length; j++){
                if(!dishMap.containsKey(dishes[i][j])){
                    dishMap.put(dishes[i][j], new ArrayList<String>());
                }
                dishMap.get(dishes[i][j]).add(dish);
            }
        }
        List<String[]> result = new ArrayList<>();
        Object[] keys = dishMap.keySet().toArray();
        Arrays.sort(keys);
        for(int i = 0; i < keys.length; i++){
            String[] ingredientArray = combineIngredientsList((String)keys[i], dishMap.get(keys[i]).toArray(new String[0]));
            if(ingredientArray != null){
                result.add(ingredientArray);
            }
        }
        return result.toArray(new String[0][0]);
    }

    String[] combineIngredientsList(String ingredient, String[] dishes){
        if(dishes.length <= 1){
            return null;
        }
        Arrays.sort(dishes);
        String[] ingredients = new String[dishes.length + 1];
        ingredients[0] = ingredient;
        for(int i = 0; i < dishes.length; i++){
            ingredients[i+1] = dishes[i];
        }
        return ingredients;
    }




    @Test
    public void test(){
        cache.put("one", "1");
        cache.put("two", "2");
        cache.put("three", "3");
        cache.printContents();
        cache.get("one");
        cache.printContents();
        cache.put("four","4");
        cache.printContents();
        cache.get("one");
        cache.printContents();
    }

}
