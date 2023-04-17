package net.payrdr.demotest.controller;

import jakarta.annotation.Resource;
import net.payrdr.demotest.entity.Account;
import net.payrdr.demotest.service.AccountService;
import net.payrdr.demotest.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private AccountService accountService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/deposit")
    public void deposit(@RequestParam Long fromId, @RequestParam Long toId, @RequestParam Long sum) {
        Account accFrom = accountService.get(fromId);
        Account accTo = accountService.get(toId);
        if (accFrom != null && accTo != null && accFrom.getSum() >= sum) {
            Long oldAccFromSum = accFrom.getSum();
            accFrom.setSum(oldAccFromSum - sum);
            Long oldAccToSum = accTo.getSum();
            accTo.setSum(oldAccToSum + sum);
        }
    }







    @GetMapping("get")
    public Long get(@RequestParam String username, @RequestParam String password, @RequestParam Long accId) {
        //TODO AuthService
        return accountService.get(accId).getSum();
    }








    @GetMapping("notify")
    public void notify(@RequestParam Long accId) {
        notificationService.sendNotification(accId);
    }


}
