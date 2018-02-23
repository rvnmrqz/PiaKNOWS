package com.example.kantu.piaknows;

import java.util.ArrayList;
import java.util.Random;

public class QuizGenerator {


    public static ArrayList<Class> itemlist;
    public static int glb_quizSet;


    public static void startQuiz(int quizSet){

        MyScore.score = 0;
        glb_quizSet = quizSet;
        itemlist = new ArrayList<>();

        switch (quizSet){
            case 1:
                //set 1
                itemlist.add(q1.class);
                itemlist.add(q2.class);
                itemlist.add(q3.class);
                itemlist.add(q4.class);
                itemlist.add(q5.class);
                itemlist.add(q6.class);
                itemlist.add(q7.class);
                itemlist.add(q8.class);
                itemlist.add(q9.class);
                itemlist.add(q10.class);
                //pwede ka pa magdagdag ng quiz item dagdag mo lang dito
                break;
            case 2:
                //set 2
                break;
            case 3:
                //set 3
                break;
            //pwede ka pa magdagdag ng ibang set lagay mo lang dito
        }
    }

    public static Class nextQuestion(){
        Random rand = new Random();
        if(itemlist.size()>0){
             int index = rand.nextInt(itemlist.size());
             Class classTOreturn = itemlist.get(index);
             itemlist.remove(index);
             return classTOreturn;
        }else{
            return null;
        }
    }

}
