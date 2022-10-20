package app.query.api.controller;

import app.query.api.model.AccountResponseModel;
import app.query.api.queries.GetAccountQuery;
import app.query.api.queries.GetAccountsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountQueryController {

    private QueryGateway queryGateway;

    public AccountQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{accountId}")
    public AccountResponseModel getAccountDetail(@PathVariable String accountId) {
        GetAccountQuery getAccountQuery = new GetAccountQuery();
        getAccountQuery.setId(accountId);

        AccountResponseModel accountResponseModel = queryGateway.query(getAccountQuery, ResponseTypes.instanceOf(AccountResponseModel.class))
                        .join();

        return accountResponseModel;
    }
    @GetMapping
    public List<AccountResponseModel> getAllAccounts(){
        GetAccountsQuery getAccountsQuery = new GetAccountsQuery();
        List<AccountResponseModel> list = queryGateway.query(getAccountsQuery, ResponseTypes.multipleInstancesOf(AccountResponseModel.class))
                .join();
        return list;
    }

}
