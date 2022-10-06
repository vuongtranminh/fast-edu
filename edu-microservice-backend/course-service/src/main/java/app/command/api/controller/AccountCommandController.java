package app.command.api.controller;

import app.command.api.model.AccountRequestModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountCommandController {

    public String save(@RequestBody AccountRequestModel model);

    public String update(@RequestBody AccountRequestModel model);

    public String delete(@PathVariable Integer id);

}
