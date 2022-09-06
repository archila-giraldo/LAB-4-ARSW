package edu.eci.arsw.blueprints.Main;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String a[]) throws BlueprintNotFoundException, BlueprintPersistenceException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bluePrintService = ac.getBean(BlueprintsServices.class);
        Point[] pnts = new Point[]{new Point(1,2)};
        Blueprint blueprint = new Blueprint("Camilo", "blueprint", pnts);
        bluePrintService.addNewBlueprint(blueprint);
        System.out.println(bluePrintService.getBlueprintsByAuthor("Camilo"));
    }

}
