package app.command.api.events.impl;

import app.command.api.data.dao.AccountMapper;
import app.command.api.data.entity.AccountPo;
import app.command.api.events.AccountCreatedEvent;
import app.command.api.events.AccountDeletedEvent;
import app.command.api.events.AccountEventsHandler;
import app.command.api.events.AccountUpdatedEvent;
import app.config.EventsHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@EventsHandler
public class AccountEventsHandlerImpl implements AccountEventsHandler {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void on(AccountCreatedEvent event) {
        AccountPo accountPo = new AccountPo();
        BeanUtils.copyProperties(event, accountPo);
        accountMapper.save(accountPo);
    }

    @Override
    public void on(AccountUpdatedEvent event) {
        AccountPo accountPo = accountMapper.getById(event.getId());
        BeanUtils.copyProperties(event, accountPo);
        accountMapper.updateById(accountPo);
    }

    @Override
    public void on(AccountDeletedEvent event) {
        accountMapper.deleteById(event.getId());
    }

}
