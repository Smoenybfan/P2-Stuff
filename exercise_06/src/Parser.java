/**
 * Created by Simon on 16.04.2016.
 */

import java.io.*;
import java.util.Stack;

public class Parser {

    char[][] program;
    String dir;

    public char[][] parse(String dir) throws Exception{
        try {
            assert boxesBalanced(program);
            assert onlyOnePlayer(program);
            assert isSurroundedByWall(program);

        } catch(Exception e) {
            System.out.println("Not a valid program!");
        }

        return program;
    }

    private void getChar() throws Exception {
        FileReader fr = new FileReader(dir);
        BufferedReader br = new BufferedReader(fr);

        char[] firstLine = br.readLine().toCharArray();
        assert (Character.isDigit(firstLine[0]) && firstLine[1]==' ' && Character.isDigit(firstLine[2]));

        for (int i=0;i<firstLine[2];i++) {
            program[i] = br.readLine().toCharArray();
        }

    }

    public Parser(String dir) throws Exception {
        assert dir!=null;
        assert (new File(dir).exists());

        this.dir=dir;
    }

    public boolean boxesBalanced(char[][] parse) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < program.length; i++) {
            for (int z = 0; z < program[i].length; z++) {
                if (program[i][z] == 'B') {
                    stack.push('B');
                }
                if (program[i][z] == 'G') {
                    stack.pop();
                }
            }
        }
        if(stack.empty()) {
            return true;
        }
        else {
            return false;

        }
    }


    public boolean onlyOnePlayer(char[][] parse){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < program.length; i++) {
            for (int z = 0; z < program[i].length; z++) {
                if (program[i][z] == 'P') {
                    stack.push('P');
                }
            }
        }
        if(stack.size()!=1) {
            return false;
        }
        return true;
    }

    public boolean isSurroundedByWall(char[][] board) {
        for (int i = 0; i < program.length; i++) {
            if (program[0][i] != '#')
                return false;
            if (program[program[i].length - 1][i] != '#')
                return false;
        }
        for (int i = 0; i < program[0].length; i++) {
            if (program[i][0] != '#')
                return false;
            if (program[i][program.length - 1] != '#')
                return false;
        }
        return true;
    }


    }

