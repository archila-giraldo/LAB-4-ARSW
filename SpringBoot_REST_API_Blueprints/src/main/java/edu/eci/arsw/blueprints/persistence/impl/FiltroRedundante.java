package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.Filter;
import java.util.*;

/**
 * Clase que nos va a permitir eliminar la redundancia de los puntos en una blueprint
 */
public class FiltroRedundante implements Filter {

    /**
     * Metodo que filtra los puntos para que no queden valores repetidos
     * @param bp Blueprint que vamos a filtrar
     * @return Blueprint resultante despues del fitlrado
     */
    @Override
    public Blueprint filtro(Blueprint bp){
        List<Point> uniquePoints = new ArrayList<>();
        List<Point> points = bp.getPoints();
        Set<Tuple<Integer,Integer>> pointsSet = new HashSet<>();
        for (Point pt:points){
            Tuple<Integer,Integer> tp = new Tuple<>(pt.getX(),pt.getY());
            pointsSet.add(tp);
        }
        for (Tuple<Integer,Integer> tp:pointsSet){
            uniquePoints.add(new Point(tp.getElem1(),tp.getElem2()));
        }
        bp.setPoints(uniquePoints);
        return bp;
    }
}
