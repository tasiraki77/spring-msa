package com.example.account.controller;

import com.example.account.entity.Account;
import com.example.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping(value = "/account")
@RequiredArgsConstructor
class AccountController {

    @Autowired
    private final AccountRepository accountRepository;

    @GetMapping("")
    public Flux<Account> all() {
        return this.accountRepository.findAll();
    }

    @PostMapping("")
    public Mono<Account> create(@RequestBody Account account) {
        return this.accountRepository.save(account);
    }

    @GetMapping("/{id}")
    public Mono<Account> get(@PathVariable("id") Long id) {
        return this.accountRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Account> update(@PathVariable("id") Long id, @RequestBody Account account) {
        return this.accountRepository.findById(id)
                .map(p -> {
                    p.setUname(account.getUname());
                    p.setToken(account.getToken());
                    return p;
                })
                .flatMap(p -> this.accountRepository.save(p));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return this.accountRepository.deleteById(id);
    }
}
