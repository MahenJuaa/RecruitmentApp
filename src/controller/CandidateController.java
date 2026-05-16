/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CandidateDAO;
import java.util.List;
import model.Candidate;

public class CandidateController {

    CandidateDAO dao = new CandidateDAO();

    public void insert(Candidate c) {
        dao.insert(c);
    }

    public void update(Candidate c) {
        dao.update(c);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public List<Candidate> getAll() {
        return dao.getAll();
    }
}