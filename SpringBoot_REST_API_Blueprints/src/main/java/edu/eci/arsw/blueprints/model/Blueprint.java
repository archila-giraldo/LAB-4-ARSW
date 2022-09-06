
package edu.eci.arsw.blueprints.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Blueprint {

    private String author=null;
    
    private List<Point> points=null;
    
    private String name=null;

    /**
     * Método constructor que nos sirve para crear una blueprint con una lista primitiva
     * @param author Nombre del autor
     * @param name Nombre de la blueprint
     * @param pnts Lista de los puntos
     */
    public Blueprint(String author,String name,Point[] pnts){
        this.author=author;
        this.name=name;
        points=Arrays.asList(pnts);
    }

    /**
     * Método constructor que nos sirve para crear una blueprint con una lista de tipo List
     * @param author Nombre del autor
     * @param name Nombre de la blueprint
     * @param pnts Lista de los puntos
     */
    public Blueprint(String author,String name,List<Point> pnts){
        this.author=author;
        this.name=name;
        points=pnts;
    }

    /**
     * Método constructor que nos sirve para crear una blueprint sin lista de puntos
     * @param author Nombre del autor
     * @param name Nombre de la blueprint
     */
    public Blueprint(String author, String name){
        this.author = author;
        this.name=name;
        points=new ArrayList<>();
    }

    
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
    
    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points){
        this.points = points;
    }
    
    public void addPoint(Point p){
        this.points.add(p);
    }

    @Override
    public String toString() {
        return "Blueprint{" + "author=" + author + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Blueprint other = (Blueprint) obj;
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.points.size()!=other.points.size()){
            return false;
        }
        for (int i=0;i<this.points.size();i++){
            if (this.points.get(i)!=other.points.get(i)){
                return false;
            }
        }
        
        return true;
    }
    
    
    
}
