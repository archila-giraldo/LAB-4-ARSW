package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.Filter;
import java.util.*;

public class FiltroRedundante implements Filter {

    @Override
    public Blueprint filtro(Blueprint bp){
        List<Point> points = new ArrayList<>();
        List<Point> pts = bp.getPoints();
        return bp;
    }
}
