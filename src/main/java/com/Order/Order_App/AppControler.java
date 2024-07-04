package com.Order.Order_App;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppControler {

    @Controller
    public class HomeController {
        @GetMapping("/")
        public String dashboard() {
            return "dashboard";
        }

        @GetMapping("/addcategory")
        public String Addcategory( ) {

            return "addcategory"; // This should match the name of your HTML template
        }

        @GetMapping("/addproduct")
        public String AddProduct( ) {

            return "addproduct"; // This should match the name of your HTML template
        }



    }

}
