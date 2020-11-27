package com.mobproj.guessnow.not_used;

public class Questions {

    public String mQuestions[] = {
            "This animal is so small, it's black and so smelly. What is it ?",
            "This animal is so huge, it's black and live in ocean. What is it ?",
            "This animal is so small, it's hairy  and voiced meow. What is it ?",
            "This animal is so huge, it's black and have  a trunk . What is it ?",
            "This animal is so small, it's white and eat seed. What is it ?",
            "This animal is so huge, it's striped and so creppy. What is it ?",
            "This animal is so small, it's black and have milk. What is it ?",
            "This animal is so huge, it's herbivora and have milk. What is it ?",
            "This animal is so small, it's red and have claws. What is it ?",



    };

    private String mChoices[] [] = {
            {"Rat","Cat","Elephant","Cow"},
            {"Rat","Squid","Whale","Dolphine"},
            {"Rat","Cat","Elephant","Goat"},
            {"Rat","Cat","Elephant","Snake"},
            {"Hamster","Cat","Elephant","Hippo"},
            {"Rat","Cat","Tiger","Deer"},
            {"Rat","Cat","Dog","Crocodile"},
            {"Rat","Cat","Cow","Crocodile"},
            {"Rat","Cat","Crabs","Crocodile"}

    };

    private String mCorrectAnswers[] = {"Rat","Whale","Cat","Elephant","Hamster","Tiger","Dog","Cow","Crabs"};

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }
    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }
    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }
    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
