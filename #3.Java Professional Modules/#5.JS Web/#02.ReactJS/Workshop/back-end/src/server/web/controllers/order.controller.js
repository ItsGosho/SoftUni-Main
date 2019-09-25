import Express from "express";
import {OrderRoutingURLs} from "../../constants/web/routing.urls.constants";

const Router = Express.Router();

Router.post(OrderRoutingURLs.CREATE,(request,response)=>{
    /*
    * TODO:
    *  1.Дали user-a е логнат
    *  2.Взимама от body-то всички ID-та на продуктите като масив
    *  3.Извиквам сървиса и създавам нов Order с User-a и продуктите
    *  4.Respond-вам successful с "Order has been created!"
    * */
});

Router.post(OrderRoutingURLs.MY,(request,response)=>{
    /*
    * TODO:
    *  1.Дали user-a е логнат
    *  2.Взимама от body-то всички ID-та на продуктите като масив
    *  3.Извиквам сървиса и създавам нов Order с User-a и продуктите
    *  4.Respond-вам successful с "Order has been created!"
    * */
});