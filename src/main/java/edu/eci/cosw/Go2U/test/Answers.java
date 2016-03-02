/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.test;

import java.util.ArrayList;

/**
 *
 * @author cbonilla
 */
public class Answers {
    private String answer = "";
    private ArrayList<String> academicProgram = new ArrayList<>();
    private ArrayList<Integer> valSum = new ArrayList<>();
    
    public Answers(){
        answer = "la respuesta es";
        academicProgram.add("1");
        academicProgram.add("2");
        academicProgram.add("3");
        valSum.add(2);
        valSum.add(1);
        valSum.add(3);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<String> getAcademicProgram() {
        ArrayList<String> tem = new ArrayList<>();
        for(int  i=0;i<academicProgram.size();i++){
            switch(Integer.parseInt(academicProgram.get(i))){
                case 1:
                    tem.add("Ingeniería de Sistemas");
                    break;
                case 2:
                    tem.add("Ingeniería Electrónica");
                    break;
                case 3:
                    tem.add("Economía");
                    break;
                case 4:
                    tem.add("Medicina");
                    break;
            }
        }
        return tem;
    }

    public void setAcademicProgram(ArrayList<String> academicProgram) {
        this.academicProgram = academicProgram;
    }

    public ArrayList<Integer> getValSum() {
        return valSum;
    }

    public void setValSum(ArrayList<Integer> valSum) {
        this.valSum = valSum;
    }
    
}
