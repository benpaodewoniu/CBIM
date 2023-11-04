package com.cbim.cbim.contorller;

import com.cbim.sourcebase.entity.rest.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.cbim.cbim.global.ServiceGlobal.accountModelGlobalEntityList;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Result queryUser() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(accountModelGlobalEntityList);
        return result;
    }
}
