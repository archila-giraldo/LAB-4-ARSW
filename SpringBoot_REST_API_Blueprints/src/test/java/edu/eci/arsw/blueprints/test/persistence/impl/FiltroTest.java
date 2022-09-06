package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.Filter;
import edu.eci.arsw.blueprints.persistence.impl.FiltroRedundante;
import edu.eci.arsw.blueprints.persistence.impl.Tuple;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import java.util.*;

public class FiltroTest {



    @Test
    /**
     * Verificamos que el filtro elimina la redundancia de los puntos
     */
    public void shouldFilterRedundancy() throws BlueprintPersistenceException, BlueprintNotFoundException {
        BlueprintsServices bps = new BlueprintsServices();
        List<Point> pts = new ArrayList<>();
        List<Point> pts2;
        List<Point> noRedundancyPoints = new ArrayList<>();
        Random rm = new Random();
        Blueprint bp;
        Blueprint bp2;

        boolean equals = true;
        //Poblamos las listas de puntos con datos repetidos y una sin datos repetidos
        for (int i = 0; i < 5; i ++){
            int x = rm.nextInt(10);
            int y = rm.nextInt(10);
            noRedundancyPoints.add(new Point(x,y));
            pts.add(new Point(x,y));
            pts.add(new Point(x,y));
            pts.add(new Point(x,y));
        }
        //Creamos la blueprint para aplicar el filtro
        bp = new Blueprint("Prueba 1","Prueba 1",pts);
        bps.addNewBlueprint(bp);
        bp = bps.getBlueprint("Prueba1","Prueba1");
        pts = bp.getPoints();
        //Creamos una segunda blueprint en vez de comparar los datos directamente dado a que el metodo de filtrado tambien los ordena
        //y de esta forma es mas sencilla la comparación
        bp2 = new Blueprint("Prueba 2","Prueba 2",noRedundancyPoints);
        bps.addNewBlueprint(bp2);
        bp2 = bps.getBlueprint("Prueba 2","Prueba 2");
        pts2 = bp2.getPoints();

        //Comparamos dato por dato las dos listas de puntos dado que son ordenadas
        for (int i = 0; i < bp.getPoints().size();i++){
            Point pt = pts.get(i);
            Point pt2 = pts2.get(i);
            if (!new Tuple<>(pt.getX(),pt.getY()).equals(new Tuple<>(pt2.getX(),pt2.getY()))){
                equals = false;
            }
        }
        assertTrue(equals);
    }

    @Test
    public void shouldFilterSubSampling() throws BlueprintPersistenceException, BlueprintNotFoundException {
        BlueprintsServices bps = new BlueprintsServices();
        List<Point> pts = new ArrayList<>();
        List<Point> subSamplePoints = new ArrayList<>();
        Random rm = new Random();
        Blueprint bp;
        boolean equals = true;

        for (int i = 0; i < 5; i ++){
            int x = rm.nextInt(10);
            int y = rm.nextInt(10);
            if (i % 2 == 0){
                subSamplePoints.add(new Point(x,y));
            }
            pts.add(new Point(x,y));
        }

        bp = new Blueprint("Prueba 1","Prueba 1",pts);
        bps.addNewBlueprint(bp);
        bp = bps.getBlueprint("Prueba1","Prueba1");
        pts = bp.getPoints();

        for(int i = 0; i < pts.size();i++){
            Point pt = pts.get(i);
            Point pt2 = subSamplePoints.get(i);
            if (!new Tuple<>(pt.getX(),pt.getY()).equals(new Tuple<>(pt2.getX(),pt2.getY()))){
                equals = false;
            }
        }
        assertTrue(equals);
    }

}
