package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.ShoppingCartApplicationTest;
import com.lambdaschool.shoppingcart.exceptions.ResourceNotFoundException;
import com.lambdaschool.shoppingcart.models.*;
import com.lambdaschool.shoppingcart.repository.CartItemRepository;
import com.lambdaschool.shoppingcart.repository.ProductRepository;
import com.lambdaschool.shoppingcart.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingCartApplicationTest.class,
    properties = {"command.line.runner.enabled=false"})
public class CartItemServiceImplUnitTestNoDB {
    @Autowired
    private CartItemService cartItemService;

    @MockBean
    private UserRepository userrepos;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private CartItemRepository cartItemRepository;

    private List<User> userList;
    private List<Product> productList;

    @Before
    public void setUp() throws Exception {
        userList = new ArrayList<>();
        productList = new ArrayList<>();

        User u1 = new User("barnbarn",
                "LambdaLlama",
                "barnbarn@host.local",
                "added via seed data");
        u1.setUserid(1);
        userList.add(u1);

        User u2 = new User("cinnamon",
                "LambdaLlama",
                "cinnamon@host.local",
                "added via seed data");
        u2.setUserid(2);
        userList.add(u2);

        User u3 = new User("stumps",
                "LambdaLlama",
                "stumps@host.local",
                "added via seed data");
        u3.setUserid(3);
        userList.add(u3);

        // Adding Products

        Product p1 = new Product();
        p1.setName("PEN");
        p1.setDescription("MAKES WORDS");
        p1.setPrice(2.50);
        p1.setComments("added via seed data");

        Product p2 = new Product();
        p2.setName("PENCIL");
        p2.setDescription("DOES MATH");
        p2.setPrice(1.50);
        p2.setComments("added via seed data");

        Product p3 = new Product();
        p3.setName("COFFEE");
        p3.setDescription("EVERYONE NEEDS COFFEE");
        p3.setPrice(4.00);
        p3.setComments("added via seed data");

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);

        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addToCart() throws Exception {
    }

    @Test
    public void removeFromCart() {
    }
}