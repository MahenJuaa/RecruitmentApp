/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import interfaces.CandidateInterface;

public class Candidate implements CandidateInterface {

    private int id;
    private String name;
    private String path;
    private double writing;
    private double coding;
    private double interview;

    public Candidate() {
    }

    public Candidate(String name, String path,
            double writing, double coding, double interview) {

        this.name = name;
        this.path = path;
        this.writing = writing;
        this.coding = coding;
        this.interview = interview;
    }

    @Override
    public double calculateScore() {
        return (writing + coding + interview) / 3;
    }

    @Override
    public String getStatus() {
        return calculateScore() >= 85 ? "DITERIMA" : "TIDAK DITERIMA";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public double getWriting() {
        return writing;
    }

    public double getCoding() {
        return coding;
    }

    public double getInterview() {
        return interview;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setWriting(double writing) {
        this.writing = writing;
    }

    public void setCoding(double coding) {
        this.coding = coding;
    }

    public void setInterview(double interview) {
        this.interview = interview;
    }
}
