package app.exam.terminal;

import app.exam.config.Config;
import app.exam.controller.EmployeesController;
import app.exam.controller.ItemsController;
import app.exam.controller.OrdersController;
import app.exam.domain.dto.xml.OrderItemXMLImportDTO;
import app.exam.domain.dto.xml.OrderWrapperXMLImportDTO;
import app.exam.domain.dto.xml.OrderXMLImportDTO;
import app.exam.parser.XMLParser;
import app.exam.parser.interfaces.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private EmployeesController employeesController;
    @Autowired
    private ItemsController itemsController;
    @Autowired
    private OrdersController ordersController;

    @Override
    public void run(String... args) throws Exception {
        //System.out.println(this.employeesController.importDataFromJSON(Config.EMPLOYEES_IMPORT_JSON));
        //System.out.println(this.itemsController.importDataFromJSON(Config.ITEMS_IMPORT_JSON));
        //System.out.println(this.ordersController.importDataFromXML(Config.ORDERS_IMPORT_XML));

    }
}
