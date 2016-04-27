package snakes;

/**
 * Created by smoen on 26.04.2016.
 */
public class MockedDie implements IDie{

    int[] possibleValues;
    int counter;

    public MockedDie(int[] possibleValues){
        assert possibleValues !=null;
        this.possibleValues=possibleValues;
        counter=0;
    }

    public int roll(){
        int rolled = possibleValues[counter];
        if(counter<possibleValues.length-1){
            counter++;
        }
        else{
            counter=0;
        }
        return rolled;
    }
}
