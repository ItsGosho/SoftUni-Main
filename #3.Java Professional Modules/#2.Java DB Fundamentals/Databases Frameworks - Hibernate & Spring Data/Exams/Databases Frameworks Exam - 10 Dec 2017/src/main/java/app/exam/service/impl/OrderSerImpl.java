package app.exam.service.impl;

import app.exam.domain.dto.json.EmployeeOrdersJSONExportDTO;
import app.exam.domain.dto.xml.OrderItemXMLImportDTO;
import app.exam.domain.dto.xml.OrderXMLImportDTO;
import app.exam.domain.entities.Item;
import app.exam.domain.entities.Order;
import app.exam.domain.entities.OrderItem;
import app.exam.domain.entities.OrderType;
import app.exam.parser.interfaces.ModelParser;
import app.exam.parser.interfaces.Parser;
import app.exam.repository.EmployeeRepository;
import app.exam.repository.ItemsRepository;
import app.exam.repository.OrderItemRepository;
import app.exam.repository.OrderRepository;
import app.exam.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@Service
public class OrderSerImpl implements OrderService {

    @Autowired
    private ModelParser modelParser;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public void create(OrderXMLImportDTO dto) throws ParseException {
        boolean isGood=true;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        if(this.employeeRepository.findEmployeeByName(dto.getEmployee())!=null){
            for (OrderItemXMLImportDTO item : dto.getItems()) {
                if(this.itemsRepository.findItemByName(item.getName())==null){
                    isGood=false;
                }
            }
        }else{
            isGood=false;
        }
        if(isGood){
            Order order=new Order();
            order.setCustomer(dto.getCustomer());
            order.setEmployee(this.employeeRepository.findEmployeeByName(dto.getEmployee()));
            order.setOrderType(OrderType.valueOf(dto.getType()));
            order.setDate(sdf.parse(dto.getDate()));
            BigDecimal totalCost=new BigDecimal("0");
            order.setOrderItems(new LinkedList<>());
            for (OrderItemXMLImportDTO orderItemXMLImportDTO : dto.getItems()) {
                OrderItem orderItem=this.modelParser.convert(orderItemXMLImportDTO,OrderItem.class);
                orderItem.setItem(this.itemsRepository.findItemByName(orderItemXMLImportDTO.getName()));
                this.orderItemRepository.saveAndFlush(orderItem);
                //order.getOrderItems().add(orderItem);
            }
            order.setTotalPrice(totalCost);
            this.orderRepository.save(order);
        }else{
            throw new IllegalArgumentException("Bum");
        }
    }

    @Override
    public EmployeeOrdersJSONExportDTO exportOrdersByEmployeeAndOrderType(String employeeName, String orderType) {
        return null;
    }
}
