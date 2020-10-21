package com.groupal.libreriaPrismaBackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "${angular.cross-origin}")
@RestController
@RequestMapping("/api/admin")
public class CartController {

}
