package com.avwaveaf.accounts.service.impl;

import com.avwaveaf.accounts.constants.AccountConstants;
import com.avwaveaf.accounts.dto.CustomerDTO;
import com.avwaveaf.accounts.entity.Accounts;
import com.avwaveaf.accounts.entity.Customer;
import com.avwaveaf.accounts.mapper.CustomerMapper;
import com.avwaveaf.accounts.repository.AccountsRepository;
import com.avwaveaf.accounts.repository.CustomerRepository;
import com.avwaveaf.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     * Create Account Service
     *
     * @param customerDTO - Customer DTO Object
     */
    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer  = CustomerMapper.toEntity(customerDTO, new Customer());
        Customer sCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(sCustomer))
    }

    /**
     * (HELPER-MTHD)
     * Create New Account Object Helper which generate
     * automatic account number, setting default type and branch address
     * @param customer  [Object]
     * @return Accounts [NEW - Object]
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts accounts = Accounts.builder()
                .customerId(customer.getCustomerId())
                .accountNumber(1000000000L + new Random().nextInt(900000000))
                .accountType(AccountConstants.SAVINGS)
                .branchAddress(AccountConstants.ADDRESS)
                .build();
        return accounts;
    }

}
