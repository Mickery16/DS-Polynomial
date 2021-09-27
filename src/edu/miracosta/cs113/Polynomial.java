package edu.miracosta.cs113;

import java.util.LinkedList;

public class Polynomial {

     private LinkedList<Term> terms = new LinkedList<Term>();

     private LinkedList<Integer> currentExponents = new LinkedList<Integer>();

     public Polynomial() {

     }

     public Polynomial(Polynomial poly) {
          for (Term t : poly.getTerms()){
               terms.add(new Term(t.getCoefficient(), t.getExponent()));
          }

          for(int i : poly.getCurrentExponents()){
               currentExponents.add(i);
          }
     }

     public int getNumTerms() {
          return terms.size();
     }

     public void addTerm(Term term) {

          for(int i = 0; i < terms.size(); i++) {
               Term check = terms.get(i);
               if(check.getExponent() > term.getExponent()){
                    terms.add(i, term);
               } else if (check.getExponent() == term.getExponent()){
                    terms.set(i, term);
               }
          }
     }

     public Term getTerm(int i) {
          return terms.get(i);
     }

     public void clear () {
          terms.clear();
     }

     public int addCoefficients(Term first, Term second) {
          return first.getCoefficient() + second.getCoefficient();
     }

     public void add(Polynomial poly) {
          Polynomial copy = new Polynomial(this);

          for(Term t : poly.getTerms()) {
               copy.addTerm(t);
          }

          System.out.println(this + " + " + poly + " = " + copy);
     }

     public LinkedList<Term> getTerms() {
          return terms;
     }

     public void setTerms(LinkedList<Term> terms) {
          this.terms = terms;
     }

     public LinkedList<Integer> getCurrentExponents() {
          return currentExponents;
     }

     @Override
     public String toString () {
          String output = "";
          for(Term t : terms) {
               output += (t.getCoefficient() > 0 && terms.getFirst() != t ? "+" : "") + t.getCoefficient() + "x^" + t.getExponent();
          }
          return output;
     }
}
