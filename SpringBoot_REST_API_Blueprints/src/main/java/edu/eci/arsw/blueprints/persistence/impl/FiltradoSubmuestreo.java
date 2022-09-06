package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.Filter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
/**
 * Clase que implementa filter y suprime 1 de cada 2 puntos del plano, de manera intercalada.
 */
public class FiltradoSubmuestreo implements Filter {
    /**
     * Filtrado que suprime 1 de cada 2 puntos del plano, de manera intercalada.
     * @param blueprint a filtrar
     * @return Blueprint filtrada
     */
    @Override
    public Blueprint filtro(Blueprint blueprint) {
        List<Point> pts = blueprint.getPoints();
        List<Point> pts2 = new ArrayList<>();
        for (int i = 0;i < pts.size(); i++){
            if(i % 2 == 0){
                pts2.add(pts.get(i));
            }
        }
        blueprint.setPoints(pts2);
        return blueprint;
    }
}
