package main.controllers;

import main.entities.Order;
import main.entities.Product;
import main.entities.ProductType;
import main.entities.User;
import main.models.binding.OrderBindingModel;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summermvc.api.*;
import main.repositories.OrderRepository;
import main.repositories.ProductRepository;
import main.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProductController extends BaseController {
    private UserRepository userRepository;

    private ProductRepository productRepository;

    private OrderRepository orderRepository;

    public ProductController() {
        this.userRepository = new UserRepository();
        this.productRepository = new ProductRepository();
        this.orderRepository = new OrderRepository();
    }

    @GetMapping(route = "/products/details/{id}")
    public String details(@PathVariable(name = "id") String id, HttpSoletRequest request, Model model) {

        if (!super.isLoggedIn(request)) {
            return super.redirect("login");
        }

        Product foundProduct = this.productRepository.findById(id);

        if(foundProduct == null) {
            return super.redirect("home");
        }

        model.addAttribute("id", foundProduct.getId());
        model.addAttribute("name", foundProduct.getName());
        model.addAttribute("price", foundProduct.getPrice());
        model.addAttribute("type", foundProduct.getType().toString());
        model.addAttribute("description", foundProduct.getDescription());

        if(super.getRole(request).name().equals("ADMIN")){
             return super.view("product-details-admin");
        }else{
            return super.view("product-details");
        }
    }

    @GetMapping(route = "/products/edit/{id}")
    public String edit(@PathVariable(name = "id") String id, HttpSoletRequest request, Model model) {

        if (!super.isLoggedIn(request)) {
            return super.redirect("login");
        }

        Product foundProduct = this.productRepository.findById(id);

        if(foundProduct == null) {
            return super.redirect("home");
        }

        model.addAttribute("name", foundProduct.getName());
        model.addAttribute("price", foundProduct.getPrice());
        model.addAttribute("type", foundProduct.getType().toString());
        model.addAttribute("description", foundProduct.getDescription());

        if(super.getRole(request).name().equals("ADMIN")){
            model.addAttribute("id",foundProduct.getId());
            return super.view("products-edit");
        }else{
            return super.view("product-details");
        }
    }

    @GetMapping(route = "/products/order/{id}")
    public String order(@PathVariable(name = "id") String id, HttpSoletRequest request) {
        if (!super.isLoggedIn(request)) {
            return super.redirect("login");
        }

        String currentUserId = request.getSession().getAttributes().get("user-id").toString();

        User currentUser = this.userRepository.findById(currentUserId);
        Product currentProduct = this.productRepository.findById(id);

        if(currentUser == null || currentProduct == null) {
            return super.redirect("home");
        }

        Order order = new Order();

        order.setClient(currentUser);
        order.setProduct(currentProduct);
        order.setOrderedOn(LocalDateTime.now());

        this.orderRepository.createOrder(order);

        return super.redirect("home");
    }

    @GetMapping(route = "/products/create")
    public String createProduct(HttpSoletRequest request,Model model){
        if(super.getRole(request).name().equals("ADMIN")){
            return super.view("product-create");
        }else{
            return super.view("user-home");
        }
    }

    @GetMapping(route = "/orders/all")
    public String allOrders(HttpSoletRequest request,Model model){
        if(super.getRole(request).name().equals("ADMIN")){
            return super.view("orders-all");
        }else{
            return super.view("user-home");
        }
    }
    @PostMapping(route = "/products/create")
    public String createProductPost(OrderBindingModel orderBindingModel, HttpSoletRequest request, Model model,BindingResult bindingResult){
        if(super.getRole(request).name().equals("ADMIN")){
            if(orderBindingModel.getName()==null ||
            orderBindingModel.getDescription()==null ||
            orderBindingModel.getInlineRadioOptions() == null){
                return super.view("product-create");
            }
            if(bindingResult.hasErrors()){
                return super.view("product-create");
            }

            Product product = new Product();
            product.setName(orderBindingModel.getName());
            product.setDescription(orderBindingModel.getDescription());
            product.setPrice(orderBindingModel.getPrice());
            product.setType(determiteProductType(orderBindingModel));
            this.productRepository.createProduct(product);
            return super.view("home");
        }else{
            return super.view("home");
        }
    }

    @PostMapping(route = "/products/edit/{id}")
    public String editProductPost(@PathVariable(name = "id") String id,OrderBindingModel orderBindingModel, HttpSoletRequest request, Model model,BindingResult bindingResult){
        System.out.println("In Post:Edit");
        if(!bindingResult.hasErrors()){
           Product product = this.productRepository.findById(id);
           product.setName(orderBindingModel.getName());
           product.setDescription(orderBindingModel.getDescription());
           product.setType(determiteProductType(orderBindingModel));
           product.setPrice(orderBindingModel.getPrice());
           this.productRepository.createProduct(product);
           return super.redirect("localhost:8000/admin-home");
       }
       return super.redirect("/products/edit/"+id);
    }

    private ProductType determiteProductType(OrderBindingModel orderBindingModel){
        if(orderBindingModel.getInlineRadioOptions().equals("option1")){
            //Other
            return ProductType.OTHER;
        }else if(orderBindingModel.getInlineRadioOptions().equals("option2")){
            //Cosmetic
            return ProductType.COSMETIC;
        }else if(orderBindingModel.getInlineRadioOptions().equals("option3")){
            //Health
            return ProductType.HEALTH;
        }else if(orderBindingModel.getInlineRadioOptions().equals("option4")){
            //Domestic
            return ProductType.DOMESTIC;
        }else if(orderBindingModel.getInlineRadioOptions().equals("option5")){
            //Food
            return ProductType.FOOD;
        }
        throw new IllegalArgumentException("That product type doesn`t exist :/");
    }
}
