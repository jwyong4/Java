import java.util.*;

public class NewChickenRecipe {
    public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // TODO:
        ArrayList<Integer[]> result = new ArrayList<>();
        ArrayList<Integer> stuffList = new ArrayList<>();
        for(int i = 0 ; i < stuffArr.length; i++ ) {
            int mod = 0;
            int cnt = 0;
            int curStuff = stuffArr[i];
            while (curStuff > 0) {
                mod = curStuff % 10;
                if (mod == 0)
                    cnt++;
                curStuff /= 10;
            }
            if (cnt < 3)
                stuffList.add(stuffArr[i]);
        }
        if(stuffList.size() == 0 || stuffList.size() < choiceNum) return null;

        Collections.sort(stuffList);
        permutation(choiceNum, stuffList, new ArrayList<Integer>(), result);

        return result;
    }

    public static void permutation(int choiceNum, ArrayList<Integer> stuffList, ArrayList<Integer> beforeRecipe, ArrayList<Integer[]> result){
        if(choiceNum == 0){
            result.add(beforeRecipe.toArray(new Integer[0]));
            return;
        }

        for(int i = 0; i < stuffList.size(); i++){
            Integer cur = stuffList.get(i);
            ArrayList<Integer> recipe = new ArrayList<>(beforeRecipe);
            if(!recipe.contains(cur)) {
                recipe.add(cur);
                permutation(choiceNum - 1, stuffList, recipe, result);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> output1 = newChickenRecipe(new int[]{1, 10, 1100, 1111}, 2);
        System.out.println(output1);
    }
}