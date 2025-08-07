package com.example.testmodule4.controller;

import com.example.testmodule4.service.CustomerService;
import org.springframework.ui.Model;
import com.example.testmodule4.model.Transaction;

import com.example.testmodule4.service.TransactionService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final CustomerService customerService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("transactions", transactionService.findAll());
        return "transaction_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "transaction_form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("transaction") @Validated Transaction transaction,
                      BindingResult result) {
        if (result.hasErrors()) {
            return "transaction_form";
        }

        transactionService.save(transaction);

        return "redirect:/transactions";
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        Transaction transaction = transactionService.findById(id);
        if (transaction == null) {
            return "transactions";
        }
        model.addAttribute("transaction", transaction);
        return "transaction_detail";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        transactionService.delete(id);
        return "transaction_list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) String name,
                         @RequestParam(required = false) String type,
                         Model model) {

        if (name != null && name.trim().isEmpty()) {
            name = null;
        }
        if (type != null && type.trim().isEmpty()) {
            type = null;
        }

        model.addAttribute("transactions", transactionService.search(name, type));
        return "transaction_list";
    }


}


