package app.query.api.projection;

import app.query.api.model.AccountResponseModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountProjection {

    private AccountMapper accountMapper;

    public AccountProjection(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @QueryHandler
    public AccountResponseModel handle(GetAccountQuery getAccountQuery) {
        AccountResponseModel model = new AccountResponseModel();
        AccountPo accountPo = accountMapper.getById(getAccountQuery.getId());
        BeanUtils.copyProperties(accountPo, model);

        return model;
    }

    @QueryHandler
    public List<AccountResponseModel> handle(GetAccountsQuery getAccountsQuery){
        List<AccountPo> listEntity = accountMapper.findAll();
        List<AccountResponseModel> listaccount = new ArrayList<>();
        listEntity.forEach(s -> {
            AccountResponseModel model = new AccountResponseModel();
            BeanUtils.copyProperties(s, model);
            listaccount.add(model);
        });
        return listaccount;
    }

}
