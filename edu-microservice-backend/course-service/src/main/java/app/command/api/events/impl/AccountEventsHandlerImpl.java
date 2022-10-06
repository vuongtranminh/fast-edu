package app.command.api.events.impl;

import app.command.api.data.AccountDao;
import app.command.api.data.AccountPo;
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
    private AccountDao accountDao;

    @Override
    public void on(AccountCreatedEvent event) {
        AccountPo accountPo = new AccountPo();
        BeanUtils.copyProperties(event, accountPo);
        accountDao.save(accountPo);
    }

    @Override
    public void on(AccountUpdatedEvent event) {
        AccountPo accountPo = accountDao.getById(event.getId());
        BeanUtils.copyProperties(event, accountPo);
        accountDao.updateById(accountPo);
    }

    @Override
    public void on(AccountDeletedEvent event) {
        accountDao.deleteById(event.getId());
    }

}
