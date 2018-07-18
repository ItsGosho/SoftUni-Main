package app.exam.controller;

import app.exam.domain.dto.xml.OrderWrapperXMLImportDTO;
import app.exam.domain.dto.xml.OrderXMLImportDTO;
import app.exam.parser.JSONParser;
import app.exam.parser.XMLParser;
import app.exam.parser.interfaces.Parser;
import app.exam.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;

    public String importDataFromXML(String xmlContent) throws IOException, JAXBException {
        Parser xmlParser=new XMLParser();
        OrderWrapperXMLImportDTO orders = xmlParser.read(OrderWrapperXMLImportDTO.class,xmlContent);
        List<String> toReturn=new LinkedList<>();
        for (OrderXMLImportDTO order : orders.getOrders()) {
            try{
                this.orderService.create(order);
                toReturn.add(String.format("Order for %s on %s added.",order.getCustomer(),order.getDate()));
            }catch (Exception ex){
                //toReturn.add(String.format("Error: Invalid data."));
                System.out.println(ex.getMessage());
            }
        }
        String finalRet="";
        for (String s : toReturn) {
            finalRet+=String.format("%s%n",s);
        }
        return finalRet;
    }

    public String exportOrdersByEmployeeAndOrderType(String employeeName, String orderType) {
       return null;
    }
}
