package io.ilss.transaction.onedatasource.web;

import io.ilss.transaction.onedatasource.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author feng
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/transfer/annotation")
    public String transferAnnotation(Long source, Long target, String amount) {
        return accountService.transferAnnotation(source, target, new BigDecimal(amount));
    }

    @GetMapping("/transfer/code")
    public String transferCode(Long source, Long target, String amount) {
        return accountService.transferCode(source, target, new BigDecimal(amount));
    }

    @GetMapping("/list")
    public List list() {
        return accountService.listAll();
    }
}
