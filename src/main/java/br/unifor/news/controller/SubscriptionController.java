package br.unifor.news.controller;

import br.unifor.news.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }


    /*
    *
    * {
     *   "email": "carlosmendes@unifor.br",
     *   "categories": [ 1, 2, 3, 4 ]
     * }
    *
    * */
    @PostMapping
    public ResponseEntity<?> addSubscription(@RequestBody SubscriptionRequest subscriptionRequest) {
        subscriptionService.subscribe(subscriptionRequest.getEmail(), subscriptionRequest.getCategories());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
