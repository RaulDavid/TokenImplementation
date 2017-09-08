package app.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Raul
 */
@RestController
public class CheckedController {

    @RequestMapping(value = "/checked", method = RequestMethod.GET)
    public String listarTodasCategorias() {
        return "Success, here is checked";
    }

}
