package tk.roydgar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import tk.roydgar.model.entity.Client;
import tk.roydgar.model.service.ClientService;
import tk.roydgar.util.LoggerMessageBuilder;
import tk.roydgar.util.ValidatorUtil;
import tk.roydgar.util.constants.ParameterNames;
import tk.roydgar.util.constants.TemplatePaths;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static tk.roydgar.util.ModelAndViewUtil.createModelAndView;


@Controller
@Scope("prototype")
public class LoginController {

    private ClientService clientService;

    @Autowired
    public LoginController(ClientService clientService) {
        this.clientService = clientService;
    }

    public TemplateViewRoute handle = (Request request, Response response) -> {
        String login = request.queryParams(ParameterNames.USER_LOGIN);
        String password = request.queryParams(ParameterNames.PASSWORD);

        if (ValidatorUtil.parameterIsEmptyOrNull(login, password)) {
            return createModelAndView(TemplatePaths.LOGIN_FORM);
        }

        Optional<Client> client = clientService.login(login, password);

        if (!client.isPresent()) {
            return createModelAndView(TemplatePaths.LOGIN_FORM,
                    "Wrong login or password");
        }

        Map<String, String> model = new HashMap<>();
        model.put(ParameterNames.USER_LOGIN, login);
        model.put(ParameterNames.TEMPLATE, TemplatePaths.LOGIN_SUCCESS);

        return new ModelAndView(model, TemplatePaths.LAYOUT);
    };
}
