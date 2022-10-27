package app.command.api.events.impl;

import app.command.api.events.AccountEventsHandler;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountEventsHandlerImpl implements AccountEventsHandler {

    private AccountMapper accountMapper;

    public AccountEventsHandlerImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    @EventHandler
    public void on(AccountCreatedEvent event) {
        AccountPo accountPo = new AccountPo();
        BeanUtils.copyProperties(event, accountPo);
        accountMapper.save(accountPo);
    }

    @Override
    @EventHandler
    public void on(AccountUpdatedEvent event) {
        AccountPo accountPo = accountMapper.getById(event.getId());
        BeanUtils.copyProperties(event, accountPo);
        accountMapper.updateById(accountPo);
    }

    @Override
    @EventHandler
    public void on(AccountDeletedEvent event) {
        accountMapper.deleteById(event.getId());
    }

}
