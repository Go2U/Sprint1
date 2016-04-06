/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.test;

import edu.eci.cosw.Go2U.model.universities.Carrer;
import java.util.ArrayList;

/**
 *
 * @author cbonilla
 */
public class Answers {
    private String answer = "";
    private ArrayList<String> IdcademicProgram = new ArrayList<>();
    private ArrayList<Carrer> academicProgramC = new ArrayList<>();
    private ArrayList<Integer> valSum = new ArrayList<>();
    
    public Answers(){
        Carrer tem = new Carrer("Ing Sistemas", "unoH");
        tem.setId(1000);
        academicProgramC.add(tem);
        tem = new Carrer("Ing electrónica", "dosH");
        tem.setId(1001);
        academicProgramC.add(tem);
        tem =new Carrer("Economia", "tresH");
        tem.setId(1002);
        academicProgramC.add(tem);
        tem =new Carrer("Medicina", "CuatroH");
        tem.setId(1003);
        academicProgramC.add(tem);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<String> getAcademicProgram() {
        ArrayList<String> tem = new ArrayList<>();
        for(int  j=0;j<IdcademicProgram.size();j++){
            for(int  i=0;i<academicProgramC.size();i++){
                if(Integer.parseInt(IdcademicProgram.get(j))==academicProgramC.get(i).getId()){
                    tem.add(academicProgramC.get(i).getName());
                }
            }
        }
        return tem;
    }

    public void setAcademicProgram(ArrayList<String> academicProgram) {
        this.IdcademicProgram = academicProgram;
    }

    public ArrayList<Integer> getValSum() {
        return valSum;
    }

    public void setValSum(ArrayList<Integer> valSum) {
        this.valSum = valSum;
    }
    
}
